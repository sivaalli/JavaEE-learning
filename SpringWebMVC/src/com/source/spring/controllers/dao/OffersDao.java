package com.source.spring.controllers.dao;

import java.util.List;


import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@Component("offersDao")
public class OffersDao {
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@SuppressWarnings("unchecked")
	public List<Offer> getOffers(){
		/*String sql="select * from offers,users where offers.username=users.username and users.enabled=true";
		List<Offer> offers = jdbc.query(sql, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				Offer offer = new Offer();
				User user = new User(arg0.getString("username"), arg0.getString("email"), 
						arg0.getString("name"), arg0.getString("password"), arg0.getString("authority"), arg0.getBoolean("enabled"));
				offer.setUser(user);
				offer.setId(arg0.getInt("id"));
				offer.setText(arg0.getString("text"));
				return offer;
			}	
		});
		return offers;	*/
		Criteria crit = getSession().createCriteria(Offer.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
		
	}
	
	public void create(Offer offer){
	/*	BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);		
		return jdbc.update("insert into offers (username, text) values (:username, :text)" , params) == 1;*/
		getSession().save(offer);
		
	}
	
	public void delete(int id){
		
		
		Query query = getSession().createQuery("delete from Offer where id=:id");
		query.setLong("id", id);
		query.executeUpdate();
		/*
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		String sql = "delete from offers where id= :id";
		int deleted = jdbc.update(sql, params);
		return deleted==1;*/
	}
	
	//this method is not used for now
	@SuppressWarnings("unchecked")
	public List<Offer> getOffer(String username){
		
		/*String sql="select *  from offers,users where offers.id= :id and offers.username=users.username and users.enabled=true";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		Offer offer = jdbc.queryForObject(sql, params, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				Offer offer = new Offer();
				User user = new User(arg0.getString("username"), arg0.getString("email"), 
						arg0.getString("name"), arg0.getString("password"), arg0.getString("authority"), arg0.getBoolean("enabled"));
				offer.setUser(user);
				offer.setId(arg0.getInt("id"));
				offer.setText(arg0.getString("text"));
				return offer;
			}	
		});
		return offer;*/
		
		Criteria crit = getSession().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}
	
	
}
