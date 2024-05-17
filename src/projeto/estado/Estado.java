package projeto.estado;

import projeto.Projeto;

//STATE
public abstract class Estado {
    protected Projeto projeto;
    protected String Nome;
    
    Estado(Projeto projeto){
        this.projeto = projeto;
    }

    abstract public void atualizarEstado();
    public String getNome(){
        return this.Nome;
    }
}
