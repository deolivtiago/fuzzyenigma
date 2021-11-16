package com.github.olvrti.fuzzyenigma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.olvrti.fuzzyenigma.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
