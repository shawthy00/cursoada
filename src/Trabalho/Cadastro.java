package Trabalho;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Cadastro {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");



    // metodos - static, pois pertencem a uma classe, nao a um objeto
    public static void apresentar(){
        System.out.println("Bem vindo ao programa de cadastro de Tarefas.");
        System.out.println("===============Vamos  iniciar================\n");
        System.out.println("O que deseja realizar?");
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Visualizar tarefas;");
        System.out.println("0 - Sair");
    }

    public static void cadastrarTarefa(Scanner scan, List<Tarefa> listaTarefas) {

        System.out.println("Digite o título da tarefa:");
        String titulo = scan.nextLine();

        System.out.println("Digite a descrição (opcional):");
        String descricao = scan.nextLine();

        System.out.println("Digite a data limite (dd/MM/yyyy):");
        String dataTexto = scan.nextLine();

        try {
            LocalDate dataLimite = LocalDate.parse(dataTexto, FORMATTER);

            Tarefa tarefa = new Tarefa(titulo, descricao, dataLimite);
            listaTarefas.add(tarefa);

            System.out.println("Tarefa cadastrada com sucesso!");

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listar(List<Tarefa> listaTarefas) {

        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("ID | TÍTULO         | STATUS                    | DATA LIMITE");
        System.out.println("----------------------------------");

        listaTarefas.forEach(t ->
                System.out.printf("%d | %-15s | %-48s | %s%n",
                        t.getId(),
                        t.getTitulo(),
                        t.descricaoTrunc(),
                        t.getStatus(),
                        t.getDataLimite()
                )
        );
    }




}


// organizar por status
//listaTarefas.stream()
//            .sorted(Comparator.comparing(Tarefa::getStatus))
//        .forEach(System.out::println);


// organizar por data
//listaTarefas.stream()
//            .sorted(Comparator.comparing(Tarefa::getDataLimite))
//        .forEach(System.out::println);
