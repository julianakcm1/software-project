package usuario;

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

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Orcid: " + this.orcid);
    }
}
