package project.Agenda;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class Tarefa {
    private int idTarefa;
    private String descricao;
    private Boolean status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataAlteracao;


    public Tarefa(String descricao){
        this.descricao = descricao;
        this.status = true;//true = ativo
        this.dataInicio = LocalDateTime.now();
        this.dataAlteracao = LocalDateTime.now();
    }

    public int getIdTarefa() {
        return idTarefa;
    }
    public String getDescricao() {
        return descricao;
    }
    public Boolean getStatus() {
        return status;
    }
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }


    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
