package com.casa.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa.dio.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}
