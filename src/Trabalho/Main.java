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

                        case 4 -> Cadastro.filtrarNaoConcluidas(listaTarefas, scan);

                        case 5 -> Tarefa.darInicio(listaTarefas, scan);

                        case 6 -> Tarefa.finalizar(listaTarefas, scan);

                        case 0 -> executando = Tarefa.fechamento(listaTarefas); // mais limpo

                        default -> System.out.println("Opcao invalida!!!");

                    }
                }
                case 0 -> executando = Tarefa.fechamento(listaTarefas);

                default -> System.out.println("Opcao invalida!!!");
            }
        }

        Cadastro.proximas(listaTarefas);

    }
}


// MELHORIAS A IMPLENTAR:
// Acertar para as datas ficarem uniformizadas em todas instâncias
// Evitar switch // case na main, reduzindo o código e o desacoplando
// Verificar todas instâncias de excessões
// Implementar setDataLimite(), setTitulo() e setDescricao(), a fim de permitir alterações na aplicação
