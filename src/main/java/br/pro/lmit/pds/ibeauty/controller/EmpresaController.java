package br.pro.lmit.pds.ibeauty.controller;


import br.pro.lmit.pds.ibeauty.entity.Empresa;
import br.pro.lmit.pds.ibeauty.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;

@Controller
public class EmpresaController {



    @Autowired
    EmpresaRepository repository;



    @GetMapping("/empresa/{id}")
    private @ResponseBody
    Empresa getEmpresaById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
