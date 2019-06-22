package br.pro.lmit.pds.ibeauty.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoa", schema = "ibeauty")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pessoa")
    private long codPessoa;


    @OneToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 11)
    private String telefone;


    public long getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(long codPessoa) {
        this.codPessoa = codPessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
