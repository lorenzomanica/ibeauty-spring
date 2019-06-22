package br.pro.lmit.pds.ibeauty.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "servico", schema = "ibeauty")
public class Servico extends AuditModel {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cod_servico")
  private long codServico;

  @ManyToOne
  @JoinColumn(name = "cod_empresa")
  private Empresa empresa;

  @NotBlank
  @Size(max = 50)
  private String nome;

  @NotBlank
  private String preco;

  @ColumnDefault(value = "false")
  private boolean ativo;


  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public long getCodServico() {
    return codServico;
  }

  public void setCodServico(long codServico) {
    this.codServico = codServico;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public String getPreco() {
    return preco;
  }

  public void setPreco(String preco) {
    this.preco = preco;
  }


  public boolean getAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

  public boolean isAtivo() {
    return ativo;
  }

}
