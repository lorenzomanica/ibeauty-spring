package br.pro.lmit.pds.ibeauty.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "horario", schema = "ibeauty")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_horario")
    private long codHorario;

    @ManyToOne
    @JoinColumn(name = "cod_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "cod_empresa")
    private Empresa empresa;

    @NotBlank
    @Column(name = "data_hora")
    private String dataHora;

    private boolean reservado;


    public long getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(long codHorario) {
        this.codHorario = codHorario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}
