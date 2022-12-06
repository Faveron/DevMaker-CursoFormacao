public class Main {
    public static void main(String[] args) {
        System.out.println("Fechamos construtores");
        System.out.println("Começamos métodos e visibilidade de métodos, atributos e classes");
        System.out.println("Tipos de vsibiliade: ");
        /*
        private - private é um modificador de acesso que restringe totalmente o acesso aquele
                  recurso da classe de todas as demais classes
        package (default) - Este modificador permite que apenas classes do mesmo pacote
                            tenham acesso as propriedades que possuem este modificador
        protected - Com este tipo modificador, podemos declarar que um atributo ou
                    método é visível apenas para as classes do mesmo pacote ou
                    para as subclasses daquela classe
        public - Declarando classes, atributos ou métodos com este modificador,
                 automaticamente dizemos que aquela propriedade é acessível a partir de qualquer outra classe
         */

         /*
        Visibilidades
        publica (public) - Visível a todos sem distinção. Menos restritiva
        privada (private) - Visível apenas a quem esta na mesma class. Mais restritiva
        protegida (protected) - Visível a quem esta na mesma classe, quem herda e quem esta no mesmo pacote.
        pacote (package) (default) - Visível a quem esta na mesma classe e no mesmo pacote, mas não a quem herda.
         */
    }
}