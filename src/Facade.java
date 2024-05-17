import atividade.Atividade;
import db.singletonDB;
import projeto.Projeto;
import tarefa.Tarefa;
import usuario.Aluno;
import usuario.Pesquisador;
import usuario.Professor;
import usuario.Usuario;

import java.util.List;
import java.util.Scanner;

public class Facade {
    singletonDB db = singletonDB.getInstance();
    public void atualizarUsuario(int id){
        Usuario usuario = db.getUser(id);
        if (usuario.getCargo().equals("Professor")) {
            Professor professor = (Professor)usuario;
            professor.atualizar();
            professor.exibir();

        } else if (usuario.getCargo().equals("Pesquisador")) {
            Pesquisador pesquisador = (Pesquisador)usuario;
            pesquisador.atualizar();
            pesquisador.exibir();

        } else if (usuario.getCargo().equals("Aluno")) {
            Aluno aluno = (Aluno)usuario;
            aluno.atualizar();
            aluno.exibir();
        }
    }

    public void atualizarAtividade(int id){
        Atividade atividade = db.getAtividade(id);
        atividade.atualizar();
        atividade.exibir();
    }


    public void criarUsuario(){
        Scanner leitor = new Scanner(System.in);
        int entrada;
        System.out.println("\nDigite 0 para cadastrar um professor");
        System.out.println("Digite 1 para cadastrar um pesquisador");
        System.out.println("Digite 2 para cadastrar um aluno\n");
        entrada = leitor.nextInt();
        leitor.nextLine();
        if (entrada == 0){
            db.criarProfessor();
        } else if (entrada == 1) {
            db.criarPesquisador();
        } else if (entrada == 2) {
            db.criarAluno();
        }else {
            System.out.println("\nNumero invalido \n");
        }
    }
    
    public void criarAtividade(int idResponsavel){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nDigite o nome\n");
        String nome = leitor.nextLine();
        System.out.println("\nDigite data de inicio\n ");
        String dataInicio = leitor.nextLine();
        System.out.println("\nDigite data fim\n");
        String dataFim = leitor.nextLine();
        Atividade nova_atividade = new Atividade(nome, dataInicio, dataFim, idResponsavel);
        db.addAtividade(nova_atividade);
        nova_atividade.exibir();
    }

    public void criarProjeto(int idResponsavel){
        db.criarProjeto(idResponsavel);
    }
}
