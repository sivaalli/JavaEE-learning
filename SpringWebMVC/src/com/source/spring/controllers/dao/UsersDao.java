package com.source.spring.controllers.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Component("usersDao")
@Transactional
public class UsersDao {
	// private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private StandardPasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/*@Autowired//remember autowiring happens by type
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}*/
	

	public void create(User user){
		
		user.setEncodedPass(passwordEncoder.encode(user.getPassword()));
		getSession().save(user);
		
		//this is simplest way to create parameters out of a bean.
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		/*MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password",  passwordEncoder.encode(user.getPassword())) ;
		params.addValue("name", user.getName());
		params.addValue("email", user.getEmail());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		
		return jdbc.update("insert into users (username, password, name, email, enabled, authority) values (:username, :password, :name, :email, :enabled, :authority)" , params)==1;	*/
	}

	public boolean exists(String username) {
	/*	MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return jdbc.queryForObject("select count(*) from users where username=:username", paramSource, Integer.class) >0;*/
		
		//Using hibernate to check for user
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User)criteria.uniqueResult();
		return user!=null;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		
		return getSession().createQuery("from User").list();
		//return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
	}
	
	
		
}
