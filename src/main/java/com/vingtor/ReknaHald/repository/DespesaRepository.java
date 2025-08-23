package com.vingtor.ReknaHald.repository;

import com.vingtor.ReknaHald.entidade.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, UUID> {
}
