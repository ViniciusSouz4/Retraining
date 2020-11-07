/*

* Retraining3

* [ Funcionalidade ]

* Este programa recebe uma cadeia de caracteres como entrada,

conta a quantidade de vogais da cadeia de caracteres,

e apresenta a quantidade total de vogais na tela.

*/

#include <stdio.h>

#include <ctype.h>

/**

 * Testa se um caractere é uma vogal. 

 */

char isVowel(char c)

{

  char verify = 'F';

       

  c = toupper(c);

    

  if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')

  {

    verify = 'V';

  }

  //printf("Char: %c\n", c);

  

  return verify;

}

  

int main()

{

  char texto [50];

  int numVogais = 0;

  

  // [ Receber cadeia de caracteres ]

  printf("Digite uma cadeia de caracteres:\n");

  scanf("%[^\n]s", texto);

  // printf("%s\n", texto);

  

  // [ Contar quantidade de vogais na cadeia de caracteres ]

  for(int i = 0; i < sizeof(texto); i++)

  {

    if(texto[i] == '\0')

    {

      break;

    }

    else if(isVowel(texto[i]) == 'V')

    {

      numVogais++;

    }

  }

  

  // Imprimir a quantidade de vogais na tela:

  printf("Quantidade de vogais: %d", numVogais);

  

  return 0;

}
