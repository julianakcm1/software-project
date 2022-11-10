package usuario;

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

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Instituicao: " + this.instituicao);
    }
}
