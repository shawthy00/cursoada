package Trabalho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

                case 2 -> Cadastro.listar(listaTarefas);

                case 0 -> {
                    System.out.println("Fechando agenda.");
                    executando = false;
                }

                default -> System.out.println("Opcao invalida!!!");
            }


            // cadastro
            // alterar
            // visualizar//listar
            // encerrar

            executando = true;

        }
    }
}
