package usuario;

// INTRODUCE NULL OBJECT

public class Deslogado extends Usuario{
    public Deslogado() {
        super(null, null, null, null, null);
    }

    @Override
    public void atualizar() {
        throw new IllegalArgumentException("\nNao eh possivel atualizar um usuario nulo\n");
    }

    public boolean isnull(){
        return true;
    }
}
