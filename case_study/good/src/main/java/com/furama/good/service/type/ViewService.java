package com.furama.good.service.type;

import com.furama.good.model.Type;
import com.furama.good.repository.type.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ViewService implements ITypeService{

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
