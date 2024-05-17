package usuario;

import java.util.Scanner;

public class Pesquisador extends Usuario{
    private String orcid;

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public Pesquisador(String login, String senha, String nome, String palavra_passe, String orcid) {
        super(login, senha, nome, palavra_passe, "Pesquisador");
        this.orcid = orcid;
    }

    public void atualizar() {
        Scanner leitor = new Scanner(System.in);
        int entrada;
        while (true) {
            System.out.println("\nDigite 0 para alterar o login");
            System.out.println("Digite 1 para alterar o nome");
            System.out.println("Digite 2 para alterar o codigo orcid");
            System.out.println("Digite 3 para alterar a senha");
            System.out.println("Digite 4 para finalizar\n");
            entrada = leitor.nextInt();
            leitor.nextLine();
            if (entrada == 0) {
                System.out.println("\nDigite o novo login\n");
                String novoLogin = leitor.nextLine();
                this.setLogin(novoLogin);
            } else if (entrada == 1) {
                System.out.println("\nDigite o novo nome\n");
                String novoNome = leitor.nextLine();
                this.setNome(novoNome);

            } else if (entrada == 2) {
                System.out.println("\nDigite o novo codigo orcid\n");
                String novoOrcid = leitor.nextLine();
                this.setOrcid(novoOrcid);
            } else if (entrada == 3) {
                System.out.println("\nDigite a nova senha\n");
                String novaSenha = leitor.nextLine();
                System.out.println("\nDigite a antiga senha\n");
                String antigaSenha = leitor.nextLine();
                String resultado = this.alterarSenha(antigaSenha, novaSenha);
                System.out.println(resultado);
            } else if (entrada == 4) {
                break;
            } else {
                System.out.println("\nErro entrada invalida\n");
            }
        }
    }

    public void exibir() {
        super.exibir();
        System.out.println("\nOrcid: " + this.orcid);
    }
}
