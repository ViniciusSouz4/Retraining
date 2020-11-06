/*

* Retraining2

* [ Funcionalidade ]

* Este programa lê dois valores de ponto flutuante de entrada,

calcula a soma entre os dois valores

e apresenta o resultado na tela.

* O resultado da soma possuindo apenas duas casas decimais.

*/

import java.util.Scanner;

 class Dcoder

 {

   public static void main(String [] args)

   {

     float num1, num2;

     Scanner leitor = new Scanner(System.in);

     

     // [ Receber valores de entrada ]

     System.out.println("Digite o primeiro valor real:");

     num1 = leitor.nextFloat();

     System.out.println("Digite o segundo valor real:");

     num2 = leitor.nextFloat();

     

     // Somar os valores de entrada e mostrar o resultado:

     System.out.format("Resultado: %.2f",(num1+num2));

     

   }

 }

