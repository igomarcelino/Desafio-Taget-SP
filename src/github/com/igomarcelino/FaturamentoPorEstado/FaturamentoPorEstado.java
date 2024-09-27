package github.com.igomarcelino.FaturamentoPorEstado;

public class FaturamentoPorEstado {
    public static void main(String[] args) {
        double spfaturamento = 67836.43d;
        double rjFaturamento = 36678.66d;
        double mgFaturamento = 29229.88d;
        double esFaturamento = 27165.48d;
        double outrosEstadosFaturamento = 19849.53d;

        double mediaMensal = spfaturamento+rjFaturamento+mgFaturamento+esFaturamento+outrosEstadosFaturamento;

        System.out.printf("Faturamento de Sao Paulo corresponde a %.2f%% do faturamento mensal.",(spfaturamento/mediaMensal)*100);
        System.out.printf("\nFaturamento do Rio de Janeiro corresponde a %.2f%% do faturamento mensal.",(rjFaturamento/mediaMensal)*100);
        System.out.printf("\nFaturamento de Minas Gerais corresponde a %.2f%% do faturamento mensal.",(mgFaturamento/mediaMensal)*100);
        System.out.printf("\nFaturamento de Espirito Santo corresponde a %.2f%% do faturamento mensal.",(esFaturamento/mediaMensal)*100);
        System.out.printf("\nOutros estados correspondem a %.2f%% do faturamento mensal.",(outrosEstadosFaturamento/mediaMensal)*100);
    }
}
