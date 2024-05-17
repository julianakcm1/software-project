package atividade;
import intervaloDeDatas.IntervaloDeDatas;

import java.util.List;

import java.sql.Timestamp;
import java.util.Scanner;

public class Atividade {
    private static int idSemente = 1;
    private int id;
    private String nome;
    private IntervaloDeDatas data;
    private int idResponsavel;
    private List<Integer> idProfissionaisEnvolvidos;
    private List<Integer> idTarefas;

    public Atividade(String nome, String dataInicio, String dataFim, int idResponsavel){
        this.id = idSemente ++;
        this.nome = nome;
        this.data = new IntervaloDeDatas(dataInicio, dataFim);
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
        return data.getDataInicio();
    }

    public void setDataInicio(String dataInicio) {
        this.data.setDataInicio(dataInicio);
    }

    public String getDataFim() {
        return data.getDataFim();
    }

    public void setDataFim(String dataFim) {
        this.data.setDataFim(dataFim);
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

    public void atualizar(){
        Scanner leitor = new Scanner(System.in);
        int entrada;
        while (true){
            System.out.println("\nDigite 0 para alterar o nome da Atividade");
            System.out.println("Digite 1 para alterar a data inicio do projeto");
            System.out.println("Digite 2 para alterar a data fim do projeto");
            System.out.println("Digite 3 para voltar ao menu\n");
            entrada = leitor.nextInt();
            leitor.nextLine();
            if (entrada == 0){
                System.out.println("\nDigite o nome\n");
                String nome = leitor.nextLine();
                this.setNome(nome);
            } else if (entrada == 1) {
                System.out.println("\nDigite a data de inicio\n");
                String data = leitor.nextLine();
                this.setDataInicio(data);
            } else if (entrada == 2) {
                System.out.println("\nDigite a data fim\n");
                String data = leitor.nextLine();
                this.setDataFim(data);
            } else if (entrada == 3) {
               break;
            }
        }
    }

    public void exibir(){
        System.out.println("\nAtividade");
        System.out.println("Nome: " +this.nome);
        System.out.println("Responsavel id: " + this.idResponsavel);
        System.out.println("data de inicio : " +this.getDataInicio());
        System.out.println("data de fim : " +this.getDataFim());
    }
}
