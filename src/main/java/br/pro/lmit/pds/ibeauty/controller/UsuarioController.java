package br.pro.lmit.pds.ibeauty.controller;

import br.pro.lmit.pds.ibeauty.dto.LoginRequest;
import br.pro.lmit.pds.ibeauty.entity.Usuario;
import br.pro.lmit.pds.ibeauty.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
public class UsuarioController {


    @Autowired
    private UsuarioRepository repository;


    @GetMapping("/usuario/{id}")
    public @ResponseBody
    Usuario getUsuarioById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }


    @PostMapping("/login")
    public @ResponseBody
    Usuario login(@RequestBody LoginRequest request) {
        Usuario u = repository.findByUsuario(request.getUsername());
        if (u.getUsuario().equals(request.getUsername()) && u.getSenha().equals(request.getPassword())) {
            return u;
        } else {
            throw new EntityNotFoundException();
        }
    }


}
