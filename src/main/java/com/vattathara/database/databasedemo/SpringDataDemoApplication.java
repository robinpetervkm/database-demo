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
import com.vattathara.database.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository	 personSpringDataRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(" \n All Users --> {}",personSpringDataRepository.findAll());
		
		logger.info(" \n User id = 10001 --> {}",personSpringDataRepository.findById(10001));
		
		personSpringDataRepository.deleteById(10001);
		
		logger.info("\n insert {}",
				personSpringDataRepository.save(new Person(10004,"Tara","Berlin",new Date())));
		
		logger.info("\n update by id = 10003 --> {}",
				personSpringDataRepository.save(new Person(10003,"RInu","USA",new Date())));
		
		logger.info(" \n All Users --> {}",personSpringDataRepository.findAll());
	}
}
