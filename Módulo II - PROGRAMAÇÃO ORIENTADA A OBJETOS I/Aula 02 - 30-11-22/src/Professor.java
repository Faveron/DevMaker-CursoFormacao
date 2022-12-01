import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Professor {
    String nome;
    String matricula;
    Double valorHoraAula;
    ArrayList<String> disciplinas = new ArrayList<>();
    ArrayList<String> turmas = new ArrayList<>();

    public static Professor contratar(String nome, Double valorHoraAula) {
        Professor professor = new Professor();
        professor.nome = nome;
        professor.matricula = UUID.randomUUID().toString();
        professor.valorHoraAula = valorHoraAula;
        return professor;
    }

    public void ministrarAula(String turma, String disciplina) {
        System.out.println("O professor " + nome + " ministrou a aula de " +
                disciplina + " na turma " + turma);
    }

    public void corrirgirAtividade(String turma, String disciplina, String atividade) {
        System.out.println("O professor " + nome + " corrigiu o atividade " +
                atividade + " da turma " + turma + " e disciplina " + disciplina);
    }
}