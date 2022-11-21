/*
    Escreva um programa em Java que manipule um vetor de registros com dados de 10 trabalhadores de uma empresa,
    conforme a estrutura a seguir:
        - int id;
        - String nome;
        - char sexo;
        - float salario;
    O programa deve ter as seguintes funções:
        a) uma função para ler os dados dos 10 funcionários.
        b) uma procedimento que receba por referência a lista e exiba os dados dos 10 funcionários.
        c) uma função que receba, como parâmetro, um caractere correspondente ao sexo e a lista para
        exibir os dados somente dos funcionários do respectivo sexo.
        d) uma procedimento que receba por referência a lista de funcionários e atualize o salário
        de todos os funcionários de acordo com o percentual informado como parâmetro.
 */
import java.util.Scanner;

public class Tarefa02
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        Trabalhador[] trabalhadores = new Trabalhador[4];

        for (int i = 0; i < trabalhadores.length; i++)
        {
            System.out.printf("Digite os dados do %dº trabalhador:\n", i+1);
            trabalhadores[i] = lerDadosTrabalhador();
        }

        exibirDadosTrabalhadores(trabalhadores);

        System.out.print("\nDigite uma letra para o sexo (M ou F): ");
        char sexo = entrada.next().toUpperCase().charAt(0);
        exibirTrabalhadorPorSexo(trabalhadores, sexo);

        System.out.print("\nDigite um valor em porcentagem: ");
        /* Melhorar como se pega esse valor*/
        float aumento = entrada.nextFloat();
        autualizaSalario(trabalhadores, aumento);
        exibirDadosTrabalhadores(trabalhadores);
    }

    public static Trabalhador lerDadosTrabalhador()
    {
        Scanner entrada = new Scanner(System.in);

        int id;
        String nome;
        char sexo;
        float salario;

        id = getId();

        System.out.print("Nome: ");
        nome = entrada.nextLine();

        System.out.print("Sexo (M ou F): ");
        sexo = entrada.next().toUpperCase().charAt(0);

        salario = getSalario();

        return new Trabalhador(id, nome, sexo, salario);
    }

    public static int getId()
    {
        Scanner entrada = new Scanner(System.in);
        String numero;
        do
        {
            System.out.print("Id: ");
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

    public static float getSalario()
    {
        Scanner entrada = new Scanner(System.in);
        String numero;
        do
        {
            System.out.print("Salario: ");
            numero = entrada.nextLine();
        } while (!eFloat(numero));

        return Float.parseFloat(numero);
    }

    public static boolean eFloat(String texto)
    {
        try
        {
            Float.parseFloat(texto);
            if(Float.parseFloat(texto) >= 0)
            {
                return true;
            }else
            {
                System.out.println("O número é negativo, tente novamente");
                return false;
            }
        } catch (Exception e)
        {
            System.out.println("Entrada inválida, tente novamente");
            return false;
        }
    }

    public static void exibirDadosTrabalhadores(Trabalhador[] t)
    {
        System.out.print("\n\t\t Lista de trabalhadores\n");
        for (Trabalhador trabalhador : t)
        {
            exibirTrabalhador(trabalhador);
        }
    }

    public static void exibirTrabalhador(Trabalhador t)
    {
        System.out.printf("\nId: %d", t.id);
        System.out.printf("\nNome: %s", t.nome);
        System.out.printf("\nSexo: %c", t.sexo);
        System.out.printf("\nSalário: R$ %.2f", t.salario);
    }

    public static void exibirTrabalhadorPorSexo(Trabalhador[] t, char s)
    {
        for (Trabalhador trabalhador : t)
        {
            if (trabalhador.sexo == s)
            {
                exibirTrabalhador(trabalhador);
            }
        }
    }

    public static void autualizaSalario(Trabalhador[] t, float p)
    {
        for (Trabalhador trabalhador : t)
        {
            trabalhador.salario *= (1+p);
        }
    }
}

class Trabalhador
{
    int id;
    String nome;
    char sexo;
    float salario;

    Trabalhador(int id, String nome, char sexo, float salario)
    {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.salario = salario;
    }
}
