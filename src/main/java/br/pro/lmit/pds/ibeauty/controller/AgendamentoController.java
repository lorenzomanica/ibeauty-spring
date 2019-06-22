package br.pro.lmit.pds.ibeauty.controller;


import br.pro.lmit.pds.ibeauty.entity.Agendamento;
import br.pro.lmit.pds.ibeauty.entity.Horario;
import br.pro.lmit.pds.ibeauty.repository.AgendamentoRepository;
import br.pro.lmit.pds.ibeauty.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Controller
public class AgendamentoController {


    @Autowired
    AgendamentoRepository repository;

    @Autowired
    HorarioRepository horarioRepository;


    @GetMapping("/agendamento/{id}")
    public @ResponseBody
    Agendamento getAgendamentoById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }


    @GetMapping("/agendamento/user/{id}/{pg}")
    public @ResponseBody
    Page<Agendamento> getAgendamentoByUserId(@PathVariable Long id, @PathVariable Integer pg) {
        if (id != null && pg != null) {
            return repository.findAgendamentosByUserId(id, PageRequest.of(pg, 30));
        } else {
            throw new UnsupportedOperationException("No page or id");
        }
    }


    @PostMapping(value = "/agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAgendamento(@RequestBody Agendamento r) {
        repository.save(r);
//        Optional<Horario> search = horarioRepository.findById(r.getHorario().getCodHorario());
//        Horario record = search.orElseThrow(EntityNotFoundException::new);
//        record.setReservado(true);
    }

    @PutMapping(value = "/agendamento/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateAgendamento(@RequestBody Agendamento r) {
        Optional<Agendamento> search = repository.findById(r.getCodAgendamento());
        Agendamento record = search.orElseThrow(EntityNotFoundException::new);
        record.setEstado(r.getEstado());
        repository.flush();
    }
}
