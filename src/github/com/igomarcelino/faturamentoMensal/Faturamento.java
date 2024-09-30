package github.com.igomarcelino.faturamentoMensal;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
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
        System.out.println("Informe o local do arquivo");
        String caminhoArquivo = caminhoArquivo();
        // verifica a extensao do arquivo pelo final do caminho do arquivo
        if (caminhoArquivo.endsWith(".json")){
            faturamentoDiarios = deserializeJson(caminhoArquivo);
        }else if (caminhoArquivo.endsWith(".xml")){
            faturamentoDiarios = deserializeXML(caminhoArquivo);
        }

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
            System.out.println("Nao possui faturamento, finalizando ....");
        }
    }

    /**
     * metodo que obtem o caminho do arquivo informado
     * */

    public static String caminhoArquivo() {
        // Utiliza o JFileChooser para localizar e selecionar o arquivo no sistema
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile().getAbsolutePath();
    }
    /**
     * esse metodo realiza um deserialize do json para uma Lista<FaturamentoDiario>
     */
    private static List<FaturamentoDiario> deserializeJson(String caminho) {
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

/**
 * esse metodo realiza um deserialize do xml para uma Lista<FaturamentoDiario>
 * */
    private static List<FaturamentoDiario> deserializeXML(String caminho){
        // Cria uma lista do farutamento diario
        List<FaturamentoDiario> faturamentoDiarioList = new ArrayList<>();
        try {

            // Cria um leitor de arquivo a partir de um caminho
            FileReader fileReader = new FileReader(caminho);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder arquivoXml = new StringBuilder();
            String linha;

            // verifica se existe linha ser lida
            while ((linha = bufferedReader.readLine())!=null){
                // adiciona a linha linha lida no stringbuilder
                arquivoXml.append(linha);
            }
            // fecha o bufferedReader
            bufferedReader.close();

            // Para que o DOM funcione o arquivo xml precisa ter a estrutura correta, entao adicionaremos a tag
            // <rows></rows> para que o dom possa ler cada row dentro de rows
            String conteudoXML = "<rows>"+arquivoXml.toString()+"</rows>";

            /**
             * Poderiamos apagar da linha 101 ate a linha 134 caso o formato do arquivo xml contensse a tag raiz, por exemplo
             * <rows> // tag raiz
             *     <row>
             *         <dia></dia>
             *         <valor></valor>
             *     </row>
             * </rows>
             *
             * dessa forma poderiamos utilizar
             * DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
             * DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
             * Document document = documentBuilder.parse("caminho do arquivo xml contendo a tag root");
             * */
            // Cria uma nova instancia do documentbuilder factory, permitindo criar um parser a partir de um modelo de documento de objeto
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            // Ao que entendi, esse builder utiliza o builderfactory para criar um parser , a onde consiguira ler as
            // o conteudo das tags
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(conteudoXML)));

            // Cria uma lista de nos de todas as tags row contidas no documento
            NodeList nodeList = document.getElementsByTagName("row");

            // Percorre o nodelist para transformar cado no em um elemento com a ajuda do Element
                for (int i = 0; i < nodeList.getLength();i++){
                    // cria um elemento ( aqui cada row se tornara um elemento para inserirmos em nossa lista )
                    Element row = (Element) nodeList.item(i);
                    FaturamentoDiario faturamentoDiario = new FaturamentoDiario();
                    // captura o conteudo das tags dia e valor
                    String dia = row.getElementsByTagName("dia").item(0).getTextContent();
                    String valor = row.getElementsByTagName("valor").item(0).getTextContent();

                    // atribui os conteudos das tags dias e valor para o nosso objeto faturamentoDiario
                    faturamentoDiario.setDia(dia);
                    faturamentoDiario.setValor(Double.valueOf(valor));

                    // adiciona o faturamentoDiario a lista
                    faturamentoDiarioList.add(faturamentoDiario);
                }
        } catch (ParserConfigurationException e) {
            System.out.println("Nao foi possivel converter o arquivo");
        } catch (IOException e) {
            System.out.println("Verificar arquivo informado");
        } catch (SAXException e) {
            // nesse ponto eu precisaria aprender uma forma de como tratar essa exception
            System.out.println("Estrutura do arquivo invalido");
        }

        return faturamentoDiarioList;
    }

    /**
     * metodo que percorre a lista e imprime o dia com menor faturamento
     * */
    public static void diaComMenorFaturamento(List<FaturamentoDiario> faturamentoDiarioList) {
        faturamentoDiarioList.stream().filter(valorZero -> valorZero.getValor() != 0.0).
                sorted((o1, o2) -> Double.valueOf(o1.getValor()).compareTo(o2.getValor())).
                limit(1).
                forEach(FaturamentoDiario::imprimirFaturamento);
    }

    /**
     * metodo que percorre a lista e imprime o dia com maior faturamento
     * */
    public static void diaComMaiorFaturamento(List<FaturamentoDiario> faturamentoDiarioList) {
        faturamentoDiarioList.stream().filter(valorZero -> valorZero.getValor() != 0.0).
                sorted((o1, o2) -> Double.valueOf(o1.getValor()).compareTo(o2.getValor())).
                sorted(Collections.reverseOrder()).
                limit(1).
                forEach(FaturamentoDiario::imprimirFaturamento);
    }

    /**
     * metodo que percorre a lsita e imprime todos os dias que tiveram o faturamento maior que a media mensal
     * */
    public static void diaFaturamentoSuperiorMediaMensal(List<FaturamentoDiario> faturamentoDiarios){
       double mediaMensal =  faturamentoDiarios.stream().
                filter(faturamentoDiario -> faturamentoDiario.getValor() != 0).
                mapToDouble(valorDiario-> valorDiario.getValor()).average().getAsDouble();
       faturamentoDiarios.stream().
               filter(faturamentoDiario -> faturamentoDiario.getValor() > mediaMensal).
               forEach(FaturamentoDiario::imprimirFaturamento);
    }
}

