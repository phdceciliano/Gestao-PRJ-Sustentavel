// ProjetoEnergiaRenovavel.java
public class ProjetoEnergiaRenovavel extends ProjetoSustentavel {
    private double energiaGerada;

    public ProjetoEnergiaRenovavel(String nome, String descricao, double energiaGerada) {
        super(nome, descricao);
        this.energiaGerada = energiaGerada;
    }

    public double getEnergiaGerada() {
        return energiaGerada;
    }

    public void setEnergiaGerada(double energiaGerada) {
        this.energiaGerada = energiaGerada;
    }

    @Override
    public double calcularImpacto() {
        return energiaGerada * 0.5; // Exemplo de cálculo de impacto
    }
}