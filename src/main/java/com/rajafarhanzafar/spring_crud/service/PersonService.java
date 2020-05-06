package com.rajafarhanzafar.spring_crud.service;

import com.rajafarhanzafar.spring_crud.entity.Person;
import com.rajafarhanzafar.spring_crud.exception.NotFoundException;
import com.rajafarhanzafar.spring_crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    public Person addPerson(Person person)
    {
        personRepository.save(person);
        return person;
    }
    public List<Person> getAllPerson()
    {
     return personRepository.findAll();
    }
    public Person findPersonById(int id)
    {
        Optional<Person> person =personRepository.findById(id);
        if(!person.isPresent()) {
            throw new NotFoundException("Person with "+id+" does not exists!");
        }
        return person.get();
    }
    public Person updatePerson(Person person,int id)
    {
        Optional<Person> OBperson =personRepository.findById(id);
        if(!OBperson.isPresent())
        {
            throw new NotFoundException("Person with "+id+" does not exists!");
        }
        person.setId(id);
        personRepository.save(person);
        return person;
    }
    public void deletePerson(int id)
    {
        Optional<Person> person =personRepository.findById(id);
        if(!person.isPresent())
        {
            throw new NotFoundException("Person with "+id+" does not exists!");
        }
        personRepository.delete(person.get());
    }
}
