package br.pro.lmit.pds.ibeauty.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dados_pagamento", schema = "ibeauty")
public class DadosPagamento extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_dado_pgto")
    private long codDadoPagto;

    @ManyToOne
    @JoinColumn(name = "cod_pessoa", nullable = false)
    private Pessoa codPessoa;

    @ManyToOne
    @JoinColumn(name = "cod_forma_pgto", nullable = false)
    private FormaPagamento codFormaPgto;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotBlank
    @Size(max = 25)
    private String numero;


    public long getCodDadoPagto() {
        return codDadoPagto;
    }

    public void setCodDadoPagto(long codDadoPagto) {
        this.codDadoPagto = codDadoPagto;
    }

    public Pessoa getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Pessoa codPessoa) {
        this.codPessoa = codPessoa;
    }

    public FormaPagamento getCodFormaPgto() {
        return codFormaPgto;
    }

    public void setCodFormaPgto(FormaPagamento codFormaPgto) {
        this.codFormaPgto = codFormaPgto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
