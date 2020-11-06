/*

* Retraining2

* [ Funcionalidade ]

* Este programa lê dois valores de ponto flutuante de entrada,

calcula a soma entre os dois valores

e apresenta o resultado na tela.

* O resultado da soma possuindo apenas duas casas decimais.

*/

#include <iostream>

using namespace std;

int main()

{

  float num1, num2;

  

  // [ Receber os valores de entrada ]

  cout << "Digite o primeiro valor real:" << endl;

  cin >> num1;

  cout << "Digite o segundo valor real:" << endl;

  cin >> num2;

  

  // Somar os valores de entrada e mostrar o resultado:

  printf("Resultado: %.2f",(num1+num2));

     

  return 0;

}
