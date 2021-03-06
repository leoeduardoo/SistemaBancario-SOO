package com.grupo03.banco.service;

import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.PessoaFisica;

public interface PessoaFisicaService {

    boolean save(PessoaFisica entity) throws SQLException;

    PessoaFisica findByCpf(String cpf) throws SQLException;

}