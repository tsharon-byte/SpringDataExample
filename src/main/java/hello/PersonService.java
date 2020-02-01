package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void save(Person person){
        repository.save(person);
    }
    public List<Person> findByLastName(String lastName){
        return repository.findByLastName(lastName);
    }
    public List<Person> findAll(){
        return (List<Person>) repository.findAll();
    }
}
