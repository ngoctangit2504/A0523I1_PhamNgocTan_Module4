package com.furama.demolast.service.type;

import com.furama.demolast.model.Gender;
import com.furama.demolast.model.Type;

import java.util.List;

public interface ITypeService {
    List<Type> showList();
    Type findById(Long id);
}
