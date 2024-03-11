package com.furama.demolast.service.type;

import com.furama.demolast.model.Type;
import com.furama.demolast.repository.type.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TypeService implements ITypeService{
    @Autowired
    private ITypeRepository iTypeRepository;
    @Override
    public List<Type> showList() {
        return iTypeRepository.findAll();
    }

    @Override
    public Type findById(Long id) {
        return iTypeRepository.findById(id).orElse(null);
    }
}
