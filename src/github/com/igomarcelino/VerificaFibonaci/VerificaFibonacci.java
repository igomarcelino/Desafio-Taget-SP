package github.com.igomarcelino.VerificaFibonaci;

import java.util.Scanner;

public class VerificaFibonacci {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe um numero para verificar se ele pertence a sequencia Fibonacci: ");
        String possivelFibonacci = fibonacci(teclado.nextInt());
        teclado.close();
        System.out.println(possivelFibonacci);
    }

    public static String fibonacci(int numero){
        /**
         * //TODO
         *      Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo
         *      valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...),
         *      escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de
         *      Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
         * */

        int a = 0;
        int b = 1;
        boolean numeroFibo = false;
        // Esse for nao fornece a sequencia de fibonacci completa , mas mostra quais numeros estao presentes nessa sequencia
        for(int i = 0; i <= numero; i=b){
            i = a+b;
            a = b;
            b = i;
            if(b == numero || numero == 0){
                numeroFibo = true;
                break;
            }
        }
        return numeroFibo == true ? "\nO numero " + numero + " pertence a sequencia fibonacci" : "\nO numero " + numero + " nao pertence a sequencia fibonacci" ;
    }
}
