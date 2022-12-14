package usuario;

import java.util.Scanner;

public class Aluno extends Usuario{
    private String matricula;
    private String grau;

    public Aluno(String login, String senha, String nome, String palavraPasse, String matricula, String grau) {
        super(login, senha, nome, palavraPasse, "Aluno");
        this.matricula = matricula;
        this.grau = grau;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public void atualizar(){
        Scanner leitor = new Scanner(System.in);
        int entrada;
        while (true){
            System.out.println("\nDigite 0 para alterar o login");
            System.out.println("Digite 1 para alterar o nome");
            System.out.println("Digite 2 para alterar a matricula");
            System.out.println("Digite 3 para alterar o grau");
            System.out.println("Digite 4 para alterar a senha");
            System.out.println("Digite 5 para finalizar\n");
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
                System.out.println("\nDigite a nova matricula\n");
                String novaMatricula = leitor.nextLine();
                this.setMatricula(novaMatricula);
            }else if (entrada == 3) {
                System.out.println("\nDigite o novo grau\n");
                String novoGrau = leitor.nextLine();
                this.setGrau(novoGrau);
            }else if(entrada == 4){
                System.out.println("\nDigite a nova senha\n");
                String novaSenha = leitor.nextLine();
                System.out.println("\nDigite a antiga senha\n");
                String antigaSenha = leitor.nextLine();
                String resultado = this.alterarSenha(antigaSenha, novaSenha);
                System.out.println(resultado);
            }else {
                System.out.println("\nErro entrada invalida\n");
            }
        }
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("\nMatricula: " + this.matricula);
        System.out.println("\nGrau: " + this.grau);
    }
}
