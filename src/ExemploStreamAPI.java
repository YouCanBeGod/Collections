import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStreamAPI {

    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elemento dessa lista de String: ");
        //Com reference method **melhor
        numerosAleatorios.stream().forEach(System.out::println);

        //Maneira "Convencional"
//        numerosAleatorios.stream().forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        //Maneira com lambda
//        numerosAleatorios.forEach(s -> System.out.println(s));

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um set: ");
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("Transforme essa lista de Strings em uma lista de número inteiros: ");
        //Reference Method
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Colocando em uma variavel
        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //"Convencional"
//        numerosAleatorios.stream().map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.parseInt(s);
//            }
//        });

        //lambda
//        numerosAleatorios.stream().map(s -> Integer.parseInt(s));

        System.out.println("Pegue os números pares, maiores que 2 e coloque em uma lista: ");
        //Usando variável criada anteriormente
        collectList.stream().filter(i -> i % 2 == 0 && i > 2).forEach(System.out::println);

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println); //apenas para não retornar anda no caso de dar erro ao fazer a média

        System.out.println("Remova os valores ímpares: ");
        //Usando variável já criada anteriorimente
        collectList.removeIf(i -> i % 2 != 0);
        System.out.println(collectList);

    }
}
