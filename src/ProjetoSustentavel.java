import java.util.ArrayList;
import java.util.List;
import interfaces.ImpactoAmbiental;

public class ProjetoSustentavel implements ImpactoAmbiental {
    private String nome;
    private String descricao;
    private List<Voluntario> voluntarios;
    private RelatorioImpacto relatorioImpacto;

    public ProjetoSustentavel(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.voluntarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarVoluntario(Voluntario voluntario) {
        voluntarios.add(voluntario);
    }

    public void gerarRelatorioImpacto(int arvoresPlantadas, double reducaoCO2) {
        this.relatorioImpacto = new RelatorioImpacto(arvoresPlantadas, reducaoCO2);
    }

    public RelatorioImpacto getRelatorioImpacto() {
        return relatorioImpacto;
    }

    @Override
    public double calcularImpacto() {
        if (relatorioImpacto == null) {
            System.out.println("Relatório de impacto não gerado para o projeto: " + nome);
            return 0.0;
        }
        // Fórmula de cálculo do impacto ambiental (exemplo simples)
        double impacto = relatorioImpacto.getArvoresPlantadas() * 0.1 + relatorioImpacto.getReducaoCO2() * 100;
        return impacto;
    }
}