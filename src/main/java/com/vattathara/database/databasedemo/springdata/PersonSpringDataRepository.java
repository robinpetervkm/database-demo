package com.vattathara.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vattathara.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository 
extends JpaRepository<Person,Integer>{
}
