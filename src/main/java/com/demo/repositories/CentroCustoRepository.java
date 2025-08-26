package com.demo.repositories;

import com.demo.models.CentroCusto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroCustoRepository extends JpaRepository<CentroCusto, Integer> {
}
