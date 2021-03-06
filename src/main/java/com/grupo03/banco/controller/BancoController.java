package com.grupo03.banco.controller;

import com.grupo03.banco.exception.ObjectNotFoundException;
import com.grupo03.banco.exception.SQLException;
import com.grupo03.banco.model.request.ContaRequest;
import com.grupo03.banco.model.request.PessoaFisicaRequest;
import com.grupo03.banco.model.request.PessoaJuridicaRequest;
import com.grupo03.banco.model.request.TransacaoRequest;
import com.grupo03.banco.model.response.ContaResponse;
import com.grupo03.banco.model.response.PessoaFisicaResponse;
import com.grupo03.banco.model.response.PessoaJuridicaResponse;
import com.grupo03.banco.model.response.RelacaoContasResponse;
import com.grupo03.banco.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "banco", produces = "application/json")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @PutMapping("efetuarTransacao")
    public ResponseEntity<ContaResponse> efetuarTransacao(@RequestBody TransacaoRequest transacaoRequest) throws SQLException, ObjectNotFoundException {
        return ResponseEntity.ok(bancoService.efetuarTransacao(transacaoRequest));
    }

    @GetMapping("extrairRelacaoContas")
    public ResponseEntity<List<RelacaoContasResponse>> extrairRelacaoContas() throws SQLException {
        return ResponseEntity.ok(bancoService.extrairRelacaoContas());
    }

    @PostMapping("cadastrarPessoaFisica")
    public ResponseEntity<PessoaFisicaResponse> cadastrarPessoaFisica(@RequestBody PessoaFisicaRequest pessoaFisicaRequest) throws SQLException {
        return ResponseEntity.ok(bancoService.cadastrarPessoaFisica(pessoaFisicaRequest));
    }

    @PostMapping("cadastrarPessoaJuridica")
    public ResponseEntity<PessoaJuridicaResponse> cadastrarPessoaJuridica(@RequestBody PessoaJuridicaRequest pessoaJuridicaRequest) throws SQLException {
        return ResponseEntity.ok(bancoService.cadastrarPessoaJuridica(pessoaJuridicaRequest));
    }

    @PostMapping("cadastrarConta")
    public ResponseEntity<ContaResponse> cadastrarConta(@RequestBody ContaRequest contaRequest) throws SQLException, ObjectNotFoundException {
        return ResponseEntity.ok(bancoService.cadastrarConta(contaRequest));
    }

}