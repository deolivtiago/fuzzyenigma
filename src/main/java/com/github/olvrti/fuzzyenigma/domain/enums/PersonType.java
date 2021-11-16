package com.github.olvrti.fuzzyenigma.domain.enums;

public enum PersonType {
  NATURAL(0, "Natural"), JURIDICAL(1, "Juridical");

  private Integer id;
  private String value;

  PersonType(final Integer id, final String value) {
    this.id = id;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  public static PersonType toEnum(final Integer id) {
    if (id == null) {
      return null;
    }

    for (final PersonType personType : PersonType.values()) {
      if (personType.getId() == id) {
        return personType;
      }
    }

    throw new IllegalArgumentException(String.format("Invalid value: %s", id));
  }
}
