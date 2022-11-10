package bolsa;

public class Bolsa {
    private static int idSemente = 1;
    private int id;
    private String nome;
    private float valor;
    private int idUser;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Bolsa(String nome, float valor, int idUser){
        this.nome = nome;
        this.valor = valor;
        this.idUser = idUser;
    }
}
