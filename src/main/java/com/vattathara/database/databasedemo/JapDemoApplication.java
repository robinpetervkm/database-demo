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
import com.vattathara.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JapDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository	 jpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JapDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		logger.info(" User id = 10001 --> {}",jpaRepository.findById(10001));
		
		/*
		logger.info(" All Users --> {}",jpaRepository.findAll());
	

		
		logger.info(" Delete by id = 10002 --> no of rows affected {}",
				jpaRepository.deleteById(10001));
			*/
		logger.info(" inserting by id = 10004 {}",
				jpaRepository.insert(new Person(1004,"Tara","Berlin",new Date())));
		
		logger.info(" update by id = 10003 --> {}",
				jpaRepository.update(new Person(1003,"RInu","USA",new Date())));
	
	}
}
