import java.util.ArrayList;
import java.util.UUID;

public class Aluno {

    String nome;
    String numeroMatricula;
    String curso;
    ArrayList<String> atividades = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public static Aluno matricular(String nome, String curso) {
        Aluno aluno = new Aluno(nome, curso);
        aluno.numeroMatricula = UUID.randomUUID().toString();
        return aluno;
    }

    public void assistirAula(String disciplina) {
        System.out.println("O aluno " + nome + " assistiu a aula de " +
                disciplina + " no curso de " + curso);
    }

    public void realizarAtividade(String displina, String atividade) {
        System.out.println("O aluno " + nome + " realizou a atividade " +
                atividade + " na disciplina " + displina + " no curso " + curso);
    }
}