package github.com.igomarcelino.faturamentoMensal;

public class FaturamentoDiario implements Comparable<FaturamentoDiario> {
    private String dia;

    private double valor;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "FaturamentoDiario{" +
                "dia=" + dia +
                ", valor=" + valor +
                '}';
    }

    public  void imprimirFaturamento(){
        System.out.printf("Dia: %s\nValor: %.2f\n",dia,valor);
    }

    @Override
    public int compareTo(FaturamentoDiario o) {
        return Double.compare(valor,o.getValor());
    }
}
