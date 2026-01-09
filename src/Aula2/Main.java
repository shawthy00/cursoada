package Aula2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        parcelas(10);
    }


    public static void parcelas(int quant) {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var hoje = LocalDate.now();
        LocalDate prox;

        for(int k = 1; k <= quant; k++){
            prox = hoje.plusMonths(k);
            System.out.println("A parcela " + k + "será em: " + prox.format(formatter));
        }
    }
}