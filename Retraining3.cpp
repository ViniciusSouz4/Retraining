/*

* Retraining3

* [ Funcionalidade ]

* Este programa recebe uma cadeia de caracteres como entrada,

conta a quantidade de vogais da cadeia de caracteres,

e apresenta a quantidade total de vogais na tela.

*/

#include <iostream>

#include <cctype>

#include <string>

using namespace std;

  /**

   * Testa se um caractere é uma vogal.

   */

  bool isVowel(char c)

  {

    bool verify = false;

    

    c = toupper(c);

    

    if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')

    {

      verify = true;

    }

    

    return verify;

  }

int main()

{

  string texto;

  int numVogais = 0;

  

  // [ Receber cadeia de caracteres ]

  cout << "Digite uma cadeia de caracteres:" << endl;

  cin >> texto;

    

  // [ Contar quantidade de vogais na cadeia de caracteres ]

  for(int i = 0; i < texto.length(); i++)

  {

    if(isVowel(texto[i]))

    {

      numVogais++;

    }

  }

  

  // Imprimir a quantidade de vogais na tela:

  cout << "Quantidade de vogais: " << numVogais << endl;

  

  return 0;

}
