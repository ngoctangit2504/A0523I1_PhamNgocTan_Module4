package com.furama.demolast.repository.gender;

import com.furama.demolast.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<Gender, Long> {
}
