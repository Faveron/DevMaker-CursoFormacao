import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class Principal {

    private static String CAMINHO_PROJETO = "C:\\Users\\wesle\\Documents\\Zalke\\ProjetosJava\\DevMaker - Curso Formação\\Módulo V - TÉCNICAS DE PROGRAMAÇÃO I\\Aula 15-03-2023\\";

    public static void main(String[] args) {
        // LEITURA E ESCRITA DE ARQUIVOS
        // I.O -> N.I.O

        // caminho absoluto
        // /Users/jorge/Study/letscode/sinquia913/tecnicas_de_programacao/src/aula05/exercicio_em_aula.txt

        // ../aula05/exercicio_em_aula.txt

        // File
        // Path

        File file = new File(CAMINHO_PROJETO, "meuarquivo.txt");

        // Criando Arquivo
        try {
            File diretorioProjeto = new File(CAMINHO_PROJETO);
            if (diretorioProjeto.isDirectory()) {
                System.out.println("Eh um diretorio");
            }
            if (diretorioProjeto.isFile()) {
                System.out.println("Eh um arquivo");
            }
            if (diretorioProjeto.isDirectory() && diretorioProjeto.canWrite() && !file.exists()) {
                file.createNewFile();
                System.out.println("Arquivo criado com sucesso!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // deletar um arqui
//        file.deleteOnExit();
//
//        if (file.exists()) {
//            boolean isArquivoDeletado = file.delete();
//            if (isArquivoDeletado) {
//                System.out.println("O arquivo existe e foi deletado");
//            }
//        }

        // parent, length e totalSpace

        System.out.println("parent: " + file.getParent());

        String path = file.getPath();
        System.out.println("path: " + path);

        System.out.println("length: " + file.length());

        System.out.println("Total space: " + file.getParentFile().getTotalSpace());

        long lastModified = file.lastModified();
        System.out.println("Modificado: " + lastModified);
        var data = Instant.ofEpochMilli(lastModified).atZone(ZoneId.systemDefault());
        System.out.println("Modificado: " + data);

        File[] files = file.getParentFile().listFiles();
        for (File it : files) {
            if (it.isFile()) {
                System.out.println(it.length() + " - " + it.getName());
            }
        }
    }
}