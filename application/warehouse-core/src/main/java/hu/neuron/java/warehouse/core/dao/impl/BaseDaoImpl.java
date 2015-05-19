package hu.neuron.java.warehouse.core.dao.impl;

import hu.neuron.java.warehouse.core.dao.BaseDAO;
import hu.neuron.java.warehouse.core.entity.BaseEntity;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
public abstract class BaseDaoImpl<E extends BaseEntity> implements BaseDAO<E> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	@Override
	public E save(E entity) throws Exception {
		entity.setRecDate(new Date());
		// TODO
		entity.setRecUser("gep");
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public void update(E entity) throws Exception {
		this.entityManager.merge(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		E e = this.entityManager.find(entityClass, id);
		this.entityManager.remove(e);

	}

	@Override
	public E find(Long id) throws Exception {
		return this.entityManager.find(entityClass, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() throws Exception {

		return entityManager.createQuery(
				"Select t from " + entityClass.getSimpleName() + " t")
				.getResultList();
	}

}
