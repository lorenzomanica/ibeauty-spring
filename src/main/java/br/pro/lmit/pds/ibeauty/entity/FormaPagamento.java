package br.pro.lmit.pds.ibeauty.entity;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "forma_pagamento", schema = "ibeauty")
public class FormaPagamento {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cod_forma_pgto")
  private long codFormaPgto;

  @NotBlank
  @Size(max = 20)
  private String descricao;

  @ColumnDefault(value = "false")
  private boolean ativo;


  public long getCodFormaPgto() {
    return codFormaPgto;
  }

  public void setCodFormaPgto(long codFormaPgto) {
    this.codFormaPgto = codFormaPgto;
  }


  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


  public boolean getAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

}
