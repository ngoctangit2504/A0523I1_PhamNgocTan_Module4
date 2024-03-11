package com.furama.good.service.status;

import com.furama.good.model.Status;
import com.furama.good.repository.status.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements IStatusService{
    @Autowired
    private IStatusRepository iStatusRepository;
    @Override
    public List<Status> showList() {
        return iStatusRepository.findAll();
    }

    @Override
    public Status findById(Long id) {
        return iStatusRepository.findById(id).orElse(null);
    }
}
