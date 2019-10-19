package com.practice.boot.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.boot.entity.Employee;

@Repository
@Transactional
public class EmployeeCRUD {

	@Autowired
	public SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Transactional
	public void saveEmployee( Employee e) {
		getSession().save(e);
	}
	public List<Employee> getAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class).
				add(Restrictions.isNotNull("id"));
		CriteriaBuilder cb = getSession().getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
		Root<Employee> r = criteriaQuery.from(Employee.class);
		criteriaQuery.select(r).where(cb.isNotNull(r.get("id")));
		Query<Employee> query =  getSession().createQuery(criteriaQuery);
		List<Employee> result =  query.getResultList();
		return result;
	}
}
