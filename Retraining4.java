/*
* Retraining4

* [ Funcionalidade ]
* Este programa recebe uma cadeia de caracteres como entrada,
extrai a expressão aritmética da cadeia de caracteres
e apresenta o resultado da expressão na tela.

* Caracteres permitidos na expressão aritmética:
  + - * / ( )
*/

import java.util.Scanner;

class Dcoder
{
  
  /**
   * Calcula o resultado de uma operação básica.
   * @param num1: Primeiro operando.
   * @param num2: Segundo operando.
   * @param operador: String contendo a operação que será realizada.
   * @return resultado: Resultado da operação.
   */
  public static double realizarOperacao(String num1, String operador, String num2)
  {
    double resultado = 0.0;
    double numero1 = Double.parseDouble(num1);
    double numero2 = Double.parseDouble(num2);
    
    if(operador.equals("+"))
    {
      resultado = numero1 + numero2;
    }
    else if(operador.equals("-"))
    {
      resultado = numero1 - numero2;
    }
    else if(operador.equals("*"))
    {
      resultado = numero1 * numero2;
    }
    else if(operador.equals("/"))
    {
      resultado = numero1 / numero2;
    }
    else if(operador.equals("(") || operador.equals(")"))
    {
      resultado = numero1 * numero2;
    }
    else
    {
      // TODO: Erro!
      System.out.println("EXPRESSÃO INVÁLIDA!");
      System.out.println("Motivo: Caractere inválido encontrado!");
      System.out.println("Caractere inválido: "+operador);
      System.exit(0);
    }
    
    return resultado;
  }
  
  /**
   * Dado um operador em forma de string, retornar a prioridade dele no programa.
   * @param str: operador.
   * @return prioridade: prioridade do operador no programa.
   */
  public static int prioridadeOperador(String str)
  {
    int prioridade = 0;
    
    if(str.equals("+") || str.equals("-"))
    {
      prioridade = 1;
    }
    else if(str.equals("*") || str.equals("/"))
    {
      prioridade = 2;
    }
    
    return prioridade;
  }
  
  public static boolean isNumero(String str)
  {
    boolean resp = true;
    
    try
    {
      double temp = Double.parseDouble(str);
      return true;
    }
    catch(NumberFormatException nfe)
    {
      return false;
    }
  }
  
