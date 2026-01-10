package Aula2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Horas trabalhado = new Horas();
        float acumulado = 0;

        while (true) {

            System.out.println("Deseja acrescentar um novo registro de dia trabalhado? [S] ou [N]");
            String resposta = scan.nextLine();

            if(resposta.equalsIgnoreCase("S")) {

                acumulado = trabalhado.expediente();

                System.out.println(acumulado);

            } else {
                break;
            }
        }

        Pagamento funciotario1 = new Pagamento(100, acumulado);

        System.out.println(funciotario1.toString());


        scan.close();

    }
}
