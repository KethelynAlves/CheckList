import Agenda.Checklist;

public class Main {
    public static void main(String[] args) {
//        var lista1 = new Checklist();

        System.out.println("Check List:"+
                "\n1) Mostrar tarefas atuais."+
                "\n2) Criar tarefas."+
                "\n3) Alterar status da tarefa.");
        var lista = new Checklist();

        lista.adicionarTarefa();
        lista.adicionarTarefa();
        System.out.println(lista.toString());
    }

}