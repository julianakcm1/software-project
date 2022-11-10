package projeto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Projeto {
    private static int idSemente = 1;
    private int id;
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private int idResponsavel;
    private String status;
    private List<Integer> idProfissionaisEnvolvidos;
    private List<Integer> idAtividades;
    private List<Integer> idBolsas;

    public Projeto(String nome, String descricao, String dataInicio, String dataFim, int idResponsavel){
        this.id = idSemente++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idResponsavel = idResponsavel;
        this.status = "Em processo de criação";
        this.idProfissionaisEnvolvidos = new ArrayList<Integer>();
        this.idAtividades = new ArrayList<Integer>();
        this.idBolsas = new ArrayList<Integer>();
    }

    public void mudarStatus(){
        if (this.status.equals("Em processo de criação")){
            if (this.nome.length() > 1 && this.descricao.length() > 1 && this.dataInicio.length() > 1 && this.dataFim.length() > 1){
                this.status = "Iniciado";
            }else{
                System.out.println("Projeto nao cumpre os requisitos minimos para mudar de status");
            }
        } else if (this.status.equals("Iniciado")) {
            Scanner leitor = new Scanner(System.in);
            System.out.println("Realmente quer mudar o status para em andamento ? (digite sim para alterar ou qualquer outra coisa para nao alterar) ");
            String resposta = leitor.nextLine();
            if (resposta.equals("sim")){
                this.status = "Em andamento";
            }else{
                System.out.println("Mudanca de status cancelada");
            }
        } else if (this.status.equals("Em andamento")) {
            if (this.descricao.length() > 1 && this.idAtividades.size() > 1){
                this.status = "Concluido";
            }else{
                System.out.println("Projeto nao cumpre os requisitos minimos para mudar de status");
            }
        } else if (this.status.equals("Concluido")) {
            System.out.println("Projeto ja foi concluido");
        }else {
            System.out.println("Status atual invalido");
        }
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
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public void exibir(){
        System.out.println("Projeto");
        System.out.println("Nome: " + this.nome );
        System.out.println("Descricao: " + this.descricao );
        System.out.println("Data inicio: " + this.dataInicio );
        System.out.println("Data fim: " + this.dataFim );
        System.out.println("Id responsavel: " + this.idResponsavel );
        System.out.println("Status: " + this.status);
    }

    public void addUsuario(int id){
        if(this.idProfissionaisEnvolvidos.contains(id)){
            System.out.println("usuario ja cadastrado");
        }else{
            this.idProfissionaisEnvolvidos.add(id);
            System.out.println("usuario cadastrado com sucesso");
        }

    }
    public void removeUsuario(int id){
        if(this.idProfissionaisEnvolvidos.contains(id)){
            this.idProfissionaisEnvolvidos.remove(id);
            System.out.println("usuario removido com sucesso");
        }else{
            System.out.println("usuario ja nao estava cadastrado");
        }
    }

    public void addAtividade(int id){
        if(this.idAtividades.contains(id)){
            System.out.println("atividade ja cadastrado");
        }else{
            this.idAtividades.add(id);
            System.out.println("atividade cadastrado com sucesso");
        }
    }
    public void removeAtividade(int id){
        if(this.idAtividades.contains(id)){
            this.idAtividades.remove(id);
            System.out.println("atividade removida com sucesso");
        }else{
            System.out.println("atividade ja nao estava cadastrado");
        }
    }
}
