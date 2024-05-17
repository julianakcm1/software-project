package intervaloDeDatas;

//Introduce Parameter Object

public class IntervaloDeDatas {
    private String dataInicio;
    private String dataFim;

    public IntervaloDeDatas(String dataInicio, String dataFim){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    public String exibir(){
        return "\nData de inicio: " + this.dataInicio + "/n Data de inicio: " + this.dataFim;
    }

    public boolean dataInicioValida(){
        return this.dataInicio.length() > 1;
    }

    public boolean dataFimValida(){
        return this.dataFim.length() > 1;
    }

    public boolean datasValidas(){
        return this.dataInicioValida() && this.dataFimValida();
    }
}
