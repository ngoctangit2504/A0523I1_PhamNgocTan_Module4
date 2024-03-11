package com.furama.good.service.type;

import com.furama.good.model.Type;

import java.util.List;

public interface ITypeService {
    List<Type> showList();
    Type findById(Long id);
}
