package cn.edu.xidian.iii.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.edu.xidian.iii.dao.CommonDao;


public class CommonDaoImpl<T> extends HibernateDaoSupport implements CommonDao<T>
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	@Autowired
	public void setHT(HibernateTemplate template)
	{
		super.setHibernateTemplate(template);
	}

	public void save(T instance)
	{
		getHibernateTemplate().save(instance);
	}

	public List<T> findByExample(T instance)
	{
		List<T> list = getHibernateTemplate().findByExample(instance);
		return list;
	}

	public List<T> findByExample(T instance, int firstResult, int maxResult)
	{
		List<T> list = getHibernateTemplate().findByExample(instance, firstResult, maxResult);
		return list;
	}

	public T findById(Class<T> clazz, Integer id)
	{
		return getHibernateTemplate().get(clazz, id);
	}

	public void execute(String sql)
	{
		getJdbcTemplate().execute(sql);
	}

	public List<Map<String, Object>> query(String sql)
	{
		return (List<Map<String, Object>>) getJdbcTemplate().queryForList(sql);
	}

	public List<Map<String, Object>> query(String sql, Object[] args,int[] argTypes)
	{
		return getJdbcTemplate().queryForList(sql, args, argTypes);
	}

	public void update(T instance)
	{
		getHibernateTemplate().update(instance);
	}

	public void delete(T instance)
	{
		getHibernateTemplate().delete(instance);
	}

	public <E> E queryForObject(String sql, Class<E> clazz)
	{
		return getJdbcTemplate().queryForObject(sql, clazz);
	}
	
	
	public List<T> findByHql(String hql,String []str){
		
		List<T> list =null;
		Session session=null;
		Transaction transaction =null;
		try{
			session =getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			for(int i=0;i<str.length;i++){
				query.setString(i, str[i]);
			}
			list = query.list();
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(transaction!=null){
				transaction.rollback();
			}
		}finally {
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}

}
