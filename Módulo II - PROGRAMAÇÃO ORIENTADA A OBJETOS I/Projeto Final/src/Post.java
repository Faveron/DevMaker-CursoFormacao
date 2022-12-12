public class Post {
    final String data;
    final String hora;
    private String conteudo;

    public Post(String data, String hora, String conteudo) {
        this.data = data;
        this.hora = hora;
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}