import atividade.Atividade;
import projeto.Projeto;
import db.singletonDB;
import usuario.*;
import tarefa.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean rodar = true;
        while (rodar) {
            try {
                Scanner leitor = new Scanner(System.in);
                Usuario atual = new Deslogado();
                Facade facade = new Facade();
                singletonDB db = singletonDB.getInstance();


                while (true) {
                    //Se deslogado
                    if (atual.isnull()) {
                        System.out.println("\nDigite 0 para sair");
                        System.out.println("Digite 1 para se cadastrar");
                        System.out.println("Digite 2 para logar");
                        System.out.println("Digite 3 para recuperar a senha\n");

                        int entrada = leitor.nextInt();
                        leitor.nextLine();

                        if (entrada == 0) {
                            rodar = false;
                            break;
                        } else if (entrada == 1) {
                            facade.criarUsuario();
                        } else if (entrada == 2) {
                            System.out.println("\nDigite o login\n");
                            String login = leitor.nextLine();
                            System.out.println("\nDigite a senha\n");
                            String senha = leitor.nextLine();
                            boolean logado = false;
                            for (Usuario u : db.getListaDeUsuarios()) {
                                if (u.login(login, senha)) {
                                    atual = u;
                                    System.out.println("\nLogado com sucesso\n");
                                    logado = true;
                                    break;
                                }
                            }
                            if (!logado) {
                                System.out.println("\nNao foram encontrados usuarios com essas crendenciais\n");
                            }
                        } else if (entrada == 3) {
                            System.out.println("\nDigite o login\n");
                            String login = leitor.nextLine();
                            System.out.println("\nDigite a palavra secreta\n");
                            String palavraSecreta = leitor.nextLine();
                            boolean logado = false;
                            for (Usuario u : db.getListaDeUsuarios()) {
                                if (u.recuperar_senha(login, palavraSecreta).startsWith("Senha:")) {
                                    System.out.println(u.recuperar_senha(login, palavraSecreta));
                                    logado = true;
                                    break;
                                }
                            }
                            if (!logado) {
                                System.out.println("\nNao foi possivel recuperar a senha\n");
                            }
                        } else {
                            System.out.println("\nNumero invalido \n");
                        }
                    } else {//Se estiver logado
                        System.out.println("\nBem vindo: " + atual.getNome());
                        System.out.println("\nDigite 0 para sair");
                        System.out.println("Digite 1 para deslogar");
                        System.out.println("Digite 2 para alterar-excluir informacoes do usuario");
                        System.out.println("Digite 3 para criar-alterar-excluir informacoes de um projeto");
                        System.out.println("Digite 4 para criar-alterar-excluir informacoes de uma atividade");
                        System.out.println("Digite 5 para criar-alterar-excluir informacoes de uma tarefa");
                        System.out.println("Digite 6 para obter o relatorio geral");
                        System.out.println("Digite 7 para adicionar atividades a um projeto\n");

                        int entrada = leitor.nextInt();
                        leitor.nextLine();
                        if (entrada == 0) {
                            rodar = false;
                            break;
                        } else if (entrada == 1) {
                            atual = new Deslogado();
                        } else if (entrada == 2) {
                            System.out.println("\nDigite 0 para alterar informacoes suas");
                            System.out.println("Digite 1 para excluir esse usuario");
                            System.out.println("Digite 2 para retornar ao menu\n");
                            entrada = leitor.nextInt();
                            leitor.nextLine();
                            if (entrada == 0) {
                                facade.atualizarUsuario(atual.getId());
                            } else if (entrada == 1) {
                                db.delUser(atual.getId());
                                atual = new Deslogado();
                            } else if (entrada == 2) {
                                break;
                            } else {
                                System.out.println("\nEntrada invalida\n");
                            }
                        } else if (entrada == 3) {
                            if (atual.getCargo().equals("Professor") || atual.getCargo().equals("Pesquisador")) {
                                while (true) {
                                    System.out.println("\nDigite 0 para criar um novo projeto");
                                    System.out.println("Digite 1 para alterar um projeto");
                                    System.out.println("Digite 2 para deletar um projeto");
                                    System.out.println("Digite 3 para retornar ao menu\n");
                                    entrada = leitor.nextInt();
                                    leitor.nextLine();
                                    if (entrada == 0) {
                                        facade.criarProjeto(atual.getId());
                                    } else if (entrada == 1) {
                                        System.out.println("\nDigite o id do projeto\n");
                                        int id_projeto = leitor.nextInt();
                                        leitor.nextLine();
                                        if (!db.projectIn(id_projeto)) {
                                            System.out.println("\nProjeto nao encontrado \n");
                                            continue;
                                        } else {
                                            Projeto projeto = db.getProject(id_projeto);
                                            projeto.atualizar();
                                            projeto.exibir();
                                        }
                                    } else if (entrada == 2) {
                                        System.out.println("\nDigite o id do projeto\n");
                                        int id_projeto = leitor.nextInt();
                                        leitor.nextLine();
                                        if (!db.projectIn(id_projeto)) {
                                            System.out.println("\nProjeto nao encontrado \n");
                                            continue;
                                        } else {
                                            db.delProject(id_projeto);
                                        }
                                    } else if (entrada == 3) {
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("\nPermissao negada\n");
                            }
                        } else if (entrada == 4) {// atividade
                            System.out.println("\nDigite 0 para criar uma nova atividade");
                            System.out.println("Digite 1 para editar uma atividade");
                            System.out.println("Digite 2 para remover uma atividade");
                            System.out.println("Digite 3 para adicionar uma tarefa");
                            System.out.println("Digite 4 para remover uma tarefa\n");
                            entrada = leitor.nextInt();
                            leitor.nextLine();
                            if (entrada == 0) {
                                facade.criarAtividade(atual.getId());
                            } else if (entrada == 1) {
                                System.out.println("\nDigite o id da atividade\n");
                                int atividadeId = leitor.nextInt();
                                leitor.nextLine();
                                if (db.atividadeIn(atividadeId)) {
                                    facade.atualizarAtividade(atividadeId);
                                } else {
                                    System.out.println("\nAtividade nao encontrada\n");
                                }
                            } else if (entrada == 2) {
                                System.out.println("\nDigite o id\n");
                                int atividadeId = leitor.nextInt();
                                leitor.nextLine();
                                db.delAtividade(atividadeId);
                            } else if (entrada == 3) {
                                System.out.println("\nDigite o id da atividade\n");
                                int atividadeId = leitor.nextInt();
                                leitor.nextLine();
                                db.delAtividade(atividadeId);
                            } else if (entrada == 4) {
                                System.out.println("\nDigite o id da tarefa\n");
                                int tarefaId = leitor.nextInt();
                                leitor.nextLine();
                                db.delTarefa(tarefaId);
                            } else {
                                System.out.println("\nEntrada invalida\n");
                            }
                        } else if (entrada == 5) {// tarefa
                            System.out.println("\nDigite 0 para criar uma nova tarefa");
                            System.out.println("Digite 1 para remover uma tarefa\n");

                            entrada = leitor.nextInt();
                            leitor.nextLine();
                            if (entrada == 0) {
                                System.out.println("\nDigite o nome\n");
                                String nome = leitor.nextLine();
                                System.out.println("\nDigite id do usuario alocado\n ");
                                int id = leitor.nextInt();
                                leitor.nextLine();
                                if (db.userIn(id)) {
                                    Tarefa tarefa = new Tarefa(nome, id);
                                    db.addTarefa(tarefa);
                                } else {
                                    System.out.println("\nUsuario nao encontrada\n");
                                }
                            } else if (entrada == 1) {
                                System.out.println("\nDigite o id da tarefa\n");
                                entrada = leitor.nextInt();
                                leitor.nextLine();
                                db.delTarefa(entrada);
                            }
                        } else if (entrada == 6) {
                            System.out.println("\nRelatorio Geral\n");
                            for (Projeto p_tmp : db.getListaDeProjetos()) {
                                p_tmp.exibir();
                            }
                            for (Usuario u_tmp : db.getListaDeUsuarios()) {
                                u_tmp.exibir();
                            }
                            for (Atividade a_tmp : db.getListaDeAtividades()) {
                                a_tmp.exibir();
                            }
                        } else if (entrada == 7) {//adicionar remover atividade
                            System.out.println("\nDigite 0 para adicionar uma atividade a um projeto");
                            System.out.println("Digite 1 para remover uma atividade de um projeto\n");
                            entrada = leitor.nextInt();
                            leitor.nextLine();
                            System.out.println("\nDigite o id da atividade\n");
                            int idAtividade = leitor.nextInt();
                            leitor.nextLine();
                            System.out.println("\nDigite id do projeto\n");
                            int idProjeto = leitor.nextInt();
                            leitor.nextLine();
                            if (db.projectIn(idProjeto) && db.atividadeIn(idAtividade)) {
                                Projeto projeto = db.getProject(idProjeto);
                                Atividade atividade = db.getAtividade(idAtividade);
                                if (entrada == 1){
                                    projeto.addAtividade(atividade.getId());
                                } else if (entrada == 2) {
                                    projeto.removeAtividade(atividade.getId());

                                }else {
                                    System.out.println("\nEntrada invalida\n");
                                }
                            } else {
                                System.out.println("\nErro projeto ou atividade nao encontrada\n");
                            }
                        } else {
                            System.out.println("\nEntrada invalida\n");
                        }
                    }
                }
            }catch (NullPointerException n) {
                System.out.println("\nExcecao de ponto nulo\n");
            }catch (IllegalArgumentException i) {
                System.out.println("\nExcecao de argumento invalido\n");
            }catch (InputMismatchException i){
                System.out.println("\nExcecao caracter de entrada invalido\n");
            }catch (Exception e) {
                System.out.println(e);
                System.out.println("\nExcecao nao mapeada\n");
            }
        }
    }
}
