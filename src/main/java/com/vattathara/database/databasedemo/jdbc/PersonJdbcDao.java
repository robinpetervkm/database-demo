package com.vattathara.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vattathara.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	//DataBase Connection // spring way
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//select * from Person ;
	public List<Person> findAll(){
		return jdbcTemplate.query(
				"select * from person", 
				 new BeanPropertyRowMapper<Person>(Person.class));//Row Mapper thing
		
	}
	
	//select * from Person where id = ? ;
	public Person findById(int id){
		return jdbcTemplate.queryForObject(
				"select * from person where id = ?",new Object[] {id}, 
				new BeanPropertyRowMapper<Person>(Person.class));//Row Mapper thing
		
	}
}
