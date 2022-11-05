import java.util.*;

public class ExemploOrdenacaoSet {

    //Dadas as inforções sobre sérias, crei um conjuntoe ordene exibindo: Nome - Genero -  tempo de Episódio
    //Série 1 - got, fantasia, 60
    //Série 1 - dark, drama, 60
    //Série 1 - that '70s show, comedia, 25

    public static void main(String[] args) {

        System.out.println("-- Ordem Aleatória -- ");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        for (Serie serie : minhasSeries) System.out.println(serie.getNome() + " - "
        + serie.getGenero() + " - " + serie.getTempo());

        System.out.println("\n-- Ordem Inserção -- "); //Deve-se usar LinkedHashSet
        Set<Serie> minhasSeries2 = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        for (Serie serie : minhasSeries2) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempo());

        System.out.println("\n-- Ordem natural (Tempo de Episódio) --"); //Necessário que seja usado Treeset
        Set<Serie> minhasSeries3 = new TreeSet<>(minhasSeries2);
        for (Serie serie : minhasSeries3) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempo());

        System.out.println("\n-- Ordem Nome/Genero/Tempo --");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempo());
        minhasSeries4.addAll(minhasSeries);
        for (Serie serie : minhasSeries4) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempo());

    }
}


class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempo;

    public Serie(String nome, String genero, Integer tempo) {
        this.nome =  nome;
        this.genero = genero;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }
    public String getGenero() {
        return genero;
    }
    public Integer getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return "{" + "nome= " + nome + ", genero= " + genero + ", tempo= " + tempo + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempo.equals(serie.tempo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempo);
    }

    @Override
    public int compareTo (Serie serie) {
        int tempo = Integer.compare(this.getTempo(), serie.getTempo());
        if (tempo != 0) return tempo;
        return this.getGenero().compareTo(serie.getGenero());

    }

}

class ComparatorNomeGeneroTempo implements Comparator<Serie> {
    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempo(), s2.getTempo());
    }
}