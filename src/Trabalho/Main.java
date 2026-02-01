package Trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        boolean executando = true;
        Scanner scan = new Scanner(System.in); // abrindo Scanner, CONFERIR FECHAMENTO

        List<Tarefa> listaTarefas = new ArrayList<>();

        Cadastro.carregarArquivo("agenda.csv", listaTarefas);
        Cadastro.apresentar();

        while(executando) {
            Cadastro.menu1();  // saudação

            int opcao = scan.nextInt();
            scan.nextLine();    // limpeza do buffer

            switch (opcao){
                case 1 -> Cadastro.cadastrarTarefa(scan, listaTarefas);

                case 2 -> {
                    Cadastro.listar(listaTarefas);

                    Cadastro.menuFiltros(); // mostra o menu de opções de filtros, 4 opcoes

                    int opcao2 = scan.nextInt();
                    scan.nextLine();

                    switch (opcao2) {
                        case 1 -> Cadastro.cadastrarTarefa(scan, listaTarefas);    // break nao necessario, pois foi usado "->"

                        case 2 -> {
                            Cadastro.menuStatus();

                            int opcaoStatus = scan.nextInt();
                            scan.nextLine();

                            Cadastro.filtrarStatus(listaTarefas, opcaoStatus);

                        }
                        case 3 -> Cadastro.ordenarDatas(listaTarefas);

                        case 4 -> {
                            Cadastro.filtrarNaoConcluidas(listaTarefas);
                        }

                        case 5 -> Tarefa.darInicio(listaTarefas, scan);

                        case 6 -> Tarefa.finalizar(listaTarefas, scan);

                        case 0 -> {
                            Cadastro.salvarArquivo("agenda.csv", listaTarefas);
                            System.out.println("Fechando agenda...");
                            executando = false;
                        }
                        default -> System.out.println("Opcao invalida!!!");

                    }
                }

                case 0 -> {
                    Cadastro.salvarArquivo("agenda.csv", listaTarefas);
                    System.out.println("Fechando agenda...");
                    executando = false;
                }
                default -> System.out.println("Opcao invalida!!!");
            }


        }
    }
}
