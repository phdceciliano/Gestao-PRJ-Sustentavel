// ProjetoReciclagem.java
public class ProjetoReciclagem extends ProjetoSustentavel {
    private double toneladasRecicladas;

    public ProjetoReciclagem(String nome, String descricao, double toneladasRecicladas) {
        super(nome, descricao);
        this.toneladasRecicladas = toneladasRecicladas;
    }

    public double getToneladasRecicladas() {
        return toneladasRecicladas;
    }

    public void setToneladasRecicladas(double toneladasRecicladas) {
        this.toneladasRecicladas = toneladasRecicladas;
    }

    @Override
    public double calcularImpacto() {
        return toneladasRecicladas * 100; // Exemplo de cálculo de impacto
    }
}