package Aula2;

public class Pagamento {
    // Atributos
    private final double valorHora;
    private double bruto;    // valors por hora
    private final double inss;
    private double irpf;
    private double liquido;


    // Construtor
    public Pagamento(double valorHora, double horas) {
        this.valorHora = valorHora;
        bruto = this.salBruto(horas);
        inss = this.bruto * 0.12;
        irpf = this.bruto * this.impostoRenda();
        liquido = this.bruto - inss - irpf;
    }

    // Metodos
    public double salBruto (double horas) {
        this.bruto = horas * valorHora;
        return bruto;
    }

    private double impostoRenda () {
        double patamar1 = 3000;
        double patamar2 = 5000;
        double patamar3 = 7000;

        if( this.bruto <= patamar1 ) {
            return 0;
        } else if ( this.bruto <= patamar2 ){
            return 0.15;
        } else if ( this.bruto <= patamar3 ){
            return 0.225;
        } else {
            return 0.275;
        }
    }

    //Getters and Setters


    @Override
    public String toString() {
        return "Pagamento{" +
                "valorHora=" + this.getValorHora() +
                ", \nbruto=" + this.getBruto() +
                ", \ninss=" + this.getInss() +
                ", \nirpf=" + this.getIrpf() +
                ", \nliquido=" + this.getLiquido() +
                '}';
    }

    public double getValorHora() {
        return valorHora;
    }

    public double getBruto() {
        return bruto;
    }

    public double getInss() {
        return inss;
    }

    public double getIrpf() {
        return irpf;
    }

    public double getLiquido() {
        return liquido;
    }
}
