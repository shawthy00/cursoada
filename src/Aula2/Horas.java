package Aula2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Horas {
    // Atributos
    private LocalTime entrada;
    private LocalTime saidaAlmoco;
    private LocalTime retornoAlmoco;
    private LocalTime saida;

    // Construtor


    public Horas() {
    }

    // Metodos
    public float expediente(){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm");

        System.out.print("Hora inicial (HH:mm): ");
        entrada = LocalTime.parse(sc.nextLine(), f);

        System.out.print("Hora de almoço (HH:mm): ");
        saidaAlmoco = LocalTime.parse(sc.nextLine(), f);

        System.out.print("Hora retorno almoço (HH:mm): ");
        retornoAlmoco = LocalTime.parse(sc.nextLine(), f);

        System.out.print("Hora de saida (HH:mm): ");
        saida = LocalTime.parse(sc.nextLine(), f);

        Duration d1, d2, horasTotais;
        d1 = Duration.between(this.getEntrada(), this.getSaidaAlmoco());
        d2 = Duration.between(this.getRetornoAlmoco(), this.getSaida());

        horasTotais = d1.plus(d2);

        float horas = horasTotais.toHours();
        float minutos = horasTotais.toMinutesPart();

        System.out.println("Total trabalhado: " + horas + "h " + minutos + "min");

        return (horas + minutos / 60);
    }


    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public LocalTime getSaidaAlmoco() {
        return saidaAlmoco;
    }

    public void setSaidaAlmoco(LocalTime saidaAlmoco) {
        this.saidaAlmoco = saidaAlmoco;
    }

    public LocalTime getRetornoAlmoco() {
        return retornoAlmoco;
    }

    public void setRetornoAlmoco(LocalTime retornoAlmoco) {
        this.retornoAlmoco = retornoAlmoco;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }
}
