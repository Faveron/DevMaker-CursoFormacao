public class Main {

    public static void main(String[] args) {
        //Consigo chamar o montar na classe, pois o método é desse contexto,
        // mas não consigo chamar o ligar, pois é do objeto
        VwGol.montar();

        VwGol golDoDiego = new VwGol();
        golDoDiego.anoFabricao = 2022;
        golDoDiego.cor = "Preto";
        golDoDiego.qtdePortas = 5;
        System.out.println("A cor do gol do Diego é: " + golDoDiego.cor);
        mudarCor(golDoDiego);
        System.out.println("A cor do gol do Diego é: " + golDoDiego.cor);

        VwGol golDoVitor = new VwGol();
        golDoVitor.anoFabricao = 2021;
        golDoVitor.cor = "Branca";
        golDoVitor.qtdePortas = 3;
        mudarCor(golDoVitor);
        System.out.println(golDoVitor.anoFabricao);

        // Consigo chamar o ligar, pois o método é desse contexto.
        // Não consigo chamar o montar, pois é do contexto d class
        golDoDiego.ligar();
        System.out.println("Gol do Diego ligado");
    }

    public static void mudarCor(VwGol variavelDoProfessor) {
        variavelDoProfessor.cor = "Azul";
        variavelDoProfessor.anoFabricao = 2029;
    }

}