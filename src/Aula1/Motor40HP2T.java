package Aula1;

public class Motor40HP2T extends Motor {
    // Atributos
    private Cores cor;

    public Motor40HP2T() {
        super();
        this.potencia = 40; //HP
        this.tempos = 2; // Tempos
        this.cor = setCor(Cores.PRETO); // Cor padrão para esse motor
    }

    public Cores getCor() {
        return cor;
    }

    public Cores setCor(Cores cor) {
        return this.cor = cor;
    }

    @Override
    public String toString() {
        return "Motor40HP2T{" +
                "cor=" + cor +
                ", marca='" + marca + '\'' +
                ", potencia=" + potencia +
                ", tempos=" + tempos +
                ", velocidadeMax=" + velocidadeMax +
                ", aceleracao=" + aceleracao +
                ", velocidade=" + velocidade +
                '}';
    }
}
