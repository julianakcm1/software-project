package projeto.estado;

import projeto.Projeto;

import java.util.Scanner;

public class Andamento extends Estado{
    protected String nome = "Em Andamento";
    
    Andamento(Projeto projeto) {
        super(projeto);
    }

    @Override
    public void atualizarEstado() {
        if(this.projeto.getDescricao().length() > 1 && this.projeto.getIdAtividades().size() > 1){
            this.projeto.setStatus(new Concluido(this.projeto));
        }
    }
}
