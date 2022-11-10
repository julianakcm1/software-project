package tarefa;

public class Tarefa {
    private static int idSemente = 1;
    private int id;
    private int idUsuarioAlocado;
    private String nome;

    public Tarefa(String nome, int idUsuarioAlocado){
        this.id = this.idSemente ++;
        this.nome = nome;
        this.idUsuarioAlocado = idUsuarioAlocado;
    }

    public int getIdUsuarioAlocado() {
        return idUsuarioAlocado;
    }

    public void setIdUsuarioAlocado(int idUsuarioAlocado) {
        this.idUsuarioAlocado = idUsuarioAlocado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
