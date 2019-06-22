package br.pro.lmit.pds.ibeauty.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "ibeauty")
@JsonIgnoreProperties({"senha", "ativo"})
public class Usuario extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario")
    private long codUsuario;

    @NotBlank
    @Size(max = 50)
    private String usuario;

    @NotBlank
    @Size(max = 255)
    private String senha;

    @ColumnDefault(value = "false")
    private boolean ativo;


    public long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(long codUsuario) {
        this.codUsuario = codUsuario;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codUsuario=" + codUsuario +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo='" + ativo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return codUsuario == usuario1.codUsuario &&
                usuario.equals(usuario1.usuario) &&
                senha.equals(usuario1.senha) &&
                ativo == usuario1.ativo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUsuario, usuario, senha, ativo);
    }
}
