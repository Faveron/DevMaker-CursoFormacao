public class Post {
    private final String DATA;
    private final String HORA;
    private String conteudo;

    public Post(String data, String hora, String conteudo) {
        this.DATA = data;
        this.HORA = hora;
        this.conteudo = conteudo;
    }

    public String getDATA() {
        return DATA;
    }

    public String getHORA() {
        return HORA;
    }

    public String getConteudo() {
        return conteudo;
    }
}