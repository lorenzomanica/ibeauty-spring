package br.pro.lmit.pds.ibeauty.controller;


import br.pro.lmit.pds.ibeauty.entity.DadosPagamento;
import br.pro.lmit.pds.ibeauty.repository.DadosPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;

@Controller
public class DadosPagamentoController {


    @Autowired
    DadosPagamentoRepository repository;


    @GetMapping("/dados-pagamento/{id}")
    public @ResponseBody
    DadosPagamento getDadosPagamentoById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }



    @GetMapping("/dados-pagamento/user/{id}/{pg}")
    public @ResponseBody
    Page<DadosPagamento> getDadosPagamentoById(@PathVariable Long id, @PathVariable Integer pg) {
        if (id != null && pg != null) {
            return repository.findAllDadosPgtoByUserId(id, PageRequest.of(pg, 30));
        } else {
            throw new UnsupportedOperationException("No page or id");
        }
    }
}
