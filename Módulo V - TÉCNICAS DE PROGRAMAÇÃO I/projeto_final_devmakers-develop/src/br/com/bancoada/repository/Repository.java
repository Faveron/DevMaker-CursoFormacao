package br.com.bancoada.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    List<T> getAll() throws IOException;

    Optional<T> getById(String id) throws IOException;

    void save(T obj) throws IOException;

    // metodos bonus (não obrigatórios)
    //void update(String id, T obj) throws IOException;
    //void delete(String id) throws IOException;

}
