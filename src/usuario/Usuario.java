package usuario;

public abstract class Usuario {
    private static int idSemente = 1;
    private int id;
    protected String login;
    private String senha;
    protected String nome;
    protected String palavraPasse;
    protected String cargo;

    public Usuario(String login, String senha, String nome, String palavraPasse, String cargo){
        this.id = this.idSemente ++;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.palavraPasse = palavraPasse;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String recuperar_senha(String login,String palavraPasse){
        //System.out.println(palavraPasse);
        if (palavraPasse.equals(this.palavraPasse) && login.equals(this.login)){
            return "Senha: " + this.senha;
        }else{
            return "Palavra passe invalida";
        }

    }

    public String alterarSenha(String senhaAntiga, String senhaNova){
        if (senhaAntiga.equals(this.senha)){
            this.senha = senhaNova;
            return "Senha alterada para: " + this.senha;
        }else{
            return "Senha invalida";
        }
    }

    public void exibir(){
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Login: " + this.login);
        System.out.println("Cargo: " + this.cargo);
    }

    public boolean login(String login, String senha){
        return this.login.equals(login) && this.senha.equals(senha);
    }
}
