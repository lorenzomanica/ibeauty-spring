package br.pro.lmit.pds.ibeauty.repository;

import br.pro.lmit.pds.ibeauty.entity.DadosPagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosPagamentoRepository extends JpaRepository<DadosPagamento, Long> {

    @Query(
            value = "SELECT * FROM ibeauty.dados_pagamento WHERE cod_pessoa = ?1",
            countQuery = "SELECT count(*) FROM ibeauty.dados_pagamento WHERE cod_pessoa = ?1",
            nativeQuery = true
    )
    Page<DadosPagamento> findAllDadosPgtoByUserId(Long id, PageRequest of);
}
