package github.com.igomarcelino.faturamentoMensal;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * TODO
 *     Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
 *     O menor valor de faturamento ocorrido em um dia do mês;
 *     O maior valor de faturamento ocorrido em um dia do mês;
 *     Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
 * */
public class Faturamento {
    public static void main(String[] args) {
        List<FaturamentoDiario> faturamentoDiarios = new ArrayList<>();
        System.out.println("Informe o local do arquivo json");
        String caminhoArquivo = caminhoArquivo();
        faturamentoDiarios = faturamentoDiarios(caminhoArquivo);
        if (!faturamentoDiarios.isEmpty()) {
            System.out.println("Dia com menor Faturamento");
            diaComMenorFaturamento(faturamentoDiarios);
            System.out.println("--------------------------");
            System.out.println("Dia com maior Faturamento");
            diaComMaiorFaturamento(faturamentoDiarios);
            System.out.println("--------------------------");
            System.out.println("Dias com faturamento acima da media mensal");
            diaFaturamentoSuperiorMediaMensal(faturamentoDiarios);
        } else {
            System.out.println("Finalizando ....");
        }
    }

    // esse metodo retorna uma Lista<Faturamento> se o arquivo passado no caminho for correspondente ao modelo esperado

    private static List<FaturamentoDiario> faturamentoDiarios(String caminho) {
        // Cria um arrayList para armazenar os faturamentos diarios
        List<FaturamentoDiario> faturamentoDiariosList = new ArrayList<>();
        //Cria uma instancia da classe gson
        Gson gson = new Gson();
        try {
            // O FileReader recebe o caminho do arquivo que sera feito a leitura
            FileReader fileReader = new FileReader(caminho);
            // Definindo o tipo que sera utilizado na deserializacao do arquivo json
            Type typeList = new TypeToken<List<FaturamentoDiario>>() {
            }.getType();
            //atribui cada instancia criada a lista
            faturamentoDiariosList = gson.fromJson(fileReader, typeList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            System.out.println("Arquivo no formato invalido!");
        }
        // Nesse ponto caso o arquivo nao seja do formato do TypeToken ele ira informar

        return faturamentoDiariosList;
    }

    public static String caminhoArquivo() {
        // Utiliza o JFileChooser para localizar e selecionar o arquivo no sistema
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile().getAbsolutePath();
    }

    // metodo que percorre a lista e imprime o dia com menor faturamento
    public static void diaComMenorFaturamento(List<FaturamentoDiario> faturamentoDiarioList) {
        faturamentoDiarioList.stream().
                sorted((o1, o2) -> Double.valueOf(o1.getFaturamento()).compareTo(o2.getFaturamento())).
                limit(1).
                forEach(faturamentoDiario -> System.out.println("Dia: " + faturamentoDiario.getDia_mes() + "" +
                        "                       \nFaturamento diario: " + faturamentoDiario.getFaturamento()));
    }

    // metodo que percorre a lista e imprime o dia com maior faturamento
    public static void diaComMaiorFaturamento(List<FaturamentoDiario> faturamentoDiarioList) {
        faturamentoDiarioList.stream().
                sorted((o1, o2) -> Double.valueOf(o1.getFaturamento()).compareTo(o2.getFaturamento())).
                sorted(Collections.reverseOrder()).
                limit(1).
                forEach(faturamentoDiario -> System.out.println("Dia: " + faturamentoDiario.getDia_mes() + "" +
                        "                       \nFaturamento diario: " + faturamentoDiario.getFaturamento()));
    }

    // metodo que percorre a lsita e imprime todos os dias que tiveram o faturamento maior que a media mensal
    public static void diaFaturamentoSuperiorMediaMensal(List<FaturamentoDiario> faturamentoDiarios){
       double mediaMensal =  faturamentoDiarios.stream().
                filter(faturamentoDiario -> faturamentoDiario.getFaturamento() != 0).
                mapToDouble(valorDiario-> valorDiario.getFaturamento()).average().getAsDouble();
        System.out.println(mediaMensal);
       faturamentoDiarios.stream().
               filter(faturamentoDiario -> faturamentoDiario.getFaturamento() > mediaMensal).
               forEach(faturamentoDiario -> System.out.println("Dia: " + faturamentoDiario.getDia_mes() + "" +
                       "                       \nFaturamento diario: " + faturamentoDiario.getFaturamento()));
    }
}

