package usuario;

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

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Grau: " + this.grau);
    }
}
