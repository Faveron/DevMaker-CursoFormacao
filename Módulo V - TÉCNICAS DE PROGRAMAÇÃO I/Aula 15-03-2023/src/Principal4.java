import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Principal4 {
    private static String CAMINHO_PROJETO = "C:\\Users\\wesle\\Documents\\Zalke\\ProjetosJava\\DevMaker - Curso Formação\\Módulo V - TÉCNICAS DE PROGRAMAÇÃO I\\Aula 15-03-2023";

    public static void main(String[] args) {
        File arquivo = new File(CAMINHO_PROJETO, "meuarquivo.txt");
        File novoArquivo = new File(CAMINHO_PROJETO, "novoarquivo.txt");

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            if (!novoArquivo.exists()) {
                novoArquivo.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /** 1º jeito de ler e escrever um arquivo **/
        // try with resources
//        try (
//                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
//                PrintWriter writer = new PrintWriter(new FileWriter(novoArquivo))
//        ) {
//            String linha;
//            while ((linha = reader.readLine()) != null) {
//                writer.println(linha);
//                writer.flush();
//            }
//        } catch (IOException e) {
//            new RuntimeException(e);
//        }

        // JAVA NIO
        Path path = Path.of(CAMINHO_PROJETO, "meuarquivo.txt");
        Path novoArquivoPath = Path.of(CAMINHO_PROJETO, "novoarquivo.txt");
        try {
            String conteudo = Files.readString(path);
            System.out.println(conteudo);

            List<String> linhas = Files.readAllLines(path);
            System.out.println(linhas);

//            byte[] bytes = conteudo.getBytes();
//            Files.write(novoArquivoPath, bytes, StandardOpenOption.CREATE_NEW);

            Files.writeString(novoArquivoPath, conteudo);
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);

            List<String> atualizado = lines.stream()
                    .map(linha -> {
                        if (linha.contains("Jorge")) {
                            return linha + " Pereira";
                        }
                        return linha;
                    }).toList();
            Files.write(path, atualizado);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}