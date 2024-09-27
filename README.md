# Estágio - São Paulo


Técnica:

- Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
  Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
  Imprimir(SOMA);
  Ao final do processamento, qual será o valor da variável SOMA?

&nbsp;
Resposta: 90

Abaixo segue a resposta detalhada
```
        int INDICE = 13, SOMA = 0, K = 1;
    enquanto K < INDICE faça { 
        K = K + 1; 
        SOMA = SOMA + K; 
        
    }
    imprimir(SOMA);
    
    sendo assim 
    passo 1 k = 1 e indice = 13 (  1 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(1+1 = 2) e soma(0+2 = 2)
    passo 2 k = 2 e indice = 13 (  2 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(2+1 = 3) e soma(2+3 = 5)
    passo 3 k = 3 e indice = 13 (  3 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(3+1 = 4) e soma(5+4 = 9)
    passo 4 k = 4 e indice = 13 (  4 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(4+1 = 5) e soma(9+5 = 14)
    passo 5 k = 5 e indice = 13 (  5 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(5+1 = 6) e soma(14+6 = 20)
    passo 6 k = 6 e indice = 13 (  6 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(6+1 = 7) e soma(20+7 = 27)
    passo 7 k = 7 e indice = 13 (  7 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(7+1 = 8) e soma(27+8 = 35)
    passo 8 k = 8 e indice = 13 (  8 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(8+1 = 9) e soma(35+9 = 44)
    passo 9 k = 9 e indice = 13 (  9 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(9+1 = 10) e soma(44+10 = 54)
    passo 10 k = 10 e indice = 12 ( 10 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(10+1 = 11) e soma(54+11 = 65)
    passo 11 k = 11 e indice = 12 ( 11 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(11+1 = 12) e soma(65+12 = 77)
    passo 12 k = 12 e indice = 12 ( 12 < 13 = VERDADEIRO) k = k +1 e soma = soma + k = k(12+1 = 13) e soma(77+13 = 90)
    passo 13 k = 13 e indice = 13 ( 13 < 13 = FALSO ) ultimo valor atribuido a soma = 90 ;
     
```


##

2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;

Resposta: [Link do programga]()
##

3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
   • O menor valor de faturamento ocorrido em um dia do mês;
   • O maior valor de faturamento ocorrido em um dia do mês;
   • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;

&nbsp;

Resposta: [link do programa]()

##

4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
   •	SP – R$67.836,43
   •	RJ – R$36.678,66
   •	MG – R$29.229,88
   •	ES – R$27.165,48
   •	Outros – R$19.849,53

Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.  

&nbsp;

Resposta: [Link do programa]()
 5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;

NÃO SE ESQUEÇA DE INSERIR O LINK DO SEU REPOSITÓRIO NO GITHUB COM O CÓDIGO FONTE QUE VOCÊ DESENVOLVEU

&nbsp;

Resposta [Link do programa]()