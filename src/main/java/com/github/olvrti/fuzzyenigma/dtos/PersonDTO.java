package com.github.olvrti.fuzzyenigma.dtos;

import com.github.olvrti.fuzzyenigma.domain.Person;

public class PersonDTO {
  private Integer id;
  private String name;

  public PersonDTO() {
  }

  public PersonDTO(final Integer id, final String name) {
    this.id = id;
    this.name = name;
  }

  public PersonDTO(final Person person) {
    this.id = person.getId();
    this.name = person.getName();
  }

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

}
