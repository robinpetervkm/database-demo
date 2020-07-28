package com.vattathara.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.vattathara.database.databasedemo.entity.Person;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {
	//connect to the dataBase
	@PersistenceContext
	EntityManager entityManager;

	//select * from Person where id = ? ;
		public Person findById(int id){
			return entityManager.find(Person.class, id);//JPA
			
		}
		public Person update(Person person){
			return entityManager.merge(person);
		}
		public Person insert(Person person){
			return entityManager.merge(person);
		}

}
