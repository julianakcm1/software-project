package atividade;
import java.util.List;

import java.sql.Timestamp;

public class Atividade {
    private static int idSemente = 1;
    private int id;
    private String nome;
    private String dataInicio;
    private String dataFim;
    private int idResponsavel;
    private List<Integer> idProfissionaisEnvolvidos;
    private List<Integer> idTarefas;

    public Atividade(String nome, String dataInicio, String dataFim, int idResponsavel){
        this.id = idSemente ++;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idResponsavel = idResponsavel;
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

    public void adicionarTarefa(int id){
        this.idTarefas.add(id);
    }

    public void removerTarefa(int id){
        this.idTarefas.remove(id);
    }

    public void exibir(){
        System.out.println("Atividade");
        System.out.println("Nome: " +this.nome);
        System.out.println("Responsavel id: " + this.idResponsavel);
        System.out.println("data de inicio : " +this.dataInicio);
        System.out.println("data de fim : " +this.dataFim);
    }
}
