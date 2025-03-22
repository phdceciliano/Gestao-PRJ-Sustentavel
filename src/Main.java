import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Organizacao organizacao = null;
        List<ProjetoSustentavel> projetos = new ArrayList<>();
        List<Voluntario> voluntarios = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Criar Organização");
            System.out.println("2. Adicionar Projeto Sustentável");
            System.out.println("3. Criar Voluntário");
            System.out.println("4. Associar Voluntário a Projeto");
            System.out.println("5. Gerar Relatório de Impacto para Projeto");
            System.out.println("6. Exibir Projetos da Organização");
            System.out.println("7. Exibir Relatórios de Impacto");
            System.out.println("8. Calcular Impacto Ambiental de um Projeto");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo de organização:");
                    System.out.println("1. ONG");
                    System.out.println("2. Empresa");
                    int tipoOrganizacao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    System.out.print("Digite o nome da organização: ");
                    String nomeOrganizacao = scanner.nextLine();

                    if (tipoOrganizacao == 1) {
                        organizacao = new ONG(nomeOrganizacao);
                        System.out.println("ONG criada com sucesso!");
                    } else if (tipoOrganizacao == 2) {
                        System.out.print("Digite o CNPJ da empresa: ");
                        String cnpj = scanner.nextLine();
                        organizacao = new Empresa(nomeOrganizacao, cnpj);
                        System.out.println("Empresa criada com sucesso!");
                    } else {
                        System.out.println("Tipo de organização inválido!");
                    }
                    break;

                case 2:
                    if (organizacao == null) {
                        System.out.println("Crie uma organização primeiro!");
                        break;
                    }
                    System.out.print("Digite o nome do projeto: ");
                    String nomeProjeto = scanner.nextLine();
                    System.out.print("Digite a descrição do projeto: ");
                    String descricaoProjeto = scanner.nextLine();

                    System.out.println("Escolha o tipo de projeto:");
                    System.out.println("1. Reflorestamento");
                    System.out.println("2. Reciclagem");
                    System.out.println("3. Energia Renovável");
                    int tipoProjeto = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    ProjetoSustentavel projeto = null;
                    switch (tipoProjeto) {
                        case 1:
                            System.out.print("Digite o número de árvores plantadas: ");
                            int arvoresPlantadas = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            projeto = new ProjetoReflorestamento(nomeProjeto, descricaoProjeto, arvoresPlantadas);
                            break;
                        case 2:
                            System.out.print("Digite as toneladas recicladas: ");
                            double toneladasRecicladas = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a nova linha
                            projeto = new ProjetoReciclagem(nomeProjeto, descricaoProjeto, toneladasRecicladas);
                            break;
                        case 3:
                            System.out.print("Digite a energia gerada (em kWh): ");
                            double energiaGerada = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a nova linha
                            projeto = new ProjetoEnergiaRenovavel(nomeProjeto, descricaoProjeto, energiaGerada);
                            break;
                        default:
                            System.out.println("Tipo de projeto inválido!");
                            break;
                    }

                    if (projeto != null) {
                        organizacao.adicionarProjeto(projeto);
                        projetos.add(projeto);
                        System.out.println("Projeto adicionado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do voluntário: ");
                    String nomeVoluntario = scanner.nextLine();
                    System.out.print("Digite o email do voluntário: ");
                    String emailVoluntario = scanner.nextLine();
                    Voluntario voluntario = new Voluntario(nomeVoluntario, emailVoluntario);
                    voluntarios.add(voluntario);
                    System.out.println("Voluntário criado com sucesso!");
                    break;

                case 4:
                    if (voluntarios.isEmpty() || projetos.isEmpty()) {
                        System.out.println("Crie voluntários e projetos primeiro!");
                        break;
                    }
                    System.out.println("Escolha um voluntário:");
                    for (int i = 0; i < voluntarios.size(); i++) {
                        System.out.println((i + 1) + ". " + voluntarios.get(i).getNome());
                    }
                    int escolhaVoluntario = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir a nova linha

                    System.out.println("Escolha um projeto:");
                    for (int i = 0; i < projetos.size(); i++) {
                        System.out.println((i + 1) + ". " + projetos.get(i).getNome());
                    }
                    int escolhaProjeto = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir a nova linha

                    voluntarios.get(escolhaVoluntario).participarProjeto(projetos.get(escolhaProjeto));
                    System.out.println("Voluntário associado ao projeto com sucesso!");
                    break;

                case 5:
                    if (projetos.isEmpty()) {
                        System.out.println("Crie projetos primeiro!");
                        break;
                    }
                    System.out.println("Escolha um projeto para gerar relatório de impacto:");
                    for (int i = 0; i < projetos.size(); i++) {
                        System.out.println((i + 1) + ". " + projetos.get(i).getNome());
                    }
                    int escolhaProjetoRelatorio = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir a nova linha

                    ProjetoSustentavel projetoSelecionado = projetos.get(escolhaProjetoRelatorio);
                    if (projetoSelecionado instanceof ProjetoReflorestamento) {
                        System.out.print("Digite o número de árvores plantadas: ");
                        int arvoresPlantadas = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha
                        projetoSelecionado.gerarRelatorioImpacto(arvoresPlantadas, 0); // Redução de CO2 pode ser 0
                    } else if (projetoSelecionado instanceof ProjetoReciclagem) {
                        System.out.print("Digite as toneladas recicladas: ");
                        double toneladasRecicladas = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a nova linha
                        projetoSelecionado.gerarRelatorioImpacto(0, toneladasRecicladas); // Árvores plantadas pode ser 0
                    } else if (projetoSelecionado instanceof ProjetoEnergiaRenovavel) {
                        System.out.print("Digite a energia gerada (em kWh): ");
                        double energiaGerada = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a nova linha
                        projetoSelecionado.gerarRelatorioImpacto(0, energiaGerada); // Árvores plantadas pode ser 0
                    }

                    System.out.println("Relatório de impacto gerado com sucesso!");
                    break;

                case 6:
                    if (organizacao == null) {
                        System.out.println("Crie uma organização primeiro!");
                        break;
                    }
                    System.out.println("Projetos da organização " + organizacao.getNome() + ":");
                    if (organizacao instanceof ONG) {
                        System.out.println("Tipo: ONG");
                    } else if (organizacao instanceof Empresa) {
                        System.out.println("Tipo: Empresa");
                        System.out.println("CNPJ: " + ((Empresa) organizacao).getCnpj());
                    }
                    organizacao.listarProjetos();
                    break;

                case 7:
                    if (projetos.isEmpty()) {
                        System.out.println("Nenhum projeto cadastrado!");
                        break;
                    }
                    for (ProjetoSustentavel p : projetos) {
                        if (p.getRelatorioImpacto() != null) {
                            p.getRelatorioImpacto().exibirRelatorio();
                        }
                    }
                    break;

                case 8:
                    if (projetos.isEmpty()) {
                        System.out.println("Nenhum projeto cadastrado!");
                        break;
                    }
                    System.out.println("Escolha um projeto para calcular o impacto ambiental:");
                    for (int i = 0; i < projetos.size(); i++) {
                        System.out.println((i + 1) + ". " + projetos.get(i).getNome());
                    }
                    int escolhaProjetoImpacto = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir a nova linha

                    double impacto = projetos.get(escolhaProjetoImpacto).calcularImpacto();
                    System.out.println("Impacto ambiental do projeto " + projetos.get(escolhaProjetoImpacto).getNome() + ": " + impacto);
                    System.out.println("Quanto maior o número, maior o impacto positivo !!");
                    break;

                case 9:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}