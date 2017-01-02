package com.source.spring.controllers.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("usersDao")
public class UsersDao {
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(User user){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		jdbc.update("insert into users (username, password, email, enabled) values (:username, :password, :email, :enabled)" , params);
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)" , params) == 1;
		
	}

	public boolean exists(String username) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		return jdbc.queryForObject("select count(*) from users where username=:username", paramSource, Integer.class) >0;
	}
	
	
	
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return jdbc.query("select * from users,authorities where users.username=authorities.username", BeanPropertyRowMapper.newInstance(User.class));
	}
		
}
