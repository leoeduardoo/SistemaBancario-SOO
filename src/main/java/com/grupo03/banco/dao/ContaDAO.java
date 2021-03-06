package com.grupo03.banco.dao;

import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.Conta;
import com.grupo03.banco.model.response.RelacaoContasResponse;

import java.util.List;

public interface ContaDAO {

    final String UPDATE_CONTA = "UPDATE Conta SET saldo = ? WHERE numero = ?";

    final String INSERT_CONTA = "INSERT INTO Conta(saldo, numero, dataAberturaConta, tipoConta, Pessoa_id) VALUES(?, ?, ?, ?, ?)";

    final String FIND_BY_ID_PESSOA = "SELECT c.id, c.saldo, c.numero, c.dataAberturaConta, c.tipoConta "
            + "FROM Conta c "
            + "WHERE c.Pessoa_id = ?";

    final String FIND_BY_NUMERO = "SELECT c.id, c.saldo, c.numero, c.dataAberturaConta, c.tipoConta "
            + "FROM Conta c "
            + "WHERE c.numero = ?";

    final String FIND_ALL_JOIN_PESSOA = "SELECT c.numero, c.tipoConta, c.saldo, p.nome, p.telefone "
            + "FROM Conta c "
            + "JOIN Pessoa p ON c.Pessoa_id = p.id";

    public boolean save(Conta conta, String fk) throws SQLException;

    public boolean update(Conta conta) throws SQLException;

    public Conta findByIdPessoa(String idPessoa) throws SQLException;

    public Conta findByNumero(String numero) throws SQLException;

    public List<RelacaoContasResponse> findAllJoinPessoa() throws SQLException;

}