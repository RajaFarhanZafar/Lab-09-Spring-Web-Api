package com.rajafarhanzafar.spring_crud.repository;

import com.rajafarhanzafar.spring_crud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
