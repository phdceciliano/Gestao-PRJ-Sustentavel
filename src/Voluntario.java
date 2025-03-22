//Classe e atributos
public class Voluntario {
    private String nome;
    private String email;

    //Construtor
    public Voluntario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    //Get e Set
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //metodo para Participacao do projeto.
    public void participarProjeto(ProjetoSustentavel projeto) {
        projeto.adicionarVoluntario(this);
    }
}