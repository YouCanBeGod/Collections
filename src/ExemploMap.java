import java.util.*;

public class ExemploMap {
    //Dados os modelos dos carros e seus consumos, faça:
    //Gol - 14,4km/l
    //Uno - 15,6m/l
    //Mobi - 16,1km/l
    //Hb20 - 14,5km/l
    //Kwid - 15,6km/l

    public static void main(String[] args) {

        System.out.println("Crie um dicionário e relacione os modelos e seus consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("Substituia o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2); //neste caso não adiciona, apenas se altera por já exisitir a key
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do Uno: " + carrosPopulares.get("uno"));

//        System.out.println("Exiba o terceiro modelo adicionado:"); //assim como no set, não se possui indice

        System.out.println("Exiba os modelos: ");
        Set<String> modelo = carrosPopulares.keySet();
        System.out.println(modelo);

        System.out.println("Exiba o consumo dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais eficiente: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println(modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }

        System.out.println("Exiba o modelos menos economico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println(modeloMenosEficiente + "--" + consumoMenosEficiente);
            }
        }

        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("Exiba a média dos consumos deste dicionário: " + soma/carrosPopulares.size());

        System.out.println("Remova os modelos com consumo igual a 16,6 km/l: ");
        Iterator<Double> iterator2 = carrosPopulares.values().iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next().equals(15.6)) iterator2.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("\nExiba todos os carros na ordem em que foram informados: "); //neessário mudar a implementaçao para LinkedHashMap
        Map<String, Double> carrosPopulares2 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares2);

        System.out.println("\nExiba o dicionário ordenado pelo modelo: "); //necessário implementar treeMap
        Map<String, Double> carrosPopulares3 = new TreeMap<>(carrosPopulares2);
        System.out.println(carrosPopulares3);

        System.out.println("\nApague o dicionário de carros:");
        carrosPopulares3.clear();

        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares3.isEmpty());
        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares2.isEmpty());
        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());

    }

}
