package Agenda;

import java.time.LocalDate;

public class Checklist {
    private String texto;
    private Boolean status;
//    private
    private LocalDate dataInicio;
    private LocalDate dataAlteracao;

    public void checklist(String texto){
        this.texto = texto;
        this.status = true;//true = ativo
        this.dataInicio = LocalDate.now();
        this.dataAlteracao = LocalDate.now();
    }

    public Boolean getStatus() {
        return status;
    }

    public String getTexto() {
        return texto;
    }
}
