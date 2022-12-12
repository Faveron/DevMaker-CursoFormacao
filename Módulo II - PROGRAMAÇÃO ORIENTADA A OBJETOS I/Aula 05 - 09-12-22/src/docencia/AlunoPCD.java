package docencia;

public class AlunoPCD extends Aluno {

    private String deficiencia;

    public AlunoPCD(String nome, String curso) {
        super(nome, curso);
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

}