  /**
   * Avalia uma expressão aritmética.
   * @param expressao: A expressao que será avaliada.
   * @return resultado: O resultado da expressao avaliada.
   */
  public static double avaliarExpressao(String expressao)
  {
    double resultado = 0.0;
    String elementos [] = new String [expressao.length()];
    int numElementos = 0;
    int naoDigitos = 0;
    
    // [ OK: Separar operandos de operadores ]
    // Necessário "varrer" a String toda: O(n).
    for(int i = 0; i < expressao.length(); i++)
    {
      int c_inic = i;
      int c_final = i+1;
      
      if(Character.isDigit(expressao.charAt(i)))
      {
        i++;
        while(i < expressao.length() && (Character.isDigit(expressao.charAt(i))))
        {
          i++;
        }
        c_final = i;
        i--;
      }
      else
      {
        naoDigitos++;
      }
      
      elementos[numElementos] = expressao.substring(c_inic, c_final);
      numElementos++;
      //System.out.println("Obtido: "+ expressao.substring(c_inic, c_final));
    }
    //System.out.println("NumElementos: "+numElementos);
    /* Verificar se os elementos obtidos estão corretos:
    for(int i = 0; i < numElementos; i++)
    {
      System.out.format("Pos %d: %s\n", i, elementos[i]);
    }
    */
    
    // Enquanto houver operações na expressão:
    int pos_resultado = 0;
    while(naoDigitos > 0)
    {
      // [ OK: Encontrar parênteses mais internos da expressão ]
      // Considerar inicialmente que toda expressão está contida entre parênteses.
      // Ex: 1+2 -> (1+2)
      int p_inic = -1;
      int p_final = numElementos;
    
      for(int pos = 0; pos < numElementos; pos++)
      {
        if(elementos[pos].equals("("))
        {
          p_inic = pos;
        }
        else if(elementos[pos].equals(")"))
        {
          // Encontrou os parênteses mais internos
          p_final = pos;
          pos = numElementos; // Sair do loop.
        }
      }
      
      //System.out.println("Parenteses_inic(pos): "+ p_inic);
      //System.out.println("Parenteses_final(pos): "+ p_final);
      //naoDigitos = 0;
      
      if(p_inic >= 0 && p_final == numElementos
      || p_inic < 0 && p_final < numElementos)
      {
        // TODO: Erro!
        System.out.println("EXPRESSÃO INVÁLIDA!");
        System.out.println("Motivo: Faltou um parêntese na expressão!");
        System.exit(0);
      }
      if(numElementos == 3 && p_inic == 0)
      {
        pos_resultado = 1;
      }
      
      // Prioridade:
      // 0: nenhum operador
      // 1: + ou -
      // 2: * ou /
      boolean temOperador = true;
      int pos_operador = 0;
      while(temOperador) // Dentro dos parênteses:
      {
        pos_operador = 0;
        int prioridade = 0;
        int op_esq = -1;
        int op_dir = -1;
        
        // [ Encontrar o primeiro operador de maior prioridade dentro dos parenteses ]
        // Se não houverem parênteses na expressão, considerar que ela inteira está dentro de parênteses.
        for(int pos = p_inic+1; pos < p_final; pos++)
        {
          int prioridadeTemp = prioridadeOperador(elementos[pos]);
          if(prioridadeTemp > prioridade)
          {
            prioridade = prioridadeTemp;
            pos_operador = pos;
          }
        }
        
        //System.out.println("Operador: "+elementos[pos_operador]);
        //System.out.println("Prioridade: "+prioridade);
        //temOperador = false;
        
        // Se foi encontrado ao menos um operador:
        if(prioridade > 0)
        {
          //System.out.println("Prioridade > 0");
          // [ Encontrar operandos ]
          for(int esq = pos_operador-1; esq > p_inic; esq--)
          {
            if(isNumero(elementos[esq]))
            {
              op_esq = esq;
              esq = p_inic; // Sair do loop.
            }
            else if(!(elementos[esq].equals("_")))
            {
              // TODO: Erro!
              System.out.println("EXPRESSÃO INVÁLIDA!");
              System.out.println("Motivo: Erro na expressão!");
              System.out.println("Erro encontrado na posição "+esq);
              System.out.println("-Caractere encontrado: "+elementos[esq]);
              System.exit(0);
            }
          }
          for(int dir = pos_operador+1; dir < p_final; dir++)
          {
            if(isNumero(elementos[dir]))
            {
              op_dir = dir;
              dir = p_final; // Sair do loop.
            }
            else if(!(elementos[dir].equals("_")))
            {
              // TODO: Erro!
              System.out.println("EXPRESSÃO INVÁLIDA!");
              System.out.println("Motivo: Erro na expressão!");
              System.out.println("Erro encontrado na posição "+dir);
              System.out.println("-Caractere encontrado: "+elementos[dir]);
              System.exit(0);
            }
          }
          
          // [ Realizar a operação ]
          if(op_esq >= 0 && op_dir >= 0)
          {
            //System.out.println("Operando_esq: "+elementos[op_esq]);
            //System.out.println("Operando_dir: "+elementos[op_dir]);
            
            //*/
            String esq_temp = elementos[op_esq];
            String dir_temp = elementos[op_dir];
            String op_temp = elementos[pos_operador];
            double result_parcial = realizarOperacao(esq_temp, op_temp, dir_temp);
            
            // [ Mudanças nos dados ]
            // O resultado da operação é armazenado na posição no operador.
            elementos[op_dir] = "_";
            elementos[op_esq] = "_";
            elementos[pos_operador] = ""+result_parcial;
            naoDigitos--;
            pos_resultado = pos_operador;
            //*/
          }
          else
          {
             // TODO: Erro!
             System.out.println("EXPRESSÃO INVÁLIDA!");
             System.out.println("Motivos possíveis: ");
             System.out.println("-Apenas um operando encontrado dentro de parênteses.");
             System.out.println("-Tentativa de expressar que um número é positivo ou negativo pelo sinal de + ou -.");
             System.out.println("-Parênteses vazios.");
             System.exit(0);
          }
          
        }
        else
        {
          // Se não foi encontrado operador algum:
          //System.out.println("Prioridade <= 0");
          temOperador = false;
        }
        
      }//endWhileTemOperador
      ///*
      // [ Retirada de parênteses ]
      // [ Testar se existe algum valor antes ou depois dos parênteses ]
      if(p_inic >= 0 && p_final < numElementos)
      {
        
        if((p_inic > 0) && (isNumero(elementos[p_inic-1]) || elementos[p_inic-1].equals(")")))
        {
          //double temp = realizarOperacao(elementos[p_inic-1], elementos[p_inic] , elementos[pos_resultado]);
          elementos[p_inic] = "*";
        }
        else
        {
          elementos[p_inic] = "_";
          naoDigitos--;
        }
        
        if((p_final < numElementos-1) && (isNumero(elementos[p_final+1]) || elementos[p_final+1].equals("(")))
        {
          //double temp = realizarOperacao(elementos[pos_resultado], elementos[p_final], elementos[p_final+1]);
          elementos[p_final] = "*";
        }
        else
        {
          elementos[p_final] = "_";
          naoDigitos--;
        }
      }
      //*/
    }//endWhileNaoDigitos>0

    resultado = Double.parseDouble(elementos[pos_resultado]);
    //String resFinal = elementos[0];
    //resultado = Double.parseDouble(resFinal);
    return resultado;
  }
  
