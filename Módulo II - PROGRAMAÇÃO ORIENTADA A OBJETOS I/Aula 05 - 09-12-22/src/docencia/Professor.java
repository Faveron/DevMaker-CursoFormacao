package docencia;

import veiculo.automotor.VeiculoAutomotor;
import veiculo.automotor.carro.Carro;

import java.util.ArrayList;
import java.util.UUID;

public class Professor extends Pessoa {

    public String matricula;

    public Double valorHoraAula;

    public ArrayList<String> disciplinas;

    public ArrayList<String> turmas = new ArrayList<>();

    public ArrayList<Aluno> alunos = new ArrayList<>();

    public Professor(String nome, ArrayList<String> disciplinas) {
        super(nome);
        this.disciplinas = new ArrayList<>(disciplinas);
        this.matricula = UUID.randomUUID().toString();
    }

    public Professor(String nome, Double valorHoraAula, ArrayList<String> disciplinas) {
        this(nome, disciplinas);
        this.valorHoraAula = valorHoraAula;
    }

    public void ministrarAula(String turma, String disciplina) {
        System.out.println("O professor " + getNome() + " ministrou a aula de " +
                disciplina + " na turma " + turma);
        for (Aluno aluno : this.alunos) {
            //Essa chamada só é possível devido ao aluno esta no mesmo pacote que o professor
            aluno.darAtencaoAula();
        }
    }

    public void corrirgirAtividade(String turma, String disciplina, String atividade) {
        System.out.println("O professor " + getNome() + " corrigiu o atividade " +
                atividade + " da turma " + turma + " e disciplina " + disciplina);
    }

    public void comprarCarro(VeiculoAutomotor veiculo) {
        System.out.println("Parabéns prof. Você comprou o seu carro.");
        veiculo.ligar();
    }

}
