package project.Agenda;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private int idTarefa;
    private String descricao;
    private Boolean status;
    private String dataInicio;
    private String dataAlteracao;


    public Tarefa(String descricao){
        this.descricao = descricao;
        this.status = true;//true = ativo
        this.dataInicio = agora();
        this.dataAlteracao = agora();
    }

    public String agora(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
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
    public String getDataInicio() {
        return dataInicio;
    }
    public String getDataAlteracao() {
        return dataAlteracao;
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
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
