package br.pro.lmit.pds.ibeauty.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AgendamentoRequest {

    @JsonProperty("cod_pessoa")
    Long codPessoa;

    @JsonProperty("cod_dado_pgto")
    Long codDadoPgto;

    @JsonProperty("cod_empresa")
    Long codEmpresa;

    @JsonProperty("cod_servico")
    Long codServico;

    @JsonProperty("cod_funcionario")
    Long codFuncionario;

    @JsonProperty("cod_horario")
    Long codHorario;

    Integer estado;

    public Long getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Long codPessoa) {
        this.codPessoa = codPessoa;
    }

    public Long getCodDadoPgto() {
        return codDadoPgto;
    }

    public void setCodDadoPgto(Long codDadoPgto) {
        this.codDadoPgto = codDadoPgto;
    }

    public Long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public Long getCodServico() {
        return codServico;
    }

    public void setCodServico(Long codServico) {
        this.codServico = codServico;
    }

    public Long getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Long getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(Long codHorario) {
        this.codHorario = codHorario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
