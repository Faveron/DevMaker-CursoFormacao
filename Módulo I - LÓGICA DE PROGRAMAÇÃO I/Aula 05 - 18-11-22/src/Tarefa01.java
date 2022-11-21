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

        int matricula;
        double[] notas = new double[4];

        for (int i = 0; i < turma.length; i++)
        {
            System.out.println();
            matricula = getMatricula(i);

            for (int j = 0; j < notas.length; j++)
            {
                notas[j] = getNota(j);
            }
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

    public static int getMatricula(int i)
    {
        Scanner entrada = new Scanner(System.in);
        String numero;
        do
        {
            System.out.printf("Digite a matricula do %dº aluno: ", i+1);
            numero = entrada.nextLine();
        } while (!eInteriro(numero));

        return Integer.parseInt(numero);
    }

    public static boolean eInteriro(String texto)
    {
        try
        {
            Integer.parseInt(texto);
            if(Integer.parseInt(texto) > 0)
            {
                return true;
            }else
            {
                System.out.println("O número tem que ser maior que zero, tente novamente");
                return false;
            }
        } catch (Exception e)
        {
            System.out.println("Entrada inválida, tente novamente");
            return false;
        }
    }

    public static double getNota(int i)
    {
        Scanner entrada = new Scanner(System.in);
        String numero;
        do
        {
            System.out.printf("Digite a %dº nota: ", i+1);
            numero = entrada.nextLine();
        } while (!eDouble(numero));

        return Double.parseDouble(numero);
    }

    public static boolean eDouble(String texto)
    {
        try
        {
            Double.parseDouble(texto);
            if(Double.parseDouble(texto) >= 0 && Double.parseDouble(texto) <= 10)
            {
                return true;
            }else
            {
                System.out.println("O número tem que ser entre 0 e 10, tente novamente");
                return false;
            }
        } catch (Exception e)
        {
            System.out.println("Entrada inválida, tente novamente");
            return false;
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