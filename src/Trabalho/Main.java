package Trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        boolean executando = true;
        Scanner scan = new Scanner(System.in); // abrindo Scanner, CONFERIR FECHAMENTO

        List<Tarefa> listaTarefas = new ArrayList<>();

        while(executando) {
            Cadastro.apresentar();  // saudação

            int opcao = scan.nextInt();
            scan.nextLine();    // limpeza do buffer

            switch (opcao){
                case 1 -> Cadastro.cadastrarTarefa(scan, listaTarefas);

                case 2 -> {
                    Cadastro.listar(listaTarefas);

                    Cadastro.menuFiltros(); // mostra o menu de opções de filtros, implementar melhorias
                    int opcao2 = scan.nextInt();
                    scan.nextLine();

                    switch (opcao2) {
                        case 1 -> Cadastro.listar(listaTarefas);

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

                        case 0 -> {
                            System.out.println("Fechando agenda...");
                            executando = false;
                        }
                        default -> System.out.println("Opcao invalida!!!");

                    }
                }

                case 0 -> {
                    System.out.println("Fechando agenda...");
                    executando = false;
                }
                default -> System.out.println("Opcao invalida!!!");
            }

            //executando = true;

        }
    }
}
