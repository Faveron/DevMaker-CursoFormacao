package docencia;

import java.util.ArrayList;
import java.util.UUID;

public class Aluno extends Pessoa {

    private String numeroMatricula;

    private String curso;

    public ArrayList<String> atividades = new ArrayList<>();

    // Método contrutor
    // Não precisa declarar retorno. Deve possuir o mesmo nome que a classe
    public Aluno(String nome, String curso) {
        this(nome);
        matricular(curso);
    }

    public Aluno(String nome) {
        super(nome);
        this.numeroMatricula = UUID.randomUUID().toString();
    }

    public String getNumeroMatricula() {
        return this.numeroMatricula;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void matricular(String curso) {
        this.curso = curso;
    }

    public void assistirAula(String disciplina) {
        System.out.println("O aluno " + getNome() + " assistiu a aula de " +
                disciplina + " no curso de " + curso);
        darAtencaoAula();
    }

    protected void darAtencaoAula() {
        System.out.println("Muito focado aqui");
    }

    public void receberAtividade(String disciplina, String atividade) {
        realizarAtividade(disciplina, atividade);
    }

    protected void realizarAtividade(String displina, String atividade) {
        System.out.println("O aluno " + getNome() + " realizou a atividade " +
                atividade + " na disciplina " + displina + " no curso " + curso);
    }

}
