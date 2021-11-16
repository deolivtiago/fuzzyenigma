package com.github.olvrti.fuzzyenigma.services;

import java.util.List;
import java.util.Optional;

import com.github.olvrti.fuzzyenigma.domain.Person;
import com.github.olvrti.fuzzyenigma.repositories.PersonRepository;
import com.github.olvrti.fuzzyenigma.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  @Autowired
  private PersonRepository repository;

  public List<Person> findAll() {
    return repository.findAll();
  }

  public Person find(final Integer id) {
    final Optional<Person> person = repository.findById(id);
    return person.orElseThrow(() -> new ObjectNotFoundException(String.format("Object not found: %s", id)));
  }

  public Person create(final Person person) {
    return repository.save(person);
  }

  public Person update(final Person person) {
    find(person.getId());
    return repository.save(person);
  }

  public void delete(final Integer id) {
    find(id);
    repository.deleteById(id);
  }
}
