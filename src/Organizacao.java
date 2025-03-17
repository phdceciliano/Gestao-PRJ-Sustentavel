import java.util.ArrayList;
import java.util.List;

// Classe e atributos
public class Organizacao {
    private String nome;
    private List<ProjetoSustentavel> listaProjetos;

    // Construtor
    public Organizacao(String nome) {
        this.nome = nome;
        this.listaProjetos = new ArrayList<>();
    }

    //Get e Set
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Metodo para adicionar projetos
    public void adicionarProjeto(ProjetoSustentavel projeto){
        listaProjetos.add(projeto);
    }

    //Metodo para listar o projeto
    public void listarProjetos() {
        for (ProjetoSustentavel projeto : listaProjetos) {
            System.out.println("Projeto: " + projeto.getNome() + " - Descrição: " + projeto.getDescricao());
        }
    }
}

