package com.github.olvrti.fuzzyenigma.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.github.olvrti.fuzzyenigma.domain.enums.PersonType;

@Entity
public class Person implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private Integer type;
  private String socialId;

  public Person() {
  }

  public Person(final Integer id, final String name, final PersonType type, final String socialId) {
    this.id = id;
    this.name = name;
    this.type = type.getId();
    this.socialId = socialId;
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

  public PersonType getType() {
    return PersonType.toEnum(type);
  }

  public void setType(final PersonType type) {
    this.type = type.getId();
  }

  public String getSocialId() {
    return socialId;
  }

  public void setSocialId(final String socialId) {
    this.socialId = socialId;
  }

}
