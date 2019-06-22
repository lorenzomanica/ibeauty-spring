package br.pro.lmit.pds.ibeauty.controller;


import br.pro.lmit.pds.ibeauty.entity.Funcionario;
import br.pro.lmit.pds.ibeauty.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;

@Controller
public class FuncionarioController {


    @Autowired
    FuncionarioRepository repository;


    @GetMapping("/funcionario/{id}")
    public @ResponseBody
    Funcionario getFuncionarioById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }


    @GetMapping("/funcionario/user/{id}")
    public @ResponseBody
    Funcionario getFuncionarioByUserId(@PathVariable Long id) {
        return repository.findByUsuarioCodUsuario(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
