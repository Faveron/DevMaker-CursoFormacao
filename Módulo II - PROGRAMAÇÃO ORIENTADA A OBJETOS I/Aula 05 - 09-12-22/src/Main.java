import docencia.Aluno;
import docencia.AlunoPCD;
import docencia.Pessoa;
import docencia.Professor;
import veiculo.Veiculo;
import veiculo.automotor.carro.HB20;
import veiculo.automotor.carro.VwGol;
import veiculo.automotor.motocicleta.Motoquinha;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Consigo chamar o montar na classe, pois o método é desse contexto,
        // mas não consigo chamar o ligar, pois é do objeto
        VwGol golDoDiego = new VwGol(2022, "Preto", 5);
        System.out.println("A cor do gol do Diego é: " + golDoDiego.getCor());
        golDoDiego.setCor("Azul");
        System.out.println("A cor do gol do Diego é: " + golDoDiego.getCor());

        VwGol golDoVitor = new VwGol(2021, "Branca", 3, true);
        golDoVitor.setCor("Preto");
        System.out.println(golDoVitor.getAnoFabricacao());

        VwGol veiculoDoLucas = new VwGol(2022, "Verde", 3, true);
        veiculoDoLucas.desligar();

        HB20 b20DoPssor = new HB20(2022, "Preto", 5, true);
        System.out.println("B20tão do pssor esta ligado: " + b20DoPssor.getLigado());

        // Consigo chamar o ligar, pois o método é desse contexto.
        // Não consigo chamar o montar, pois é do contexto d class
        golDoDiego.ligar();
        System.out.println("Gol do Diego ligado");

        Aluno richard = new Aluno("Richard", "Dev_makers_2");
        richard.assistirAula("POO-1");

        Aluno arthur = new Aluno("Arthur", "Dev_makers_2");
        arthur.assistirAula("Banco de dados");

        Aluno diego = new Aluno("Diego", "Dev_makers_2");
        diego.assistirAula("POO-1");
        diego.receberAtividade("POO-1", "Trabalho-1");

//        Aluno cadastrado = cadastrarAluno();
//        System.out.println("Foi cadastrado o aluno: " + cadastrado.getNome());

        ArrayList<String> disciplinas = new ArrayList<>();
        disciplinas.add("POO-1");

        Professor william = new Professor("William", disciplinas);
        william.ministrarAula("Dev_makers_2", "POO-1");
        william.corrirgirAtividade("Dev_makers_2", "POO-1", "Trabalho-1");
        william.comprarCarro(b20DoPssor);

        Motoquinha motoca = new Motoquinha(2022, "Verde");
        motoca.mover(50);

        disciplinas.add("Banco de dados");
        Professor thomas = new Professor("Thomas", disciplinas);

        System.out.println("As disciplinas trabalhadas pelo William são: " + william.disciplinas);
        System.out.println("As disciplinas trabalhadas pelo Thomas são: " + thomas.disciplinas);

        // método representam as ações possíveis de um objeto
        // atributos representam as propriedades dos objetos
    }

    /*
    Visibilidades
    publica (public) - Visível a todos sem distinção. Menos restritiva
    privada (private) - Visível apenas a quem esta na mesma class. Mais restritiva
    protegida (protected) - Visível a quem esta na mesma classe, quem herda e quem esta no mesmo pacote.
    pacote (package) (default) - Visível a quem esta na mesma classe e no mesmo pacote, mas não a quem herda.
     */

    public static Aluno cadastrarAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome:");
        String nome = scanner.nextLine();
        System.out.println("O aluno tem alguma deficiência? (s/n)");
        String deficiencia = scanner.nextLine();
        if (deficiencia.equalsIgnoreCase("s")) {
            System.out.println("Informe qual a deficiência:");
            deficiencia = scanner.nextLine();
            AlunoPCD alunoPCD = new AlunoPCD(nome, "POO-1");
            alunoPCD.setDeficiencia(deficiencia);
            return alunoPCD;
        } else {
            return new Aluno(nome, "POO-1");
        }
    }

}
