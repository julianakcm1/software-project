package usuario;

import java.util.Scanner;

public class Professor extends Usuario{
    private String instituicao;

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Professor(String login, String senha, String nome, String palavraPasse, String instituicao) {
        super(login, senha, nome, palavraPasse, "Professor");
        this.instituicao = instituicao;
    }

    public void atualizar() {
        Scanner leitor = new Scanner(System.in);
        int entrada;
        while (true) {
            System.out.println("\nDigite 0 para alterar o login");
            System.out.println("Digite 1 para alterar o nome");
            System.out.println("Digite 2 para alterar a instituicao");
            System.out.println("Digite 3 para alterar a senha");
            System.out.println("Digite 4 para retornar ao menu de alteracoes\n");
            entrada = leitor.nextInt();
            leitor.nextLine();
            if (entrada == 0){
                System.out.println("\nDigite o novo login\n");
                String novoLogin = leitor.nextLine();
                this.setLogin(novoLogin);
            } else if (entrada == 1) {
                System.out.println("\nDigite o novo nome\n");
                String novoNome = leitor.nextLine();
                this.setNome(novoNome);

            } else if (entrada == 2) {
                System.out.println("\nDigite a nova instituicao\n");
                String novaInstituicao = leitor.nextLine();
                this.setInstituicao(novaInstituicao);
            }else if(entrada == 3){
                System.out.println("\nDigite a nova senha\n");
                String novaSenha = leitor.nextLine();
                System.out.println("\nDigite a antiga senha\n");
                String antigaSenha = leitor.nextLine();
                String resultado = this.alterarSenha(antigaSenha, novaSenha);
                System.out.println(resultado);
            } else if (entrada == 4){
                break;
            }else {
                System.out.println("\nErro entrada invalida\n");
            }
        }
    }
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("\nInstituicao: " + this.instituicao);
    }
}
