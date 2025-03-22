// ProjetoReflorestamento.java
public class ProjetoReflorestamento extends ProjetoSustentavel {
    private int arvoresPlantadas;

    public ProjetoReflorestamento(String nome, String descricao, int arvoresPlantadas) {
        super(nome, descricao);
        this.arvoresPlantadas = arvoresPlantadas;
    }

    public int getArvoresPlantadas() {
        return arvoresPlantadas;
    }

    public void setArvoresPlantadas(int arvoresPlantadas) {
        this.arvoresPlantadas = arvoresPlantadas;
    }

    @Override
    public double calcularImpacto() {
        return arvoresPlantadas * 0.1; // Exemplo de cálculo de impacto
    }
}