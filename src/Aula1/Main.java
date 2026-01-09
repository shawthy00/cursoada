package Aula1;

public class Main {
    public static void main(String[] args) {

        Barco barco1 = new Barco(Tipos.Iate, new Motor40HP2T());
        Barco barco2 = new Barco(Tipos.Boia_de_Patinho, new Motor60HP4T());

        barco2.setCor(Cores.PINK);
        // não foi definida a cor do barco 1, para mostrar como ficará se não escolhar;

        barco1.getMotor().acelerar();
        barco1.getMotor().acelerar();   // não precisa ser assim, apenas exemplo
        barco1.acelerar();

        barco2.acelerar();
        barco2.acelerar();
        barco2.acelerar();

        String detail1 = barco1.toString();
        System.out.println(detail1);

        String detail2 = barco2.toString();
        System.out.println(detail2);

        for (int i = 1; i < 50; i++) barco2.acelerar(); // mostrando que o barco não passa da velovidade max.

        String detail3 = barco2.toString();
        System.out.println(detail3);
        System.out.println("O patinho está voando.\nQUACK!");
    }
}