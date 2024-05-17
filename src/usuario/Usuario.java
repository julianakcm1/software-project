package usuario;

import jdk.jshell.spi.ExecutionControl;

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
            return "\nSenha: " + this.senha;
        }else{
            return "\nPalavra passe invalida\n";
        }

    }

    public String alterarSenha(String senhaAntiga, String senhaNova){
        if (senhaAntiga.equals(this.senha)){
            this.senha = senhaNova;
            return "\nSenha alterada para: " + this.senha;
        }else{
            return "\nSenha invalida\n";
        }
    }

    public void exibir(){
        System.out.println("\nID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Login: " + this.login);
        System.out.println("Cargo: " + this.cargo);
    }

    public boolean isnull(){
        return false;
    }

    abstract public void atualizar();
    public boolean login(String login, String senha){
        return this.login.equals(login) && this.senha.equals(senha);
    }
}
