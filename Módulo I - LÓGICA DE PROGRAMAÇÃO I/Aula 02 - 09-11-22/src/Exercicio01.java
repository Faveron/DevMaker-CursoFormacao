/*
Faça um programa no qual o usuário entre com um par de valores (x, y)
Eles representam as coordendas de um ponto no plano
Determine: O quadrante ao qual pertence o ponto, ou se está sobre um dos eixos cartesianos
           ^
        A  |  B
        ------->
        D  |  C
*/

import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.printf("Digite a coordenada X: ");
        int coor_x = entrada.nextInt();
        System.out.printf("Digite a coordenada Y: ");
        int coor_y = entrada.nextInt();

        if(coor_x == 0 && coor_y == 0) {
            System.out.printf("O ponto está na origem do plano");
        }else if(coor_x == 0) {
            System.out.printf("O ponto (%d; %d) está sobre o eixo Y", coor_x, coor_y);
        }else if(coor_y == 0) {
            System.out.printf("O ponto (%d; %d) está sobre o eixo X", coor_x, coor_y);
        }else if(coor_x > 0 && coor_y > 0) {
            System.out.printf("O ponto (%d; %d) está no quadrante B", coor_x, coor_y);
        }else if(coor_x < 0 && coor_y > 0) {
            System.out.printf("O ponto (%d; %d) está no quadrante A", coor_x, coor_y);
        }else if(coor_x < 0 && coor_y < 0) {
            System.out.printf("O ponto (%d; %d) está no quadrante D", coor_x, coor_y);
        }else{
            System.out.printf("O ponto (%d; %d) está no quadrante C", coor_x, coor_y);
        }
    }
}