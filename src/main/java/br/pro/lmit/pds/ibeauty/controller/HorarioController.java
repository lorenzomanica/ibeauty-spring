package br.pro.lmit.pds.ibeauty.controller;


import br.pro.lmit.pds.ibeauty.entity.Horario;
import br.pro.lmit.pds.ibeauty.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Controller
public class HorarioController {


    @Autowired
    HorarioRepository repository;


    @GetMapping("/horario/{id}")
    public @ResponseBody
    Horario getHorarioById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping("/horarios/empresa/{id}/{pg}")
    public @ResponseBody
    Page<Horario> getHorariosFromEmpresaWithId(@PathVariable Long id, @PathVariable Integer pg) {
        if (id != null && pg != null)
            return repository.findHorariosByCodEmpresa(id, PageRequest.of(pg, 30));
        else
            throw new UnsupportedOperationException();
    }

    @GetMapping("/horarios/empresa/{id}/{dt}/{pg}")
    public @ResponseBody
    Page<Horario> getHorariosFromEmpresaWithId(@PathVariable Long id, @PathVariable Long dt, @PathVariable Integer pg) {
        if (id != null && dt != null && pg != null) {
            LocalDateTime ts = LocalDateTime.ofEpochSecond(dt, 0, ZoneOffset.UTC);
            return repository.findHorariosByEmpresaAndDataHora(id, ts.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")), PageRequest.of(pg, 30));
        } else
            throw new UnsupportedOperationException();
    }


}
