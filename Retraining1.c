/*

* Retraining1

* [ Funcionalidade ]

* Este programa lê dois inteiros de entrada,

calcula a soma entre os dois valores

e apresenta o resultado na tela.

*/

#include <stdio.h>

int main()

{

  int num1, num2;

  

  // [ Receber os valores de entrada ]

  printf("Digite o primeiro valor:\n");

  scanf("%d", &num1);

  printf("Digite o segundo valor:\n");

  scanf("%d", &num2);

  

  // Somar os valores de entrada e mostrar o resultado:

  printf("Resultado: %d\n", num1+num2);

  

  return 0;

}
