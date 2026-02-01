package Trabalho;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Tarefa {
    // atributos
    private static int id_sequencial = 1;

    private final int id; // id é sequencial e não muda, é uma propriedade da tarefa
    private String titulo;
    private String descricao;
    private LocalDate dataLimite;
    private Status status;

    // construtor publico, para acesso das outras classes que revebem dados do cliente
    public Tarefa(String titulo, String descricao, LocalDate dataLimite) {
        // condicoes de existencia
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo é obrigatório.");
        }

        if (titulo.length() <= 5) {
            throw new IllegalArgumentException("Titulo deve ter mais de 5 caracteres.");
        }

        if (dataLimite == null) {
            throw new IllegalArgumentException("Data limite é obrigatória");
        }

        if (dataLimite.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data limite não pode ser inferior à data atual.");
        }

        // dados do objeto
        this.id = id_sequencial++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataLimite = dataLimite;
        this.status = Status.PENDENTE;  // cadastra pendente automaticamente, mas poderá alterar para EXECUTANDO
    }

    // construtor privado, para receber dados da leitura do arquivo
    // construtor COMPLETO (privado)
    private Tarefa(int id,
                   String titulo,
                   String descricao,
                   Status status,
                   LocalDate dataLimite) {

        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataLimite = dataLimite;
    }

    // metodos
    // metodo para construir objetos do arquivo - para contornar Status e id_sequencial
    public static Tarefa fromArquivo(
            int id,
            String titulo,
            String descricao,
            Status status,
            LocalDate dataLimite) {

        return new Tarefa(id, titulo, descricao, status, dataLimite);
    }

    public static void ajustarId (int proximoId) {
        if (proximoId > id_sequencial) id_sequencial = proximoId;   //ajusta o Id para quando puxa dados do arquivo
    }

    public static Optional<Tarefa> tarefaOpt(List<Tarefa> listaTarefa, int id) {
        return listaTarefa.stream()
                .filter( t -> t.getId() == id)
                .findFirst();
    }

    public static void darInicio(List<Tarefa> listaTarefas, Scanner scan) {
        int total = listaTarefas.size();
        int id = scan.nextInt();

        if( id <= total && id > 0) {
            tarefaOpt(listaTarefas, id)
                    .ifPresent(t -> t.setStatus(Status.EXECUTANDO));
        }
    }

    public static void finalizar (List<Tarefa> listaTarefas, Scanner scan) {
        int total = listaTarefas.size();
        int id = scan.nextInt();

        if (id <= total && id > 0) {
            tarefaOpt(listaTarefas, id)
                    .ifPresent(t -> t.setStatus(Status.CONCLUIDO));
        }
    }

    public String descricaoTrunc() {
        if (this.getDescricao() == null) return "";
        if (this.getDescricao().length() <= 48) return this.getDescricao();
        return this.getDescricao().substring(0, 45) + "...";
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataLimite=" + dataLimite +
                ", status=" + status +
                '}';
    }

    // metodos basicos
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}



// cadastrar, listar e filtrar tarefas

// extras serão pensados apos a entrega minima