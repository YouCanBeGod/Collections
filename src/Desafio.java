import java.util.Scanner;

public class Desafio {

    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);
        int t = leitor.nextInt();

// TODO: Implemente uma condição onde possamos preencher o vetor de N.
// Lembre-se a sequência de valores é de 0 até T-1:
        int[] num = new int[1000];

        for (int i = 0; i < 1000;) {
            for (int j = 0; j < t; j++) {
                if (i != 1000){
                    num[i] = j;
                    System.out.println("N[" + i + "] = " + num[i]);
                    i++;
                }
            }
        }
    }
}

