import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal3 {

    private static String CAMINHO_PROJETO = "C:\\Users\\wesle\\Documents\\Zalke\\ProjetosJava\\DevMaker - Curso Formação\\Módulo V - TÉCNICAS DE PROGRAMAÇÃO I\\Aula 15-03-2023";

    public static void main(String[] args) throws IOException {
        // I.O Stream

        // CLASSES ABSTRATAS
        // InputStream
        // OutputStream
        // Reader
        // Writer

        // IMPLEMENTACOES

        // FileInputStream, FileOutputStream
        // FileReader, FileWriter

        // BufferedInputStream, BufferedOutputStream | flush()
        // BufferedReader, BufferedWriter

        // ObjectInputStream, ObjectOutputStream | Serializable

        // PrintStream, PrintWriter

        try {
            File arquivo = new File(CAMINHO_PROJETO, "meuarquivo.txt");
            File novoArquivo = new File(CAMINHO_PROJETO, "novoarquivo.txt");

            if (!novoArquivo.exists()) {
                novoArquivo.createNewFile();
            }
            /** 1º jeito de ler e escrever um arquivo **/
//            InputStream fileInputStream = new FileInputStream(arquivo);
//            OutputStream outputStream = new FileOutputStream(novoArquivo);
//            int byteArquivo;
//            while((byteArquivo = fileInputStream.read()) != -1) {
//                outputStream.write(byteArquivo);
//            }

            /** 2º jeito de ler e escrever um arquivo **/
//            Reader reader = new FileReader(arquivo);
//            Writer writer = new FileWriter(novoArquivo);
//            int caractere;
//            while ((caractere = reader.read()) != -1) {
//                writer.write(caractere);
//                writer.flush();
//            }

            /** 3º jeito de ler e escrever um arquivo **/
//            InputStream fileInputStream = new FileInputStream(arquivo);
//            InputStream inputStream = new BufferedInputStream(fileInputStream);
//
//            OutputStream fileOutputStream = new FileOutputStream(novoArquivo);
//            OutputStream outputStream = new BufferedOutputStream(fileOutputStream);
//
//            byte[] buffer = new byte[1024];
//            int byteArquivo;
//            while ((byteArquivo = inputStream.read(buffer, 0, buffer.length)) > 0) {
//                outputStream.write(byteArquivo);
//                outputStream.flush();
//            }

            /** 4º jeito de ler e escrever um arquivo **/
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            BufferedWriter writer = new BufferedWriter(new FileWriter(novoArquivo));
            String linha;

            while ((linha = reader.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}