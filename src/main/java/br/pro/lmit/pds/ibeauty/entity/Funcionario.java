package br.pro.lmit.pds.ibeauty.entity;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario", schema = "ibeauty")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_funcionario")
    private long codFuncionario;

    @OneToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cod_empresa", nullable = false)
    private Empresa empresa;

    @NotBlank
    @Size(max = 20)
    private String papel;

    @ColumnDefault(value = "false")
    private boolean ativo;


    public long getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
