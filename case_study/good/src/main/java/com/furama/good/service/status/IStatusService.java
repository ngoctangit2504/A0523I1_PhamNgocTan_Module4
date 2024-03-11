package com.furama.good.service.status;

import com.furama.good.model.Status;
import com.furama.good.model.Type;

import java.util.List;

public interface IStatusService {
    List<Status> showList();
    Status findById(Long id);
}
