import atividade.Atividade;
import projeto.Projeto;
import tarefa.Tarefa;
import usuario.Aluno;
import usuario.Pesquisador;
import usuario.Professor;
import usuario.Usuario;

import java.util.List;
import java.util.Scanner;

public class Auxiliar {
    public Usuario atualizarUsuario(Usuario usuario){
        Scanner leitor = new Scanner(System.in);
        int entrada;
        while (true){
            if (usuario.getCargo().equals("Professor")){
                System.out.println("Digite 0 para alterar o login");
                System.out.println("Digite 1 para alterar o nome");
                System.out.println("Digite 2 para alterar a instituicao");
                System.out.println("Digite 3 para alterar a senha");
                System.out.println("Digite 4 para retornar ao menu de alteracoes");
                entrada = leitor.nextInt();
                leitor.nextLine();
                if (entrada == 0){
                    System.out.println("Digite o novo login");
                    String novoLogin = leitor.nextLine();
                    usuario.setLogin(novoLogin);
                } else if (entrada == 1) {
                    System.out.println("Digite o novo nome");
                    String novoNome = leitor.nextLine();
                    usuario.setNome(novoNome);

                } else if (entrada == 2) {
                    System.out.println("Digite a nova instituicao");
                    String novaInstituicao = leitor.nextLine();
                    if(usuario instanceof Professor) ((Professor)usuario).setInstituicao(novaInstituicao);
                    else {
                        System.out.println("Erro ao alterar a instituicao");
                    }
                }else if(entrada == 3){
                    System.out.println("Digite a nova senha");
                    String novaSenha = leitor.nextLine();
                    System.out.println("Digite a antiga senha");
                    String antigaSenha = leitor.nextLine();
                    String resultado = usuario.alterarSenha(antigaSenha, novaSenha);
                    System.out.println(resultado);
                } else if (entrada == 4){
                    break;
                }else {
                    System.out.println("Erro entrada invalida");
                }

            } else if (usuario.getCargo().equals("Pesquisador")) {
                System.out.println("Digite 0 para alterar o login");
                System.out.println("Digite 1 para alterar o nome");
                System.out.println("Digite 2 para alterar o codigo orcid");
                System.out.println("Digite 3 para alterar a senha");
                System.out.println("Digite 4 para retornar ao menu de alteracoes");
                entrada = leitor.nextInt();
                leitor.nextLine();
                if (entrada == 0){
                    System.out.println("Digite o novo login");
                    String novoLogin = leitor.nextLine();
                    usuario.setLogin(novoLogin);
                } else if (entrada == 1) {
                    System.out.println("Digite o novo nome");
                    String novoNome = leitor.nextLine();
                    usuario.setNome(novoNome);

                } else if (entrada == 2) {
                    System.out.println("Digite o novo codigo orcid");
                    String novoOrcid = leitor.nextLine();
                    if(usuario instanceof Pesquisador) ((Pesquisador)usuario).setOrcid(novoOrcid);
                    else {
                        System.out.println("Erro ao alterar o codigo orcid");
                    }
                }else if(entrada == 3){
                    System.out.println("Digite a nova senha");
                    String novaSenha = leitor.nextLine();
                    System.out.println("Digite a antiga senha");
                    String antigaSenha = leitor.nextLine();
                    String resultado = usuario.alterarSenha(antigaSenha, novaSenha);
                    System.out.println(resultado);
                } else if (entrada == 4){
                    break;
                }else {
                    System.out.println("Erro entrada invalida");
                }

            } else if (usuario.getCargo().equals("Aluno")) {
                System.out.println("Digite 0 para alterar o login");
                System.out.println("Digite 1 para alterar o nome");
                System.out.println("Digite 2 para alterar a matricula");
                System.out.println("Digite 3 para alterar o grau");
                System.out.println("Digite 4 para alterar a senha");
                System.out.println("Digite 5 para retornar ao menu de alteracoes");
                entrada = leitor.nextInt();
                leitor.nextLine();
                if (entrada == 0){
                    System.out.println("Digite o novo login");
                    String novoLogin = leitor.nextLine();
                    usuario.setLogin(novoLogin);
                } else if (entrada == 1) {
                    System.out.println("Digite o novo Nome");
                    String novoNome = leitor.nextLine();
                    usuario.setNome(novoNome);

                } else if (entrada == 2) {
                    System.out.println("Digite a nova matricula");
                    String novaMatricula = leitor.nextLine();
                    if(usuario instanceof Aluno) ((Aluno)usuario).setMatricula(novaMatricula);
                    else {
                        System.out.println("Erro ao alterar o codigo orcid");
                    }
                }else if (entrada == 3) {
                    System.out.println("Digite o novo grau");
                    String novoGrau = leitor.nextLine();
                    if(usuario instanceof Aluno) ((Aluno)usuario).setGrau(novoGrau);
                    else {
                        System.out.println("Erro ao alterar o codigo orcid");
                    }
                }else if(entrada == 4){
                    System.out.println("Digite a nova senha");
                    String novaSenha = leitor.nextLine();
                    System.out.println("Digite a antiga senha");
                    String antigaSenha = leitor.nextLine();
                    String resultado = usuario.alterarSenha(antigaSenha, novaSenha);
                    System.out.println(resultado);
                } else if (entrada == 4){
                    break;
                }else {
                    System.out.println("Erro entrada invalida");
                }

            } else{
                System.out.println("Erro cargo do funcionario invalido ");
                usuario = null;
                break;
            }
            usuario.exibir();
        }
        return usuario;
    }

