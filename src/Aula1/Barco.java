package Aula1;

public class Barco {

    private final Tipos tipo;
    private final Motor motor;
    private Cores cor;


    public Barco(Tipos tipo, Motor motor) {
        this.tipo = tipo;
        this.motor = motor;
        this.cor = null;
    }

    public Cores getCor() {
        return cor;
    }

    public void setCor(Cores cor) {
        this.cor = cor;
    }

    public Motor getMotor() {
        return motor;
    }

    public Tipos getTipo() {
        return tipo;
    }

    // Para Barco() poder acelerar sem ficar muito verboso - objeto.motor().acelerar
    public void acelerar() {
        motor.acelerar();
    }

    @Override
    public String toString() {
        return "Barco (" + tipo +
                ") {" +
                "cor=" + cor +
                ", motor=" + motor +
                '}';
    }

}
