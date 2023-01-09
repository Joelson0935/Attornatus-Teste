package com.casa.dio.service;

public interface Services<E> {

	Iterable<E> buscarTodos();

	E buscarPorId(Long id);

	E inserir(E classe);

	E atualizar(Long id, E classe);

	void deletar(Long id);

}
