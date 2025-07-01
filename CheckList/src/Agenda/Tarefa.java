package Agenda;

import java.time.LocalDate;
import java.util.Scanner;

public class Tarefa {
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
    public void criarTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva a tarefa: ");
        this.texto = scanner.nextLine();
        System.out.println("Tarefa criada:" +
                "\n"+this.texto);
        this.status = true;
        this.dataInicio = LocalDate.now();
        this.dataAlteracao = LocalDate.now();
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "\nChecklist:\n" +
                "Tarefa:'" + texto + '\'' +
                " - status:" + status +
                "\nData de criação:" + dataInicio +
                "\nData da ultima alteraçao:" + dataAlteracao +
                '.';
    }
}
