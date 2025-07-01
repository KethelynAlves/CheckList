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
        lista.mostrarTarefas(1);
        lista.mostrarTarefas(2);
        lista.mostrarTarefas(3);
        lista.alterarStatus(lista.getTarefaList().get(0));
        lista.mostrarTarefas(1);
        System.out.println("\n\n\nTeste ativo");
        lista.mostrarTarefas(2);
        System.out.println("\n\n\nTeste inativo");
        lista.mostrarTarefas(3);
    }

}