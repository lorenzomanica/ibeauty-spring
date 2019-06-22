package br.pro.lmit.pds.ibeauty.repository;

import br.pro.lmit.pds.ibeauty.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByUsuarioCodUsuario(Long id);
}
