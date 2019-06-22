package br.pro.lmit.pds.ibeauty.repository;

import br.pro.lmit.pds.ibeauty.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
