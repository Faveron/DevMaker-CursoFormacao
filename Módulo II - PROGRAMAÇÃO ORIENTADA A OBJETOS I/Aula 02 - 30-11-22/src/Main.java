public class Main {
    public static void main(String[] args) {
        Aluno wesley = Aluno.matricular("Wesley", "POO-1");
        wesley.assistirAula("POO-1");
        wesley.realizarAtividade("POO-1", "Trabalho 01");
        Aluno wes = new Aluno();
        Aluno fav = new Aluno("Faveron", "Math");

        Professor william = Professor.contratar("William", 1.0);
        william.ministrarAula("Dev_makers_2", "POO-1");
        william.corrirgirAtividade("Dev_makers_2", "POO-1", "Trabalho-1");
    }
}