    public Usuario criarUsuario(){
        Scanner leitor = new Scanner(System.in);
        int entrada;
        System.out.println("Digite 0 para cadastrar um professor");
        System.out.println("Digite 1 para cadastrar um pesquisador");
        System.out.println("Digite 2 para cadastrar um aluno");
        entrada = leitor.nextInt();
        leitor.nextLine();
        if (entrada == 0){
            System.out.println("Digite o login");
            String login = leitor.nextLine();
            System.out.println("Digite a senha");
            String senha = leitor.nextLine();
            System.out.println("Digite o nome");
            String nome = leitor.nextLine();
            System.out.println("Digite a palavra passe(usada para recuperar senha)");
            String palavraPasse = leitor.nextLine();
            System.out.println("Digite a instituicao do professor");
            String instituicao = leitor.nextLine();
            Professor novoUsuario = new Professor(login, senha, nome, palavraPasse, instituicao);
            novoUsuario.exibir();
            return novoUsuario;

        } else if (entrada == 1) {
            System.out.println("Digite o login");
            String login = leitor.nextLine();
            System.out.println("Digite a senha");
            String senha = leitor.nextLine();
            System.out.println("Digite o nome");
            String nome = leitor.nextLine();
            System.out.println("Digite a palavra passe(usada para recuperar senha)");
            String palavraPasse = leitor.nextLine();
            System.out.println("Digite o orcid do pesquisador");
            String orcid = leitor.nextLine();
            Pesquisador novoUsuario = new Pesquisador(login, senha, nome, palavraPasse, orcid);
            novoUsuario.exibir();
            return novoUsuario;

        } else if (entrada == 2) {
            System.out.println("Digite o login");
            String login = leitor.nextLine();
            System.out.println("Digite a senha");
            String senha = leitor.nextLine();
            System.out.println("Digite o nome");
            String nome = leitor.nextLine();
            System.out.println("Digite a palavra passe(usada para recuperar senha)");
            String palavraPasse = leitor.nextLine();
            System.out.println("Digite a matricula do aluno");
            String matricula = leitor.nextLine();
            System.out.println("Digite o grau do aluno (bacharel, mestre, doutor...)");
            String grau = leitor.nextLine();
            Aluno novoUsuario = new Aluno(login, senha, nome, palavraPasse, matricula, grau);
            novoUsuario.exibir();
            return novoUsuario;
        }else {
            System.out.println("Numero invalido ");
            return null;
        }
    }

