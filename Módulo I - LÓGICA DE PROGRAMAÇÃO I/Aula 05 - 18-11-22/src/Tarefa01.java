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
            System.out.println();
            System.out.printf("Digite a matricula do %dº aluno: ", i+1);
            matricula = entrada.nextInt();

            for (int j = 0; j < notas.length; j++)
            {
                System.out.printf("Digite a %dº nota: ", j+1);
                notas[j] = entrada.nextDouble();
            }
            limparBuffer(entrada);

            turma[i] = new Aluno(matricula, notas);
        }

        imprimeAlunos(turma);

        for (int i = 0; i < turma.length; i++)
        {
            System.out.printf("\nMatricula do %dº aluno: %s\n", i+1, turma[i].matricula);
            System.out.printf("Média: %.1f\n", mediaAluno(turma[i]));
        }
    }

    static void imprimeAlunos(Aluno[] a)
    {
        System.out.print("\n\t\t Lista de alunos\n");
        for (int i = 0; i < a.length; i++)
        {
            System.out.printf("\nMatricula do %dº aluno: %s", i+1, a[i].matricula);
            for (int j = 0; j < a[i].notas.length; j++)
            {
                System.out.printf("\nNota do %dº bimestre: %.1f", j+1, a[i].notas[j]);
            }
            System.out.println();
        }
    }

    static double mediaAluno(Aluno a)
    {
        double soma = 0;
        for (int i = 0; i < a.notas.length; i++)
        {
            soma += a.notas[i];
        }
        return soma/a.notas.length;
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
    double[] notas = new double[4];

    Aluno(int m, double[] n)
    {
        this.matricula = m;
        System.arraycopy(n, 0, this.notas, 0, n.length);
    }
}