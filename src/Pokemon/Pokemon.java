package Pokemon;

public class Pokemon {
    // atributos
    private final String nome;
    private int ataque;
    private int defesa;
    private int vida;
    private final Tipo tipo;

    // construtor
    public Pokemon(String nome, int ataque, int defesa, int vida, Tipo tipo) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.tipo = tipo;
    }''

    // metodos
    public void atacar(Pokemon defensor) {
        defensor.setVida(
                defensor.getVida()
                        - (int) (this.ataque * this.corretorAtaque(defensor))
        );
    }

    public double corretorAtaque(Pokemon defensor) {
        switch (this.getTipo()) {
            case Tipo.ELETRICO -> {
                if (defensor.getTipo() == Tipo.AGUA) return 1.2;
                if (defensor.getTipo() == Tipo.PEDRA) return 0.8;
            }
            case Tipo.AGUA -> {
                if (defensor.getTipo() == Tipo.FOGO) return 1.2;
                if (defensor.getTipo() == Tipo.ELETRICO) return 0.8;
            }
            case Tipo.FOGO -> {
                if (defensor.getTipo() == Tipo.GELO) return 1.2;
                if (defensor.getTipo() == Tipo.AGUA) return 0.8;
            }
            case Tipo.GELO -> {
                if (defensor.getTipo() == Tipo.PEDRA) return 1.2;
                if (defensor.getTipo() == Tipo.FOGO) return 0.8;
            }
            case Tipo.PEDRA -> {
                if (defensor.getTipo() == Tipo.ELETRICO) return 1.2;
                if (defensor.getTipo() == Tipo.GELO) return 0.8;
            }
            default -> {
                return 1;
            }
        }
        return 1;
    }


    // getters and setters
    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Tipo getTipo() {
        return tipo;
    }
}