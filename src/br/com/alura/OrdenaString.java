package Java8.src.br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaString {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();
        palavras.add("Alura Online");
        palavras.add("One Piece");
        palavras.add("Caelum");

        
        // Collections.sort(palavras, comparador);
        palavras.sort((s1,  s2) -> {
                if (s1.length() < s2.length())
                    return -1;
                if (s1.length() > s2.length())
                    return 1;
                return 0;
            }
        );

        palavras.sort((s1,  s2) -> Integer.compare(s1.length(), s2.length()));
        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));

        Comparator<String> comparador = Comparator.comparing(s -> s.length());
        System.out.println(comparador);

        System.out.println(palavras);

        // for (String p : palavras) {
        // System.out.println(p);
        // }

        Consumer<String> impressor = System.out::println;
        palavras.forEach(impressor);

        palavras.forEach(System.out::println); // Lambda

        palavras.sort(String.CASE_INSENSITIVE_ORDER);
    }

}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        return 0;
    }

}
