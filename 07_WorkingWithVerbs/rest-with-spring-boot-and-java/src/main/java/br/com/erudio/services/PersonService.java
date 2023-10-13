package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Find all people!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0;i < 8;i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Find one person!");
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("taro");
        person.setLastName("yamada");
        person.setAddress("fsdapd122");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Create one persons!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Update one persons!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one persons!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("fsdapd122");
        person.setGender("Male");

        return person;
    }


}
