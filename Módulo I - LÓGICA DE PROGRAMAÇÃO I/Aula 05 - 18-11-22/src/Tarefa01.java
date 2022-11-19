/*
    Faça um programa que:

    - Leia um vetor "turma" de 5 alunos
    - Cada registro/objeto de aluno deve ter o número de matrícula do aluno e suas notas de 4 bimestres
    - Faça um procedimento que imprima a lista de matrícula e notas de cada aluno
    - Percorra o vetor de alunos e imprima a matrícula e a média, calculada pela função criada, para cada aluno
 */

import java.util.Scanner;

public class Tarefa01
{
    public static void main(String[] args)
    {
        Aluno[] turma = new Aluno[5];
        Scanner entrada = new Scanner(System.in);

        int matricula;
        double[] notas = new double[4];

        for (int i = 0; i < turma.length; i++)
        {
            System.out.printf("Digite a matricula do %dº aluno: ", i+1);
            matricula = entrada.nextInt();

            for (int j = 0; j < notas.length; j++)
            {
                System.out.printf("Digite a %dº nota: ", j+1);
                notas[j] = entrada.nextDouble();
            }
            limparBuffer(entrada);

            turma[i] = new Aluno(matricula, notas[0], notas[1], notas[2], notas[3]);
        }

        imprimeAlunos(turma);

        for (int i = 0; i < turma.length; i++)
        {
            System.out.printf("\nMatricula do %dº aluno: %s\n", i+1, turma[i].matricula);
            System.out.printf("Média do %dº aluno: %.1f\n", i+1, mediaAluno(turma[i]));
        }
    }

    static void imprimeAlunos(Aluno[] a)
    {
        System.out.print("\n\t\t Lista de alunos\n");
        for (int i = 0; i < a.length; i++)
        {
            System.out.printf("\nMatricula do %dº aluno: %s", i+1, a[i].matricula);
            System.out.printf("\nNota do 1º bimestre: %.1f", a[i].nota1);
            System.out.printf("\nNota do 2º bimestre: %.1f", a[i].nota2);
            System.out.printf("\nNota do 3º bimestre: %.1f", a[i].nota3);
            System.out.printf("\nNota do 4º bimestre: %.1f", a[i].nota4);
        }
    }

    static double mediaAluno(Aluno a)
    {
        return (a.nota1+a.nota2+a.nota3+a.nota4)/4;
    }

    static void limparBuffer(Scanner scanner)
    {
        if (scanner.hasNextLine())
        {
            scanner.nextLine();
        }
    }
}

class Aluno
{
    int matricula;
    double nota1;
    double nota2;
    double nota3;
    double nota4;

    Aluno(int m, double n1, double n2, double n3, double n4)
    {
        this.matricula = m;
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
        this.nota4 = n4;
    }
}