  /**
   * Main: Lê uma expressão aritmética do teclado,
   * e imprime o resultado da mesma na tela.
   */
  public static void main(String [] args)
  {
    String texto;
    Scanner leitor = new Scanner(System.in);
    
    // [ Receber cadeia de caracteres ]
    System.out.println("Digite uma expressão aritmética:");
    texto = leitor.nextLine();
    // Remover espacos em branco da cadeia de caracteres:
    texto = texto.replace(" ", "");
    
    // Obter o resultado da expressao:
    double resultado = avaliarExpressao(texto);
    
    // Imprimir o resultado da operação aritmética:
    System.out.println("Resultado: "+resultado);
  }
}

/* Exemplos de expressoes aritmeticas:
(1+(5*6+8*5-(6/2)))+2
(1+(30+40-3))+2
(1+(67))+2
68+2
70

3*(4+7/5)+6
3*(4+1.4)+6
3*(5.4)+6
16.2+6
18.6

[ 12, +, 65, (, 65, *, 8, ), +, 7 ] // Expressao inteira
[ 12, +, 65, 520, +, 7 ]
[ 12, +, 33800, +, 7 ]
[ 33812, +, 7 ]
[ 33819 ]

[ 30, +, (, 8, *, 7, +, (, 2, /, 2, ), ) ] // Expressão inteira
// Se quantidade entre parenteses < 3: Erro.
// Se for igual a 3: Realizar a operação sem testes.
[ 30, +, (, 8, *, 7, +, 1, ) ]
[ 30, +, (, 56, +, 1, ) ]
[ 30, +, 57 ]
[ 87 ]

[ 30, +, (, 8, *, 7, +, (, 2, /, 2, ), ) ]
[ 30, +, (, _, 40, _, +, (, _, 1, _, ), ) ]
// Testar se antes ou depois dos parênteses há algum valor para multiplicar.
[ 30, +, (, _, 40, _, +, _, _, 1, _, _, ) ]
// Conferir a quantidade de operadores dentro dos parenteses.
[ 30, +, (, _, _, _, 41, _, _, _, _, _, ) ]
// Testar novamente se não há alguma valor antes ou depois dos parenteses.
[ 30, +, _, _, _, _, 41, _, _, _, _, _, _ ]
[ _, 71, _, _, _, _, _, _, _, _, _, _, _ ]
// Se não há mais operadores, mostrar resultado:
Resultado = 71.


Algoritmo:
1) Encontrar os parenteses mais internos da expressão.
2) Avaliar a sub-expressao contida dentro dos parenteses.
2-1) Faça:
2-2) Achando operandos e operações dentro de parênteses:
- Delimitar a área de busca com base nas posições dos parênteses.
- Encontrar a operação de maior prioridade.
-- Se houver mais de uma, escolher a mais à esquerda.
- Encontrar os operandos da operação.
-- Obter o primeiro valor à esquerda e o primeiro valor à direita,
-- que seja diferente de "_".

2-3) Calculo e resultado:
- Chamar função para calcular o operação binária.
- Armazenar resultado na posição do operador.
- Substituir os operandos por "_" no arranjo de Strings.

2-4) Se houver mais operadores dentro dos parenteses:
- Volte para 2-1.

3) Verificar se antes ou depois (1 posição) de cada parêntese há algum valor.
- Se houver, substituir o parêntese por um sinal de multiplicação.
- Caso contrario, substituir o parêntese por "_".

4) Se houver mais operadores na expressão:
- Volte para 1.

*/
    
