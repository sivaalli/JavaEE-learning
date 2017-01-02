package com.source.spring.controllers.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offersDao")
public class OffersDao {
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers(){
		String sql="select * from offers";
		List<Offer> offers = jdbc.query(sql, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				Offer offer = new Offer();
				offer.setId(arg0.getInt("id"));
				offer.setName(arg0.getString("name"));
				offer.setEmail(arg0.getString("email"));
				offer.setText(arg0.getString("text"));
				return offer;
			}	
		});
		return offers;
	}
	
	public boolean create(Offer offer){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("insert into offers (name, email, text) values (:name, :email, :text)" , params) == 1;
		
	}
	
	public boolean delete(int id){
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		String sql = "delete from offers where id= :id";
		int deleted = jdbc.update(sql, params);
		return deleted==1;
	}
	
	public Offer getOffer(int id){
		
		String sql="select *  from offers where id= :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		Offer offer = jdbc.queryForObject(sql, params, new RowMapper<Offer>(){

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Offer offer = new Offer();
				offer.setId(arg0.getInt("id"));
				offer.setName(arg0.getString("name"));
				offer.setEmail(arg0.getString("email"));
				offer.setText(arg0.getString("text"));
				return offer;
				//return null;
			}	
		});
		return offer;
	}
	
	
}
