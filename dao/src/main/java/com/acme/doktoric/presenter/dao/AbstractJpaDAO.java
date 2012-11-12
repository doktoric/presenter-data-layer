package com.acme.doktoric.presenter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.acme.doktoric.presenter.logger.Loggable;

public class AbstractJpaDAO<T> implements IAbstractJpaDAO<T> {
	private Class<T> clazz;

	@PersistenceContext
	protected EntityManager entityManager;
	
	

	/* (non-Javadoc)
	 * @see com.acme.doktoric.presenter.dal.dao.IAbstractJpaDAO#setClazz(java.lang.Class)
	 */
	@Loggable
	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	/* (non-Javadoc)
	 * @see com.acme.doktoric.presenter.dal.dao.IAbstractJpaDAO#findOne(java.lang.Long)
	 */
	@Loggable
	public T findOne(final Long id) {
		return entityManager.find(clazz, id);
	}

	/* (non-Javadoc)
	 * @see com.acme.doktoric.presenter.dal.dao.IAbstractJpaDAO#findAll()
	 */
	@Loggable
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName())
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.acme.doktoric.presenter.dal.dao.IAbstractJpaDAO#save(T)
	 */
	@Loggable
	public void save(final T entity) {
		entityManager.persist(entity);
	}

	/* (non-Javadoc)
	 * @see com.acme.doktoric.presenter.dal.dao.IAbstractJpaDAO#update(T)
	 */
	@Loggable
	public void update(final T entity) {
		entityManager.merge(entity);
	}

	/* (non-Javadoc)
	 * @see com.acme.doktoric.presenter.dal.dao.IAbstractJpaDAO#delete(T)
	 */
	@Loggable
	public void delete(final T entity) {
		entityManager.remove(entity);
	}



}
