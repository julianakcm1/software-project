package projeto.estado;

import projeto.Projeto;

public class Criacao extends Estado{
    protected String nome = "Criacao";
    
    public Criacao(Projeto projeto) {
        super(projeto);
    }

    @Override
    public void atualizarEstado() {
        if (this.projeto.getNome().length() > 1 && this.projeto.getDescricao().length() > 1 && this.projeto.getData().datasValidas()){
            this.projeto.setStatus(new Iniciado(this.projeto));
        }else{
            System.out.println("\nO projeto nao cumpre os requisitos minimos para mudar de status\n");
        }
    }


}
