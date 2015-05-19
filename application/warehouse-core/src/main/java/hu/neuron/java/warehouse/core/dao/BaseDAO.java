package hu.neuron.java.warehouse.core.dao;

import java.util.List;

public interface BaseDAO<T> {

	public T save(T entity) throws Exception;

	public void update(T entity) throws Exception;

	public void delete(Long id) throws Exception;

	public T find(Long id) throws Exception;

	public List<T> findAll() throws Exception;

}
