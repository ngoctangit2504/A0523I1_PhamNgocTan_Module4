package com.furama.good.repository.status;

import com.furama.good.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status, Long> {
}
