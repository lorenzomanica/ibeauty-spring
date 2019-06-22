package br.pro.lmit.pds.ibeauty.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Calendar;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"dataCriacao", "updatedAt"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable {

    @Column(name = "data_criacao", nullable = false, updatable = false)
    @CreatedDate
    private Calendar dataCriacao;

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
