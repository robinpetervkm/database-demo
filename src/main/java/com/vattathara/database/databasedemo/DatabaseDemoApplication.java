package com.vattathara.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vattathara.database.databasedemo.entity.Person;
import com.vattathara.database.databasedemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(" All Users --> {}",personJdbcDao.findAll());
		
		logger.info(" User id = 10001 --> {}",personJdbcDao.findById(10001));
		
		logger.info(" Delete by id = 10002 --> no of rows affected {}",
				personJdbcDao.deleteById(10001));
		
		logger.info(" inserting by id = 10004 {}",
				personJdbcDao.insert(new Person(1004,"Tara","Berlin",new Date())));
		
		logger.info(" update by id = 10003 --> {}",
				personJdbcDao.update(new Person(1003,"RInu","USA",new Date())));
	}
}
