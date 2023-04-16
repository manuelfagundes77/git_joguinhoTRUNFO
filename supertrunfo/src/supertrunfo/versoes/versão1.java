package supertrunfo.versoes;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

import supertrunfo.classes.pokemon;


public class versão1 {

    /* 
     * @param args
     *             nessa versão estamos UTILIZANDO SOMENTE A CLASSE POKEMON POKEMON.
     *            1 - o jogo so seleciona 1 Carta para o jogador.
     *            2 - o jogo encerram depois de comparar a unica carta .
     *            3 - O jogo não esta Completo.
     */
    public static void main(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in);
        ArrayList<pokemon> pokemon = new ArrayList<pokemon>();

        pokemon.add(new pokemon("Pikachu", 5, 4, 7));
        pokemon.add(new pokemon("Chamander", 7, 3, 8));
        pokemon.add(new pokemon("Bulbasouro", 4, 8, 6));
        pokemon.add(new pokemon("Ratata", 6, 5, 5));

        int jogador = new SecureRandom().nextInt(pokemon.size());
        int pc = new SecureRandom().nextInt(pokemon.size());
        //while para não sortear a msm carta.
        while (pc == jogador) {
            pc = new SecureRandom().nextInt(pokemon.size());
        }
        pokemon jogadorCarta = pokemon.get(jogador);
        pokemon pcCarta = pokemon.get(pc);

        // chamada do Jogo
        System.out.println("---------------------------------------- \n");
        System.out.println("vamos jogar super trunfo.\n");
        
        System.out.println("---------------------------------------- \n");
        System.out.println("Jogador  " + jogadorCarta);
        
        System.out.println("---------------------------------------- \n");
        System.out.println("carta PC " + pcCarta);

        String atributo = "";
        String certeza = "n";


        // while para confirma a escolha do atributo
        while (certeza.equals("n")) {

            System.out.println("digite o nome do atributo que voce escolhe:");
            atributo = leitor.nextLine();

            // while para digitar nome do atributo correto;
            while (!atributo.equals("ataque") && !atributo.equals("defesa") && !atributo.equals("magia")) {
                System.out.println("Atributo invalido. Porfavor digite ataque, defesa ou magia");
                atributo = leitor.nextLine();
            }

            System.out.println("voce escolheu: " + atributo + ", tem  certeza desse atributo? s /n");
            certeza = leitor.nextLine();
        }
        System.out.println("----------------------------------------\n");

        //If para receber a variavel atributo correta para confirmar se ganhou ou perdeu.
        if (atributo.equals("ataque")) {
            if (jogadorCarta.getAtaque() > pcCarta.getAtaque()) {
                System.out.println("Parabens!!!, você ganhou.");
                System.out.printf("Seu ataque era: %d, e o do seu oponente era: %d, carta %s \n",
                        jogadorCarta.getAtaque(), pcCarta.getAtaque(), pcCarta.getNome());
            } else {
                System.out.println("Você Perdeu, seu ataque é menor do que a do seu oponente.");
                System.out.printf("Seu ataque era: %d, e o do seu oponente era: %d, carta %s \n",
                        jogadorCarta.getAtaque(), pcCarta.getAtaque(), pcCarta.getNome());
            }
        }
        if (atributo.equals("defesa")) {
            if (jogadorCarta.getDefesa() > pcCarta.getDefesa()) {
                System.out.println("Parabens!!!, você ganhou.");
                System.out.printf("Sua Defera era: %d, e a do seu oponente era: %d, carta %s \n",
                        jogadorCarta.getDefesa(), pcCarta.getDefesa(), pcCarta.getNome());
            } else {
                System.out.println("Você Perdeu, sua defesa é menor do que a do seu oponente.");
                System.out.printf("Sua Defera era: %d, e a do seu oponente era: %d, carta %s \n",
                        jogadorCarta.getDefesa(), pcCarta.getDefesa(), pcCarta.getNome());
            }
        }
        if (atributo.equals("magia")) {
            if (jogadorCarta.getMagia() > pcCarta.getMagia()) {
                System.out.println("Parabens!!!, você ganhou.");
                System.out.printf("Sua magia  era: %d, e a do seu oponente era: %d, carta %s \n",
                        jogadorCarta.getMagia(), pcCarta.getMagia(), pcCarta.getNome());
            } else {
                System.out.println("Você Perdeu, sua magia é menor do que a do seu oponente.");
                System.out.printf("Sua magia  era: %d, e a do seu oponente era: %d, carta %s \n",
                        jogadorCarta.getMagia(), pcCarta.getMagia(), pcCarta.getNome());
            }
        }
        leitor.close();
    }
}
