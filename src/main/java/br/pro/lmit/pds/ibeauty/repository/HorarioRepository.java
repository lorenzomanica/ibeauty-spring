package br.pro.lmit.pds.ibeauty.repository;

import br.pro.lmit.pds.ibeauty.entity.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @Query(
            value = "SELECT * FROM ibeauty.horario WHERE cod_empresa = ?1",
            countQuery = "SELECT count(*) FROM ibeauty.horario WHERE cod_empresa = ?1",
            nativeQuery = true)
    Page<Horario> findHorariosByCodEmpresa(Long id, Pageable pageable);


    @Query(
            value = "SELECT * FROM ibeauty.horario WHERE cod_empresa = ?1 AND data_hora @> CAST(?2 as TIMESTAMP) = true",
            countQuery = "SELECT count(*) FROM ibeauty.horario WHERE cod_empresa = ?1 AND data_hora @> CAST(?2 as TIMESTAMP) = true",
            nativeQuery = true )
    Page<Horario> findHorariosByEmpresaAndDataHora(Long id, String ts, Pageable pageable);


//    @Modifying
//    @Query(value = "UPDATE ibeauty.horario SET reservado = :r WHERE cod_horario = :id")
//    @Transactional
//    void updateHorarioStatusWithId(@Param("id") Long id, @Param("r") boolean r);
}
