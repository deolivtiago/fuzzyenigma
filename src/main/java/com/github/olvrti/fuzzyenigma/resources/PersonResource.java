package com.github.olvrti.fuzzyenigma.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.github.olvrti.fuzzyenigma.domain.Person;
import com.github.olvrti.fuzzyenigma.dtos.PersonDTO;
import com.github.olvrti.fuzzyenigma.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/person")
public class PersonResource {
  @Autowired
  private PersonService service;

  @GetMapping
  public ResponseEntity<List<PersonDTO>> findAll() {
    final List<PersonDTO> persons = service.findAll().stream().map(p -> new PersonDTO(p)).collect(Collectors.toList());
    return ResponseEntity.ok().body(persons);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<PersonDTO> find(@PathVariable final Integer id) {
    final PersonDTO person = new PersonDTO(service.find(id));
    return ResponseEntity.ok().body(person);
  }

  @PostMapping
  public ResponseEntity<Person> create(@RequestBody final Person personData) {
    final Person person = service.create(personData);
    final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId())
        .toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@PathVariable final Integer id, @RequestBody final Person personData) {
    personData.setId(id);
    service.update(personData);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable final Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

}