    public Projeto criarProjeto(int id){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome do projeto(se nao definido colocar em branco)");
        String nome = leitor.nextLine();
        System.out.println("Digite a descricao do projeto(se nao definido colocar em branco)");
        String descricao = leitor.nextLine();
        System.out.println("Digite a data de inicio do projeto(se nao definido colocar em branco)");
        String dataInicio = leitor.nextLine();
        System.out.println("Digite a data de fim do projeto (se nao definido colocar em branco)");
        String dataFim = leitor.nextLine();
        return new Projeto(nome, descricao, dataInicio, dataFim, id);
    }

    public boolean naListaUsuario(int id, List<Usuario> listaDeUsuarios){
        for (Usuario u : listaDeUsuarios){
            if (u.getId() == id){
               return true;
            }
        }
        return false;
    }

    public boolean naListaAtividade(int id, List<Atividade> listaDeAtividades){
        for (Atividade a : listaDeAtividades){
            if (a.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean naListaTarefa(int id, List<Tarefa> listaDeTarefas){
        for (Tarefa t : listaDeTarefas){
            if (t.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean naListaProjeto(int id, List<Projeto> listaDeProjetos){
        for (Projeto p : listaDeProjetos){
            if (p.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Projeto getProjeto(int id, List<Projeto> listaDeProjetos){
        for (Projeto p : listaDeProjetos){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public Atividade getAtividade(int id, List<Atividade> listaDeAtividade){
        for (Atividade p : listaDeAtividade){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public Tarefa getTarefas(int id, List<Tarefa> listaDeTarefas){
        for (Tarefa p : listaDeTarefas){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void alterarProjeto(Projeto projeto){
        Scanner leitor = new Scanner(System.in);
        int entrada;
        while (true){
            System.out.println("Digite 0 para alterar o status do projeto");
            System.out.println("Digite 1 para alterar o nome do projeto");
            System.out.println("Digite 2 para alterar a descricao do projeto");
            System.out.println("Digite 3 para alterar a data inicio do projeto");
            System.out.println("Digite 4 para alterar a data fim do projeto");
            System.out.println("Digite 5 para voltar ao menu");
            entrada = leitor.nextInt();
            leitor.nextLine();
            if (entrada == 0){
                projeto.mudarStatus();
            } else if (entrada == 1) {
                System.out.println("Digite o nome");
                String nome = leitor.nextLine();
                projeto.setNome(nome);
            } else if (entrada == 2) {
                System.out.println("Digite a descricao");
                String descricao = leitor.nextLine();
                projeto.setDescricao(descricao);
            } else if (entrada == 3) {
                System.out.println("Digite a data");
                String data = leitor.nextLine();
                projeto.setDataInicio(data);
            } else if (entrada == 4) {
                System.out.println("Digite a data");
                String data = leitor.nextLine();
                projeto.setDataFim(data);
            } else if (entrada == 5) {
                break;
            }
        }
    }

    public void alterarAtividade(Atividade atividade){
        Scanner leitor = new Scanner(System.in);
        int entrada;
        while (true){
            System.out.println("Digite 0 para alterar o nome da atividade");
            System.out.println("Digite 1 para alterar a data de inicio");
            System.out.println("Digite 2 para alterar a data de fim");
            entrada = leitor.nextInt();
            leitor.nextLine();
            if (entrada == 0){
                System.out.println("Digite o nome");
                String nome = leitor.nextLine();
                atividade.setNome(nome);
            } else if (entrada == 1) {
                System.out.println("Digite a data de inicio");
                String data = leitor.nextLine();
                atividade.setDataInicio(data);
            } else if (entrada == 2) {
                System.out.println("Digite a data de fim");
                String data = leitor.nextLine();
                atividade.setDataFim(data);
            } else if (entrada == 3) {
                break;
            }

        }
    }
}
