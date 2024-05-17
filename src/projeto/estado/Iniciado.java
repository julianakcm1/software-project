package projeto.estado;

import projeto.Projeto;

import java.util.Scanner;

public class Iniciado extends Estado{
    protected String nome = "Iniciado";
    
    Iniciado(Projeto projeto) {
        super(projeto);
    }

    @Override
    public void atualizarEstado() {
        Scanner leitor = new Scanner(System.in);
        int entrada;
        System.out.println("\nDigite 1 se tem certeza que deseja mudar o estado do projeto para Em Andamento");
        System.out.println("Digite 0 para cancelar\n");
        entrada = leitor.nextInt();
        leitor.nextLine();
        if (entrada == 1){
            this.projeto.setStatus(new Andamento(this.projeto));
        }
    }
}
