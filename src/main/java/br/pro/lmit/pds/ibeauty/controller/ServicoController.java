package br.pro.lmit.pds.ibeauty.controller;

import br.pro.lmit.pds.ibeauty.entity.Servico;
import br.pro.lmit.pds.ibeauty.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ServicoController {



    @Autowired
    ServicoRepository repository;




    @GetMapping("/servico/{id}")
    public @ResponseBody
    Servico getServicoById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/servicos/{pg}")
    public @ResponseBody
    Page<Servico> getServicosPage(@PathVariable Integer pg) {
        return repository.findAll(PageRequest.of(pg, 30));
    }

}
