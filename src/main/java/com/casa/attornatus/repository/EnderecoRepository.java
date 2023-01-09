package com.casa.attornatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa.attornatus.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
