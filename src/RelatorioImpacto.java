//Classes e atributos
public class RelatorioImpacto {
    private int arvoresPlantadas;
    private double reducaoCO2;

    //Construtor
    public RelatorioImpacto(int arvoresPlantadas, double reducaoCO2) {
        this.arvoresPlantadas = arvoresPlantadas;
        this.reducaoCO2 = reducaoCO2;
    }
    //Get e Set
    public int getArvoresPlantadas() {
        return arvoresPlantadas;
    }
    public void setArvoresPlantadas(int arvoresPlantadas) {
        this.arvoresPlantadas = arvoresPlantadas;
    }

    public double getReducaoCO2() {
        return reducaoCO2;
    }
    public void setReducaoCO2(double reducaoCO2) {
        this.reducaoCO2 = reducaoCO2;
    }

    //metodo para exibir relatorio
    public void exibirRelatorio() {
        System.out.println("Relatório de Impacto:");
        System.out.println("Árvores Plantadas: " + arvoresPlantadas);
        System.out.println("Redução de CO2: " + reducaoCO2 + " toneladas");
    }
}