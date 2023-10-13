package br.com.erudio.services;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Find all people!");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Find one person!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
    }

    public Person create(Person person) {
        logger.info("Create one persons!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update one persons!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one persons!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
        repository.delete(entity);
    }

/*        private Person mockPerson(int i) {
            Person person = new Person();

            person.setId(counter.incrementAndGet());
            person.setFirstName("Person Name " + i);
            person.setLastName("Last Name " + i);
            person.setAddress("fsdapd122");
            person.setGender("Male");

            return person;
        }*/


}
