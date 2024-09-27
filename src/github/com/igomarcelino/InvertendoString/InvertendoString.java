package github.com.igomarcelino.InvertendoString;

import java.util.Scanner;

public class InvertendoString {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe uma palavra para inverter: ");
        String palavra = teclado.nextLine();
        teclado.close();
        inversorDeString(palavra);
    }

    // invertendo a string
    public static void inversorDeString(String string){
        int tamanho = string.length();
       String stringInversa = "";

       // percorrendo todos os indices da string
        for (int i = tamanho - 1;i >= 0;i--){
           stringInversa += string.charAt(i);
        }
        System.out.println(stringInversa);
    }
}
