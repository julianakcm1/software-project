package db;

import atividade.Atividade;
import projeto.Projeto;
import tarefa.Tarefa;
import usuario.Usuario;

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
                System.out.println("Usuario deletado");
            }
        }
        System.out.println("Usuario nao encontrado");
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
                System.out.println("Projeto deletado");
            }
        }
        System.out.println("Projeto nao encontrado");
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
                System.out.println("Ativade deletada");
            }
        }
        System.out.println("Atividade nao encontrada");
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
                System.out.println("Ativade deletada");
            }
        }
        System.out.println("Atividade nao encontrada");
    }

    public void addTarefa(Tarefa novaTarefa){
        this.listaDeTarefas.add(novaTarefa);
    }
}
