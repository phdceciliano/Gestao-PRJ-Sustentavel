import java.util.ArrayList;
import java.util.List;

//Classe e atributos
public class ProjetoSustentavel {
    private String nome;
    private String descricao;
    private List<Voluntario> voluntarios;
    private RelatorioImpacto relatorioImpacto;

    //Construtor
    public ProjetoSustentavel(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
        this.voluntarios = new ArrayList<>();
    }

    //Get e Set
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

    //metodo adicionar Voluntarios
    public void adicionarVoluntario(Voluntario voluntario) {
        voluntarios.add(voluntario);
    }
    //metodo gerar Relatorio de impacto
    public void gerarRelatorioImpacto(int arvoresPlantadas, double reducaoCO2) {
        this.relatorioImpacto = new RelatorioImpacto ( arvoresPlantadas,  reducaoCO2);
    }
    //metodo obter Relatorio de impacto
    public RelatorioImpacto getRelatorioImpacto() {
        return relatorioImpacto;
    }

}
