package project.Agenda;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class Tarefa {
    private String texto;
    private Boolean status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataAlteracao;

    private final StringProperty descricao;
    private final BooleanProperty concluido;

    public Tarefa(String descricao){
        this.descricao = new SimpleStringProperty();
        this.concluido = new SimpleBooleanProperty();
        this.texto = texto;
        this.status = true;//true = ativo
        this.dataInicio = LocalDateTime.now();
        this.dataAlteracao = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao.get();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao.set(descricao);
    }

    public boolean isConcluido() {
        return concluido.get();
    }

    public BooleanProperty concluidoProperty() {
        return concluido;
    }

}
