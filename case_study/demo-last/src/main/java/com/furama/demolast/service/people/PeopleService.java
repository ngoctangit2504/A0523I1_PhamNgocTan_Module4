package com.furama.demolast.service.people;

import com.furama.demolast.model.People;
import com.furama.demolast.repository.people.IPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeopleService implements IPeopleService{
    @Autowired
    private IPeopleRepository iPeopleRepository;
    @Override
    public Page<People> findAll(Pageable pageable) {
        return iPeopleRepository.findAll(pageable);
    }

    @Override
    public void addNewPeople(People people) {
        iPeopleRepository.save(people);
    }

    @Override
    public void delete(Long id) {
        iPeopleRepository.deleteById(id);
    }

    @Override
    public People updatePeople(People updatePeople) {
        return iPeopleRepository.save(updatePeople);
    }

    @Override
    public People findOne(Long id) {
        return iPeopleRepository.findById(id).orElse(null);
    }
}
