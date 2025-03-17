public class Main {
    public static void main(String[] args) {
        // Criando uma organização
        Organizacao organizacao = new Organizacao("Joinville mais verde");

        // Criando projetos sustentáveis
        ProjetoSustentavel projeto1 = new ProjetoSustentavel("Reflorestamento Urbano", "Plantio de árvores em áreas urbanas");
        ProjetoSustentavel projeto2 = new ProjetoSustentavel("Energia Solar Comunitária", "Instalação de painéis solares em comunidades");

        // Criando voluntários
        Voluntario voluntario1 = new Voluntario("Pedro Ceciliano", "pedroceciliano@example.com");
        Voluntario voluntario2 = new Voluntario("Amanda Otto", "amanda.otto@example.com");

        // Associando voluntários aos projetos
        voluntario1.participarProjeto(projeto1);
        voluntario2.participarProjeto(projeto1);
        voluntario2.participarProjeto(projeto2);

        // Gerando relatórios de impacto
        projeto1.gerarRelatorioImpacto(100, 5.5);
        projeto2.gerarRelatorioImpacto(50, 3.2);

        // Adicionando projetos à organização
        organizacao.adicionarProjeto(projeto1);
        organizacao.adicionarProjeto(projeto2);

        // Listando projetos da organização
        System.out.println("Projetos da organização " + organizacao.getNome() + ":");
        organizacao.listarProjetos();

        // Exibindo relatórios de impacto
        System.out.println("\nRelatórios de Impacto:");
        projeto1.getRelatorioImpacto().exibirRelatorio();
        projeto2.getRelatorioImpacto().exibirRelatorio();
    }
}