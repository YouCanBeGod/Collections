import java.util.*;

public class ExemploList {
    public static void main(String[] args) {

        System.out.println("Crie uma lista e adicione 7 notas: ");
        List<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        System.out.println(notas);

        System.out.println("\nExiba a posição da nota 5.0: " + notas.indexOf(5d));

        System.out.println("\nAdicione na lista a nota 8.0 na posiçã 4: ");
        notas.add(4, 8.0);
        System.out.println(notas);

        System.out.println("\nSubstitua a nota 5.0 pela nota 6.0");
        notas.set(notas.indexOf(5d), 6.0);
        System.out.println(notas);

        System.out.println("\nConfira se a nota 5.0 está na lista: " + notas.contains(5.0));

//        System.out.println("\nExiba todas as notas na ordem em que foram adicionadas: ");
//        for (Double nota : notas)
//            System.out.println(nota);

        System.out.println("\nExiba a terceira nota adiconada: " + notas.get(2));
        System.out.println("\nExiba a menor nota: " + Collections.min(notas));
        System.out.println("\nExiba a maior nota: " + Collections.max(notas));

        System.out.println("\nExiba a soma dos valores: ");
        Iterator<Double> interator = notas.iterator();
        Double soma = 0d;
        while (interator.hasNext()) {
            Double next = interator.next();
            soma += next;
        }
        System.out.println(soma);

        System.out.println("\nExiba a média das notas: " + (soma/notas.size()));


        System.out.println("\nRemova a nota 0.0: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("\nRemova a nota da posição 0: ");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("\nRemova as notas menores que 7.0 e exiba a lista: ");
        Iterator<Double> interator2 = notas.iterator();
        while (interator2.hasNext()) {
            Double next = interator2.next();
            if (next < 7) interator2.remove();
        }
        System.out.println(notas);

        System.out.println("\nApague toda a lista: ");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());

    }
}
