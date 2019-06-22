package br.pro.lmit.pds.ibeauty.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "agendamento", schema = "ibeauty")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_agendamento")
    private long codAgendamento;

    
    @Column(name = "cod_empresa")
    private long codEmpresa;

    
    @Column(name = "cod_funcionario")
    private long codFuncionario;

    @ManyToOne
    @JoinColumn(name = "cod_pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "cod_dado_pgto")
    private DadosPagamento dadosPagamento;

    @ManyToOne
    @JoinColumn(name = "cod_servico")
    private Servico servico;

    @OneToOne
    @JoinColumn(name = "cod_horario")
    private Horario horario;

    
    private int estado;

    private Integer avaliacao;

    @Size(max = 255)
    private String comentario;


    public long getCodAgendamento() {
        return codAgendamento;
    }

    public void setCodAgendamento(long codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    public long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public long getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
