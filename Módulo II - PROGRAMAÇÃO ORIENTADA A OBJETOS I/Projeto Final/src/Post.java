public class Post {
    private final String DATA;
    private final String HORA;
    private final String CONTEUDO;

    public Post(String data, String hora, String conteudo) {
        this.DATA = data;
        this.HORA = hora;
        this.CONTEUDO = conteudo;
    }

    public String getData() {
        return DATA;
    }

    public String getHora() {
        return HORA;
    }

    public String getConteudo() {
        return CONTEUDO;
    }
}