package br.pro.lmit.pds.ibeauty.repository;

import br.pro.lmit.pds.ibeauty.entity.Agendamento;
import br.pro.lmit.pds.ibeauty.entity.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {


//    @Modifying
//    @Query(value = "INSERT INTO ibeauty.agendamento (cod_pessoa, cod_dado_pgto, cod_empresa, cod_servico, cod_funcionario, cod_horario, estado) values (:p, :dp, :e, :s, :f, :h, :status) RETURNING cod_agendamento")
//    @Transactional
//    void saveAgendamentoWithValues(@Param("p") Long p,
//                                   @Param("dp") Long dp,
//                                   @Param("e") Long e,
//                                   @Param("s") Long s,
//                                   @Param("f") Long f,
//                                   @Param("h") Long h,
//                                   @Param("status") Integer status);


    @Query(
            value = "SELECT * FROM ibeauty.agendamento WHERE cod_pessoa = ?1",
            countQuery = "SELECT count(*) FROM ibeauty.agendamento WHERE cod_pessoa = ?1",
            nativeQuery = true )
    Page<Agendamento> findAgendamentosByUserId(Long id, Pageable pageable);


}
