package Aula2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainJutos {

    public static void main(String[] argd){
        parcelas(1000, 1f, 12);
        aplicacoes(1000, 1f, 12);
    }


    public static void parcelas(float principal, float juro, int meses) {

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var hoje = LocalDate.now();
        float valor = principal;
        LocalDate mes;

        for(int k = 1; k <= meses; k++){
            mes = hoje.plusMonths(k);
            valor *= (1 + juro/100);
            System.out.println("Você terá " + valor + " em: " + mes.format(formatter));
        }
    }

    public static void aplicacoes(float aplicacao, float juro, int meses){
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var hoje = LocalDate.now();
        float valor = aplicacao;
        LocalDate mes;

        for(int k = 1; k <= meses; k++){
            mes = hoje.plusMonths(k);
            valor *= (1 + juro/100);
            System.out.println("Você terá " + valor + " em: " + mes.format(formatter));
            valor += aplicacao; // o novo depósito é contabilizado apos calclo do juro
        }
    }

}
