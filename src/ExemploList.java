import java.util.ArrayList;
import java.util.List;

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
    }
}
