package Java8.src.br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import gerenciadorDeCursos.src.br.com.alura.Aluno;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
        // cursos.forEach(c -> System.out.println(c.getNome()));

        int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
        System.out.println(sum);
        //.forEach(System.out::println); 
        //.forEach(c -> System.out.println(c.getNome())); - Maneira para achar cursos com mais de 100 alunos

        // OptionalDouble media = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).average();
        
        // Optional<Curso> optinalCurso = 
        cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();

        //Pega o primeiro
        cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();

        //Calculando a media
        cursos.stream().mapToInt(c -> c.getAlunos()).average();

        cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos())).forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

        //Transformando em List
        List<Curso> cursosFiltrados = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());
        
        // Curso curso = optinalCurso.orElse(null);
        // System.out.println(curso.getNome());

        // optinalCurso.ifPresent(c -> System.out.println(c.getNome()));
    }
}