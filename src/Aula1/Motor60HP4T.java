package Aula1;

public class Motor60HP4T extends Motor {

    private Cores cor;

    public Motor60HP4T() {
        super();
        this.potencia = 60; //HP
        this.tempos = 4; // Tempos
        this.cor = setCor(Cores.CINZA); // Cor padrão para esse motor
    }

    public Cores getCor() {
        return cor;
    }

    public Cores setCor(Cores cor) {
        return this.cor = cor;
    }

    @Override
    public String toString() {
        return "Motor60HP4T{" +
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
