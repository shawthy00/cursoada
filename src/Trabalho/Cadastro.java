package Trabalho;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.*;

public class Cadastro {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");



    // metodos - static, pois pertencem a uma classe, nao a um objeto
    public static void apresentar(){
        System.out.println("Bem vindo ao programa de cadastro de Tarefas.");
        System.out.println("===============Vamos  iniciar================\n");
    }

    public static void menu1(){
        System.out.println("O que deseja realizar?");
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Visualizar tarefas;");
        System.out.println("0 - Sair");
    }

    public static void menuFiltros() {
        System.out.println("O que deseja realizar?");
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Filtrar por status;");
        System.out.println("3 - Filtrar por ordem de data limite;");
        System.out.println("4 - Tarefas não concluidas a partir de uma data (dd/MM/yyyy)");
        System.out.println("0 - Sair");
    }

    public static void menuStatus() {
        System.out.println("Deseja filtrar as tarefas por qual status?");
        System.out.println("1 - PENDENTE");
        System.out.println("2 - EXECUTANDO");
        System.out.println("3 - CONCLUIDA");
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

    // Filtros
    public static void filtrarStatus(List<Tarefa> listaTarefas, int codigoStatus) {
        listaTarefas.stream()
                        .filter(t -> (t.getStatus() == Status.fromCodigo(codigoStatus)))
                        .forEach(Cadastro::listar);
    }

    public static void filtrarNaoConcluidas(List<Tarefa> listaTarefas) {
        listaTarefas.stream()
                .filter(t -> (t.getStatus() != Status.CONCLUIDO))
                .sorted(Comparator.comparing((Tarefa::getDataLimite)))
                .forEach(Cadastro::listar);
    }

    public static void ordenarDatas(List<Tarefa> listaTarefas) {
        listaTarefas.stream()
                .sorted(Comparator.comparing(Tarefa::getDataLimite))
                .forEach(Cadastro::listar);
    }



    //Sobrecarga do metodo listar
    public static void listar(Tarefa t) {
        System.out.printf("%d | %-15s | %-48s | %-12s | %s%n",
                t.getId(),
                t.getTitulo(),
                t.descricaoTrunc(),
                t.getStatus(),
                t.getDataLimite()
        );
    }

    //Sobrecarga sobre o metodo listar
    public static void listar(List<Tarefa> listaTarefas) {

        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("ID | TÍTULO         | DESCRIÇÃO                                       | STATUS     | DATA LIMITE");
        System.out.println("----------------------------------");

        listaTarefas.forEach(t ->
                System.out.printf("%d | %-15s | %-48s | %-12s | %s%n",
                        t.getId(),
                        t.getTitulo(),
                        t.descricaoTrunc(),
                        t.getStatus(),
                        t.getDataLimite()
                )
        );
    }

    // adicionando leitura de arquivo
    public static void carregarArquivo (String nomeArquivo, List<Tarefa> listaTarefas){
        Path caminho = Paths.get(nomeArquivo);

        try {
            if (Files.notExists(caminho)) {
                Files.createFile(caminho);
                Files.writeString(caminho, "ID;TÍTUL;DESCRIÇÃO;STATUS;DATA LIMITE\n");
                return;
            }

            List<String> linhas = Files.readAllLines(caminho);

            int maiorId = 0;    // Variavel local para o id

            for (int i = 1; i < linhas.size(); i++) {
                String[] dados = linhas.get(i).split(";");

                int id = Integer.parseInt(dados[0]);

                Tarefa t = Tarefa.fromArquivo(
                        id,
                        dados[1],
                        dados[2],
                        Status.valueOf(dados[3]),
                        LocalDate.parse(dados[4])
                );
                listaTarefas.add(t);

                maiorId = Math.max(maiorId, id);
            }

            Tarefa.ajustarId(maiorId + 1);

        } catch (IOException e){
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

    }

    public static void salvarArquivo (String nomeArquivo, List<Tarefa> listaTarefas) {
        Path caminho = Paths.get(nomeArquivo);
        StringBuilder sb = new StringBuilder();

        sb.append("ID;TÍTUL;DESCRIÇÃO;STATUS;DATA LIMITE\n");

        for (Tarefa t: listaTarefas){
            sb.append(t.getId()).append(";")
                    .append(t.getTitulo()).append(";")
                    .append(t.getDescricao()).append(";")
                    .append(t.getStatus().name()).append(";")
                    .append(t.getDataLimite()).append("\n");
        }

        try {
            Files.writeString(caminho, sb.toString(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

}

