package desafioSnail;

import java.util.Scanner;

public class RetornoMatriz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a ordem da matriz (ex: para 3x3 digite 3): ");
        int ordem = scanner.nextInt();

        int[][] matriz = new int[ordem][ordem];

        for (int i = 0; i < ordem; i++) {
            System.out.println("Digite os elementos da " + (i + 1) + "ª linha separados por espaço:");
            for (int j = 0; j < ordem; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        imprimeSnail(matriz);
    }

    public static void imprimeSnail(int[][] matriz) {
        int ordem = matriz.length;
        int cima = 0, baixo = ordem - 1, esquerda = 0, direita = ordem - 1;

        while (cima <= baixo && esquerda <= direita) {
            for (int j = esquerda; j <= direita; j++) {
                System.out.print(matriz[cima][j] + ", ");
            }
            cima++;

            for (int i = cima; i <= baixo; i++) {
                System.out.print(matriz[i][direita] + ", ");
            }
            direita--;

            if (cima <= baixo) {
                for (int j = direita; j >= esquerda; j--) {
                    System.out.print(matriz[baixo][j] + ", ");
                }
                baixo--;
            }

            if (esquerda <= direita) {
                for (int i = baixo; i >= cima; i--) {
                    System.out.print(matriz[i][esquerda] + ", ");
                }
                esquerda++;
            }
        }
    }
}
