package github.com.igomarcelino.faturamentoMensal;

public class FaturamentoDiario implements Comparable<FaturamentoDiario> {
    private int dia_mes;
    private String dia_semana;
    private double faturamento;

    public int getDia_mes() {
        return dia_mes;
    }

    public void setDia_mes(int dia_mes) {
        this.dia_mes = dia_mes;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    @Override
    public String toString() {
        return "FaturamentoDiario{" +
                "dia_mes=" + dia_mes +
                ", dia_semana='" + dia_semana + '\'' +
                ", faturamento=" + faturamento +
                '}';
    }

    @Override
    public int compareTo(FaturamentoDiario o) {
        return Double.compare(faturamento,o.getFaturamento());
    }
}
