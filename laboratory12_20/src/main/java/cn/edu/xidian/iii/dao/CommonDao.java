package cn.edu.xidian.iii.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao<T> {

	public void save(T instance);

	public void update(T instance);

	public void delete(T instance);

	public T findById(Class<T> clazz, Integer id);

	public List<T> findByExample(T instance);

	public List<T> findByExample(T instance, int firstResult, int maxResult);

	public void execute(String sql);

	public List<Map<String, Object>> query(String sql);

	public List<Map<String, Object>> query(String sql, Object[] args, int[] argTypes);

	public <E> E queryForObject(String sql, Class<E> clazz);

	public List<T> findByHql(String hql, String[] str);
}
