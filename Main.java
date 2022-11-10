import atividade.Atividade;
import projeto.Projeto;
import usuario.*;
import tarefa.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try{
            Scanner leitor = new Scanner(System.in);
            Usuario atual = null;
            Auxiliar auxiliar = new Auxiliar();
            List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
            List<Projeto> listaDeProjetos = new ArrayList<Projeto>();
            List<Atividade> listaDeAtividades = new ArrayList<Atividade>();
            List<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();


            while (true){
                //Se deslogado
                if (atual == null){
                    System.out.println("Digite 0 para sair");
                    System.out.println("Digite 1 para se cadastrar");
                    System.out.println("Digite 2 para logar");
                    System.out.println("Digite 3 para recuperar a senha");

                    int entrada = leitor.nextInt();
                    leitor.nextLine();

                    if (entrada == 0){
                        break;
                    }else if (entrada == 1){
                        Usuario novoUsuario = auxiliar.criarUsuario();
                        if (novoUsuario == null){
                            System.out.println("Falaha na criacao do novo usuario");
                        }else{
                            listaDeUsuarios.add(novoUsuario);
                            System.out.println("Novo usuario criado com sucesso");
                        }
                    } else if (entrada == 2) {
                        System.out.println("Digite o login");
                        String login = leitor.nextLine();
                        System.out.println("Digite a senha");
                        String senha = leitor.nextLine();
                        boolean logado = false;
                        for (Usuario u : listaDeUsuarios){
                            if (u.login(login, senha)){
                                atual = u;
                                System.out.println("Logado com sucesso");
                                logado = true;
                                break;
                            }
                        }
                        if(!logado){
                            System.out.println("Nao foram encontrados usuarios com essas crendenciais");
                        }
                    } else if (entrada == 3) {
                        System.out.println("Digite o login");
                        String login = leitor.nextLine();
                        System.out.println("Digite a palavra secreta");
                        String palavraSecreta = leitor.nextLine();
                        boolean logado = false;
                        for (Usuario u : listaDeUsuarios){
                            if (u.recuperar_senha(login, palavraSecreta).startsWith("Senha:")){
                                System.out.println(u.recuperar_senha(login, palavraSecreta));
                                logado = true;
                                break;
                            }
                        }
                        if(!logado){
                            System.out.println("Nao foi possivel recuperar a senha");
                        }
                    }else {
                        System.out.println("Numero invalido ");
                    }
                }else {//Se estiver logado
                    System.out.println("Bem vindo: " + atual.getNome());
                    System.out.println("Digite 0 para sair");
                    System.out.println("Digite 1 para deslogar");
                    System.out.println("Digite 2 para alterar-excluir informacoes do usuario");
                    System.out.println("Digite 3 para criar-alterar-excluir informacoes de um projeto");
                    System.out.println("Digite 4 para criar-alterar-excluir informacoes de uma atividade");
                    System.out.println("Digite 5 para criar-alterar-excluir informacoes de uma tarefa");
                    System.out.println("Digite 6 para obter o relatorio geral");
                    System.out.println("Digite 7 para adicionar atividades a um projeto");

                    int entrada = leitor.nextInt();
                    leitor.nextLine();
                    if (entrada == 0){
                        break;
                    }else if (entrada == 1){
                        atual = null;
                    }else if (entrada == 2) {
                        System.out.println("Digite 0 para alterar informacoes suas");
                        System.out.println("Digite 1 para excluir esse usuario");
                        System.out.println("Digite 2 para retornar ao menu");
                        entrada = leitor.nextInt();
                        leitor.nextLine();
                        if(entrada == 0){
                            auxiliar.atualizarUsuario(atual);
                        } else if (entrada == 1) {
                            listaDeUsuarios.remove(atual);
                            atual = null;
                        }else if (entrada == 2) {
                            break;
                        }else {
                            System.out.println("Entrada invalida");
                        }
                    } else if (entrada == 3) {
                        if (atual.getCargo().equals("Professor") || atual.getCargo().equals("Pesquisador")){
                            while (true) {
                                System.out.println("Digite 0 para criar um novo projeto");
                                System.out.println("Digite 1 para alterar um projeto");
                                System.out.println("Digite 2 para deletar um projeto");
                                System.out.println("Digite 3 para retornar ao menu");
                                entrada = leitor.nextInt();
                                leitor.nextLine();
                                if (entrada == 0){
                                    Projeto novoProjeto = auxiliar.criarProjeto(atual.getId());
                                    novoProjeto.exibir();
                                    listaDeProjetos.add(novoProjeto);
                                }else if (entrada == 1){
                                    System.out.println("Digite o id do projeto");
                                    int id_projeto = leitor.nextInt();
                                    leitor.nextLine();
                                    if(!auxiliar.naListaProjeto(id_projeto, listaDeProjetos)){
                                        System.out.println("Projeto nao encontrado ");
                                        continue;
                                    }else{
                                        Projeto projeto = auxiliar.getProjeto(id_projeto, listaDeProjetos);
                                        projeto.exibir();
                                    }
                                } else if (entrada == 2) {
                                    System.out.println("Digite o id do projeto");
                                    int id_projeto = leitor.nextInt();
                                    leitor.nextLine();
                                    if(!auxiliar.naListaProjeto(id_projeto, listaDeProjetos)){
                                        System.out.println("Projeto nao encontrado ");
                                        continue;
                                    }else{
                                        Projeto projeto = auxiliar.getProjeto(id_projeto, listaDeProjetos);
                                        listaDeProjetos.remove(projeto);
                                    }
                                }else if (entrada == 3){
                                    break;
                                }
                            }
                        }else {
                            System.out.println("Permissao negada");
                        }
                    }else if(entrada == 4){// atividade
                        System.out.println("Digite 0 para criar uma nova atividade");
                        System.out.println("Digite 1 para editar uma atividade");
                        System.out.println("Digite 2 para remover uma atividade");
                        System.out.println("Digite 3 para adicionar uma tarefa");
                        System.out.println("Digite 4 para remover uma tarefa");
                        entrada = leitor.nextInt();
                        leitor.nextLine();
                        if(entrada == 0 ){
                            System.out.println("Digite o nome");
                            String nome = leitor.nextLine();
                            System.out.println("Digite data de inicio ");
                            String dataInicio = leitor.nextLine();
                            System.out.println("Digite data fim");
                            String dataFim = leitor.nextLine();
                            Atividade nova_atividade = new Atividade(nome, dataInicio, dataFim, atual.getId());
                            listaDeAtividades.add(nova_atividade);
                            nova_atividade.exibir();
                        }else if(entrada == 1){
                            System.out.println("Digite o id da atividade");
                            int atividadeId = leitor.nextInt();
                            leitor.nextLine();
                            if (auxiliar.naListaAtividade(atividadeId, listaDeAtividades)){
                                auxiliar.alterarAtividade(auxiliar.getAtividade(atividadeId, listaDeAtividades));
                            }else {
                                System.out.println("atividade nao encontrada");
                            }
                        }else if(entrada == 2){
                            System.out.println("Digite o id");
                            int atividadeId = leitor.nextInt();
                            leitor.nextLine();
                            for (Atividade a_tmp : listaDeAtividades){
                                if (a_tmp.getId() == atividadeId){
                                    listaDeAtividades.remove(a_tmp);
                                    break;
                                }
                            }
                        } else if (entrada == 3) {
                            System.out.println("Digite o id da atividade");
                            int atividadeId = leitor.nextInt();
                            leitor.nextLine();
                            Atividade atividade = null;
                            boolean existe = false;
                            for (Atividade a_tmp : listaDeAtividades){
                                if (a_tmp.getId() == atividadeId){
                                    existe = true;
                                    atividade = a_tmp;
                                }
                            }
                            if(!existe){
                                System.out.println("Atividade nao encontrada");
                                continue;
                            }
                            System.out.println("Digite o id da tarefa");
                            int tarefaId = leitor.nextInt();
                            leitor.nextLine();
                            existe = false;
                            for (Tarefa t_tmp : listaDeTarefas){
                                if (t_tmp.getId() == tarefaId){
                                    existe = true;
                                }
                            }
                            if(!existe){
                                System.out.println("Tarefa nao encontrada");
                                continue;
                            }else{
                                atividade.adicionarTarefa(tarefaId);
                            }
                        } else if (entrada == 4) {
                            System.out.println("Digite o id da atividade");
                            int atividadeId = leitor.nextInt();
                            leitor.nextLine();
                            Atividade atividade = null;
                            boolean existe = false;
                            for (Atividade a_tmp : listaDeAtividades){
                                if (a_tmp.getId() == atividadeId){
                                    existe = true;
                                    atividade = a_tmp;
                                }
                            }
                            if(!existe){
                                System.out.println("Atividade nao encontrada");
                                continue;
                            }
                            System.out.println("Digite o id da tarefa");
                            int tarefaId = leitor.nextInt();
                            leitor.nextLine();
                            existe = false;
                            for (Tarefa t_tmp : listaDeTarefas){
                                if (t_tmp.getId() == tarefaId){
                                    existe = true;
                                }
                            }
                            if(!existe){
                                System.out.println("Tarefa nao encontrada");
                                continue;
                            }else{
                                atividade.removerTarefa(tarefaId);
                            }
                        }else {
                            System.out.println("Entrada invalida");
                        }
                    }else if(entrada == 5){// tarefa
                        System.out.println("Digite 0 para criar uma nova tarefa");
                        System.out.println("Digite 1 para remover uma tarefa");

                        entrada = leitor.nextInt();
                        leitor.nextLine();
                        if (entrada == 0){
                            System.out.println("Digite o nome");
                            String nome = leitor.nextLine();
                            System.out.println("Digite id do usuario alocado ");
                            int id = leitor.nextInt();
                            leitor.nextLine();
                            if (auxiliar.naListaUsuario(id, listaDeUsuarios)){
                                Tarefa tarefa = new Tarefa(nome, id);
                                listaDeTarefas.add(tarefa);
                            }else {
                                System.out.println("Usuario nao encontrada");
                            }
                        } else if (entrada == 1) {
                            System.out.println("Digite o id da tarefa");
                            entrada = leitor.nextInt();
                            leitor.nextLine();
                            auxiliar.getTarefas(entrada, listaDeTarefas);

                        }
                    } else if (entrada == 6) {
                        System.out.println("Relatorio Geral");
                        for (Projeto p_tmp : listaDeProjetos){
                            p_tmp.exibir();
                        }
                        for (Usuario u_tmp : listaDeUsuarios){
                            u_tmp.exibir();
                        }
                        for (Atividade a_tmp : listaDeAtividades){
                            a_tmp.exibir();
                        }
                    } else if (entrada == 7) {//adicionar remover atividade
                        System.out.println("Digite 0 para adicionar uma atividade a um projeto ");
                        System.out.println("Digite 1 para remover uma atividade de um projeto");
                        entrada = leitor.nextInt();
                        leitor.nextLine();
                        System.out.println("Digite o id da atividade");
                        int idAtividade = leitor.nextInt();
                        leitor.nextLine();
                        System.out.println("Digite id do projetp ");
                        int idProjeto = leitor.nextInt();
                        leitor.nextLine();
                        if(auxiliar.naListaProjeto(idProjeto, listaDeProjetos) && auxiliar.naListaAtividade(idAtividade, listaDeAtividades)){
                            Projeto p_tmp = auxiliar.getProjeto(idProjeto, listaDeProjetos);
                            p_tmp.addAtividade(idAtividade);
                        }else {
                            System.out.println("Error projeto ou atividade nao encontrada");
                        }
                    }else {
                        System.out.println("Entrada invalida");
                    }
                }
            }

        }catch (NullPointerException n){
            System.out.println("Excecao de ponto nulo");
        }catch (IllegalArgumentException i){
            System.out.println("Excecao de argumento invalido");
        }
        catch (Exception e){
            System.out.println("Excecao nao mapeada");
        }
    }
}
