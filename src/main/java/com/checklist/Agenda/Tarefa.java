package com.checklist.Agenda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private int id;
    private String descricao;
    private int status;
    private String dataInicio;
    private String dataAlteracao;


    public Tarefa(String descricao){
        this.descricao = descricao;
        this.status = 1; //1 = pendente / 0 = concluido
        this.dataInicio = agora();
        this.dataAlteracao = agora();
    }

    public String agora(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
    public int getIdTarefa() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getStatus() {
        return status;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setIdTarefa(int id) {
        this.id = id;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataAlteracao='" + dataAlteracao + '\'' +
                '}';
    }
}
