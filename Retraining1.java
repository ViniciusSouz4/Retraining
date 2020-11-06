/*

* Retraining1

* [ Funcionalidade ]

* Este programa lê dois inteiros de entrada,

calcula a soma entre os dois valores

e apresenta o resultado na tela.

*/

  

import java.util.Scanner;

class Dcoder

{

  public static void main (String [] args)

  {

    int num1, num2;

    Scanner leitor = new Scanner(System.in);

    

    // [ Receber os valores de entrada ]

    System.out.println("Digite o primeiro valor: ");

    num1 = leitor.nextInt();

    System.out.println("Digite o segundo valor: ");

    num2 = leitor.nextInt();

    

    // Somar os valores de entrada e mostrar o resultado:

    System.out.println("Resultado: "+(num1+num2));

  }

}
