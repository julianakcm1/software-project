package projeto.estado;

import projeto.Projeto;

public class Concluido extends Estado{
    protected String nome = "Concluido";
    
    Concluido(Projeto projeto) {
        super(projeto);
    }

    @Override
    public void atualizarEstado() {
        System.out.println("\nO projeto ja foi concluido\n");
    }
}
