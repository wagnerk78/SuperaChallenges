package desafioResistores;

import java.util.Scanner;

public class ValidacaoResistores {

    public static void main(String[] args) {
        Scanner valorDoResistor = new Scanner(System.in);
        String valor;

        while (true) {
            System.out.println("Digite um valor na forma X ohms, onde X representa um número da forma como nos exemplos: 47 ohms ou 4.7k ohms ou 4.7M ohms; ou digite 'fim' para sair:");
            valor = valorDoResistor.nextLine().trim();

            if (valor.equalsIgnoreCase("fim")) {
                System.out.println("Saindo...");
                break;
            }

            if (valor.matches("\\d+\\s*ohms")) {
                String numeros = valor.replaceAll("\\s*ohms\\s*", "");

                if (numeros.length() < 3) {
                    printCores(numeros, "preto");
                }
                if (numeros.length() == 3) {
                    printCores(numeros, "marrom");
                }

            } else if (valor.matches("\\d+(\\.\\d+)?\\s*[k]?\\s*ohms")) {
                String numeros = valor.replaceAll("\\s*[k]?\\s*ohms\\s*", "");
                double resultado = Double.parseDouble(numeros) * 1000;

                if (resultado >= 1000 && resultado < 10000) {
                    printCores(String.valueOf((int) resultado), "vermelho");
                }
                if (resultado >= 10000 && resultado < 100000) {
                    printCores(String.valueOf((int) resultado), "laranja");
                }
                if (resultado >= 100000 && resultado < 1000000) {
                    printCores(String.valueOf((int) resultado), "amarelo");
                }

            } else if (valor.matches("\\d+(\\.\\d+)?\\s*[M]?\\s*ohms")) {
                String numeros = valor.replaceAll("\\s*[M]?\\s*ohms\\s*", "");
                double resultado = Double.parseDouble(numeros) * 1000000;

                if (resultado >= 1000000 && resultado < 10000000) {
                    printCores(String.valueOf((int) resultado), "verde");
                }
                if (resultado >= 10000000 && resultado < 100000000) {
                    printCores(String.valueOf((int) resultado), "azul");
                }
                if (resultado >= 100000000 && resultado < 1000000000) {
                    printCores(String.valueOf((int) resultado), "violeta");
                }

            } else {
                System.out.println("O valor digitado deve estar na forma X ohms, onde X representa um número da forma como nos exemplos: 47 ohms ou 4.7k ohms ou 4.7M ohms.");
            }
        }

        valorDoResistor.close();
    }

    private static void printCores(String resultadoStr, String faixaCor) {
        int digito1 = Character.getNumericValue(resultadoStr.charAt(0));
        int digito2 = Character.getNumericValue(resultadoStr.charAt(1));
        System.out.println(CoresResistores.fromValor(digito1).getCor() + " " +
                CoresResistores.fromValor(digito2).getCor() + " " + faixaCor + " " + "dourado");
    }
}
