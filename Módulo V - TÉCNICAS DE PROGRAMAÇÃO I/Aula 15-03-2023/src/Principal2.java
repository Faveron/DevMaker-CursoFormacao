import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;

public class Principal2 {

    private static String CAMINHO_PROJETO = "C:\\Users\\wesle\\Documents\\Zalke\\ProjetosJava\\DevMaker - Curso Formação\\Módulo V - TÉCNICAS DE PROGRAMAÇÃO I\\Aula 15-03-2023";

    public static void main(String[] args) {
        // Path
        Path path = Path.of(CAMINHO_PROJETO);
        System.out.println(path);

        int nameCount = path.getNameCount();
        System.out.println("Número de diretorios pai: " + nameCount);

        for (int i = 0; i < nameCount; i++) {
            System.out.println("Diretorio " + i + ": " + path.getName(i));
        }

        Path subpath = path.subpath(0, 3);
        System.out.println(subpath);

        // Files
        Path arquivo = Paths.get(CAMINHO_PROJETO, "meuarquivo.txt");

        try {
            if (!Files.exists(arquivo)) {
                Files.createFile(arquivo);
                System.out.println("Arquivo criado com sucesso!");
            }
//            Files.deleteIfExists(arquivo);
//            String name = arquivo.getFileName().toString();
//            Files.copy(arquivo, Path.of(CAMINHO_PROJETO + "\\copia\\" + name));
//            Files.move(arquivo, Path.of(CAMINHO_PROJETO + "\\copia\\" + name), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}