package com.furama.demolast.repository.people;

import com.furama.demolast.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPeopleRepository extends JpaRepository<People, Long> {
}
