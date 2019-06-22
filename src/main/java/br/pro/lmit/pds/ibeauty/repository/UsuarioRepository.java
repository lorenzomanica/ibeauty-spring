package br.pro.lmit.pds.ibeauty.repository;

import br.pro.lmit.pds.ibeauty.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Usuario findByUsuario(String usuario);
}
