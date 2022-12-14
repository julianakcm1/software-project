package projeto;

import intervaloDeDatas.IntervaloDeDatas;
import projeto.estado.Criacao;
import projeto.estado.Estado;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Projeto {
    private static int idSemente = 1;
    private int id;
    private String nome;
    private String descricao;
    private IntervaloDeDatas data;
    private int idResponsavel;
    private Estado status;
    private List<Integer> idProfissionaisEnvolvidos;
    private List<Integer> idAtividades;
    private List<Integer> idBolsas;

    public Projeto(String nome, String descricao, String dataInicio, String dataFim, int idResponsavel){
        this.id = idSemente++;
        this.nome = nome;
        this.descricao = descricao;
        this.data = new IntervaloDeDatas(dataInicio, dataFim);
        this.idResponsavel = idResponsavel;
        this.status = new Criacao(this);
        this.idProfissionaisEnvolvidos = new ArrayList<Integer>();
        this.idAtividades = new ArrayList<Integer>();
        this.idBolsas = new ArrayList<Integer>();
    }

    public void mudarStatus(){
        this.status.atualizarEstado();
    }

    public void atualizar(){
        Scanner leitor = new Scanner(System.in);
        int entrada;
        while (true){
            System.out.println("\nDigite 0 para alterar o status do projeto");
            System.out.println("Digite 1 para alterar o nome do projeto");
            System.out.println("Digite 2 para alterar a descricao do projeto");
            System.out.println("Digite 3 para alterar a data inicio do projeto");
            System.out.println("Digite 4 para alterar a data fim do projeto");
            System.out.println("Digite 5 para voltar ao menu\n");
            entrada = leitor.nextInt();
            leitor.nextLine();
            if (entrada == 0){
                this.mudarStatus();
            } else if (entrada == 1) {
                System.out.println("\nDigite o nome\n");
                String nome = leitor.nextLine();
                this.setNome(nome);
            } else if (entrada == 2) {
                System.out.println("\nDigite a descricao\n");
                String descricao = leitor.nextLine();
                this.setDescricao(descricao);
            } else if (entrada == 3) {
                System.out.println("\nDigite a data de inicio\n");
                String data = leitor.nextLine();
                this.setDataInicio(data);
            } else if (entrada == 4) {
                System.out.println("\nDigite a data fim\n");
                String data = leitor.nextLine();
                this.setDataFim(data);
            } else if (entrada == 5) {
                break;
            }
        }
    }

    public void setStatus(Estado estado){
        this.status = estado;
    }
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return this.data.getDataInicio();
    }

    public void setDataInicio(String dataInicio) {this.data.setDataInicio(dataInicio);}

    public String getDataFim() {
        return data.getDataFim();
    }

    public void setDataFim(String dataFim) {this.data.setDataFim(dataFim);}

    public IntervaloDeDatas getData() {return data;}

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public void exibir(){
        System.out.println("\nProjeto");
        System.out.println("Nome: " + this.nome );
        System.out.println("Descricao: " + this.descricao );
        this.data.exibir();
        System.out.println("Id responsavel: " + this.idResponsavel );
        System.out.println("Status: " + this.status);
    }

    public void addUsuario(int id){
        if(this.idProfissionaisEnvolvidos.contains(id)){
            System.out.println("\nUsuario ja cadastrado\n");
        }else{
            this.idProfissionaisEnvolvidos.add(id);
            System.out.println("\nUsuario cadastrado com sucesso\n");
        }

    }
    public void removeUsuario(int id){
        if(this.idProfissionaisEnvolvidos.contains(id)){
            this.idProfissionaisEnvolvidos.remove(id);
            System.out.println("\nUsuario removido com sucesso\n");
        }else{
            System.out.println("\nUsuario ja nao estava cadastrado\n");
        }
    }

    public void addAtividade(int id){
        if(this.idAtividades.contains(id)){
            System.out.println("\nAtividade ja cadastrada\n");
        }else{
            this.idAtividades.add(id);
            System.out.println("\nAtividade cadastrada com sucesso\n");
        }
    }
    public void removeAtividade(int id){
        if(this.idAtividades.contains(id)){
            this.idAtividades.remove(id);
            System.out.println("\nAtividade removida com sucesso\n");
        }else{
            System.out.println("\nAtividade ja nao estava cadastrada\n");
        }
    }

    public List<Integer> getIdAtividades() {
        return idAtividades;
    }
}
