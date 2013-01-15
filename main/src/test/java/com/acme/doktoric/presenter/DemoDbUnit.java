package com.acme.doktoric.presenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

public class DemoDbUnit {
	 private static String _testDir        	= "testData";
	    private static String _dbFile         = "dbDump.xml";
	    private static String _driverClass    = "org.apache.derby.jdbc.EmbeddedDriver";
	    private static String _jdbcConnection = "jdbc:derby:testdb";
	    private static String _testTableName  = "person";
	
	    
	    @Before
	    public static void fullDatabaseExport(File file) throws     ClassNotFoundException,
	                                                                DatabaseUnitException,
	                                                                DataSetException,
	                                                                IOException, 
	                                                                SQLException {
	        IDatabaseConnection connection = getConnection();
	
	        ITableFilter filter = new DatabaseSequenceFilter(connection);
	        IDataSet dataset    = new FilteredDataSet(filter, connection.createDataSet());
	        FlatXmlDataSet.write(dataset, new FileOutputStream(file));
	    }
	    public static void fullDatabaseImport(File file) throws     ClassNotFoundException, 
	                                                                DatabaseUnitException, 
	                                                                IOException,
	                                                                SQLException {
	        IDatabaseConnection connection = getConnection();
	        IDataSet dataSet = new FlatXmlDataSet(file, true);
	
	        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
	    }
	    public static IDatabaseConnection getConnection() throws     ClassNotFoundException, 
	                                                                DatabaseUnitException, 
	                                                                SQLException {
	        // database connection
	        Class driverClass = Class.forName(_driverClass);
	        Connection jdbcConnection = DriverManager.getConnection(_jdbcConnection);
	        return new DatabaseConnection(jdbcConnection);
	    }
	    
	    
	    @Test
	    public void test5_Test() throws ClassNotFoundException, 
	                                    DatabaseUnitException, 
	                                    IOException, 
	                                    SQLException {
	        fullDatabaseImport(new File(_testDir, _dbFile));
	        ITable actualTable = getConnection().createDataSet().getTable(_testTableName);
	
	        @SuppressWarnings("deprecation")
			IDataSet expectedDataSet = new FlatXmlDataSet(new File(_testDir, _dbFile));
	        ITable expectedTable = expectedDataSet.getTable(_testTableName);
	        Assertion.assertEquals(expectedTable, actualTable);
	    }
	
	    
	    
}

