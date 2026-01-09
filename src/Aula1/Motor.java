package Aula1;

public abstract class Motor {
    // Atributos
    public final String marca = "YAMAHA";
    protected int potencia;
    protected int tempos;   // 40 ou 60 - 2 ou  4
    protected float velocidadeMax;
    protected float aceleracao;
    protected float velocidade;

    // Construtor
    public Motor() {
        this.velocidade = 0f; // estado inicial
        this.aceleracao = 0f;
    }

    // Metodos
    public String getMarca() {
        return marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getTempos() {
        return tempos;
    }

    public float getVelocidadeMax() {
        return this.velocidadeMax = this.setVelocidadeMax();
    }

    public float setVelocidadeMax() {
        return switch (this.getPotencia()) {
            case 40 -> this.velocidadeMax = 50f; // km/h
            case 50 -> this.velocidadeMax = 55f; // km/h
            case 60 -> this.velocidadeMax = 65f; // km/h
            default -> this.velocidadeMax = 0; // nao definido ainda
        };
    }

    public float getAceleracao() {
        return this.aceleracao;
    }

    public void acelerar() {
        // definição do fator de aceleração baseada na potencia do motor
        switch (this.getPotencia()) {
            case 40 -> {
                this.aceleracao = 3.50f;
                this.setVelocidade();
            }
            case 50 -> {
                this.aceleracao = 4.25f;
                this.setVelocidade();
            }
            case 60 -> {
                this.aceleracao = 5.00f;
                this.setVelocidade();
            }
            default -> this.aceleracao = 0; // nao definido ainda
        }
    }

    public float getVelocidade(){
        return this.velocidade;
    }

    public void setVelocidade() {
        if (this.getVelocidade() < this.getVelocidadeMax()) {
            this.velocidade += getAceleracao();
        }
    }

    @Override
    public String toString() {
        return "Motor{" +
                "marca='" + marca + '\'' +
                ", potencia=" + potencia +
                ", tempos=" + tempos +
                ", velocidadeMax=" + velocidadeMax +
                ", aceleracao=" + aceleracao +
                ", velocidade=" + velocidade +
                '}';
    }
}