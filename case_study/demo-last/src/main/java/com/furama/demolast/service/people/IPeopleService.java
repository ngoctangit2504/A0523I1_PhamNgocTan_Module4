package com.furama.demolast.service.people;

import com.furama.demolast.model.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPeopleService {
    //     List<Customer> showList();
    Page<People> findAll(Pageable pageable);

    void addNewPeople(People people);

    void delete(Long id);

    People updatePeople(People updatePeople);

    People findOne(Long id);
}
