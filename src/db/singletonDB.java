package db;

import atividade.Atividade;
import projeto.Projeto;
import tarefa.Tarefa;
import usuario.Aluno;
import usuario.Pesquisador;
import usuario.Professor;
import usuario.Usuario;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class singletonDB {

    private static singletonDB uniqueInstance;
    private List<Usuario> listaDeUsuarios;
    private List<Projeto> listaDeProjetos;
    private List<Atividade> listaDeAtividades;
    private List<Tarefa> listaDeTarefas;

    private singletonDB() {
        this.listaDeUsuarios = new ArrayList<Usuario>();
        this.listaDeProjetos = new ArrayList<Projeto>();
        this.listaDeAtividades = new ArrayList<Atividade>();
        this.listaDeTarefas = new ArrayList<Tarefa>();
    }

    public List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public List<Projeto> getListaDeProjetos() {
        return listaDeProjetos;
    }

    public List<Atividade> getListaDeAtividades() {
        return listaDeAtividades;
    }

    public List<Tarefa> getListaDeTarefas() {
        return listaDeTarefas;
    }

    public static synchronized singletonDB getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new singletonDB();
        return uniqueInstance;
    }

    public boolean userIn(int id){
        for (Usuario u : this.listaDeUsuarios){
            if (u.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Usuario getUser(int id ){
        for (Usuario u : this.listaDeUsuarios){
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }

    public void delUser(int id){
        for (Usuario u : this.listaDeUsuarios){
            if (u.getId() == id){
                listaDeUsuarios.remove(u);
                System.out.println("\nUsuario deletado\n");
            }
        }
        System.out.println("\nUsuario nao encontrado\n");
    }

    public void addUser(Usuario novoUsuario){
        this.listaDeUsuarios.add(novoUsuario);
    }

    public boolean projectIn(int id){
        for (Projeto p : this.listaDeProjetos){
            if (p.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Projeto getProject(int id ){
        for (Projeto p : this.listaDeProjetos){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void delProject(int id){
        for (Projeto p : this.listaDeProjetos){
            if (p.getId() == id){
                listaDeProjetos.remove(p);
                System.out.println("\nProjeto deletado\n");
            }
        }
        System.out.println("\nProjeto nao encontrado\n");
    }

    public void addProject(Projeto novoProjeto){
        this.listaDeProjetos.add(novoProjeto);
    }


    public boolean atividadeIn(int id){
        for (Atividade a : this.listaDeAtividades){
            if (a.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Atividade getAtividade(int id ){
        for (Atividade a : this.listaDeAtividades){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public void delAtividade(int id){
        for (Atividade a : this.listaDeAtividades){
            if (a.getId() == id){
                listaDeProjetos.remove(a);
                System.out.println("\nAtivade deletada\n");
            }
        }
        System.out.println("\nAtividade nao encontrada\n");
    }

    public void addAtividade(Atividade novaAtividade){
        this.listaDeAtividades.add(novaAtividade);
    }

    public boolean tarefaIn(int id){
        for (Tarefa t : this.listaDeTarefas){
            if (t.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Tarefa getTarefa(int id){
        for (Tarefa t : this.listaDeTarefas){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public void delTarefa(int id){
        for (Tarefa t : this.listaDeTarefas){
            if (t.getId() == id){
                listaDeTarefas.remove(t);
                System.out.println("\nAtivade deletada\n");
            }
        }
        System.out.println("\nAtividade nao encontrada\n");
    }

    public void addTarefa(Tarefa novaTarefa){
        this.listaDeTarefas.add(novaTarefa);
    }

    public void criarAluno(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nDigite o login\n");
        String login = leitor.nextLine();
        System.out.println("\nDigite a senha\n");
        String senha = leitor.nextLine();
        System.out.println("\nDigite o nome\n");
        String nome = leitor.nextLine();
        System.out.println("\nDigite a palavra passe(usada para recuperar senha)\n");
        String palavraPasse = leitor.nextLine();
        System.out.println("\nDigite a matricula do aluno\n");
        String matricula = leitor.nextLine();
        System.out.println("\nDigite o grau do aluno (bacharel, mestre, doutor...)\n");
        String grau = leitor.nextLine();

        Aluno novoAluno = new Aluno(login, senha, nome, palavraPasse, matricula, grau);
        this.listaDeUsuarios.add(novoAluno);
        novoAluno.exibir();
    }

    public void criarProfessor(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nDigite o login\n");
        String login = leitor.nextLine();
        System.out.println("\nDigite a senha\n");
        String senha = leitor.nextLine();
        System.out.println("\nDigite o nome\n");
        String nome = leitor.nextLine();
        System.out.println("\nDigite a palavra passe(usada para recuperar senha)\n");
        String palavraPasse = leitor.nextLine();
        System.out.println("\nDigite a instituicao do professor\n");
        String instituicao = leitor.nextLine();
        Professor novoProfessor = new Professor(login, senha, nome, palavraPasse, instituicao);
        this.listaDeUsuarios.add(novoProfessor);
        novoProfessor.exibir();
    }

    public void criarPesquisador(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nDigite o login\n");
        String login = leitor.nextLine();
        System.out.println("\nDigite a senha\n");
        String senha = leitor.nextLine();
        System.out.println("\nDigite o nome\n");
        String nome = leitor.nextLine();
        System.out.println("\nDigite a palavra passe(usada para recuperar senha)\n");
        String palavraPasse = leitor.nextLine();
        System.out.println("\nDigite o orcid do pesquisador\n");
        String orcid = leitor.nextLine();
        Pesquisador novoPesquisador = new Pesquisador(login, senha, nome, palavraPasse, orcid);
        novoPesquisador.exibir();
    }

    public void criarProjeto(int idResponsavel){
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nDigite o nome do projeto(se nao definido colocar em branco)\n");
        String nome = leitor.nextLine();
        System.out.println("\nDigite a descricao do projeto(se nao definido colocar em branco)\n");
        String descricao = leitor.nextLine();
        System.out.println("\nDigite a data de inicio do projeto(se nao definido colocar em branco)\n");
        String dataInicio = leitor.nextLine();
        System.out.println("\nDigite a data de fim do projeto (se nao definido colocar em branco)\n");
        String dataFim = leitor.nextLine();
        Projeto novoProjeto = new Projeto(nome, descricao, dataInicio, dataFim, idResponsavel);
        this.addProject(novoProjeto);
        novoProjeto.exibir();
    }
}
