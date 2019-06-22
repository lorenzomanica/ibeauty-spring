package br.pro.lmit.pds.ibeauty.controller;


import br.pro.lmit.pds.ibeauty.entity.FormaPagamento;
import br.pro.lmit.pds.ibeauty.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;

@Controller
public class FormaPagamentoController {


    @Autowired
    FormaPagamentoRepository repository;


    @GetMapping("/forma-pagamento/{id}")
    public @ResponseBody
    FormaPagamento getFormaPagamentoById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
