/*

* Retraining3

* [ Funcionalidade ]

* Este programa recebe uma cadeia de caracteres como entrada,

conta a quantidade de vogais da cadeia de caracteres,

e apresenta a quantidade total de vogais na tela.

*/

import java.util.Scanner;

class Dcoder

{

  /**

   * Testa se um caractere é uma vogal.

   */

  public static boolean isVowel(char c)

  {

    boolean verify = false;

    

    c = Character.toUpperCase(c);

    

    if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')

    {

      verify = true;

    }

    

    return verify;

  }

  

  public static void main(String [] args)

  {

    String texto;

    int numVogais = 0;

    Scanner leitor = new Scanner(System.in);

    

    // [ Receber cadeia de caracteres ]

    System.out.println("Digite uma cadeia de caracteres:");

    texto = leitor.nextLine();

    

    // [ Contar quantidade de vogais na cadeia de caracteres ]

    for(int i = 0; i < texto.length(); i++)

    {

      if(isVowel(texto.charAt(i)))

      {

        numVogais++;

      }

    }

    

    // Imprimir a quantidade de vogais na tela:

    System.out.println("Quantidade de vogais: "+numVogais);

  }

}
