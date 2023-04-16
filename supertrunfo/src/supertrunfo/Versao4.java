package supertrunfo;

import java.util.Scanner;

import supertrunfo.classes.baralho;
import supertrunfo.classes.pokemon;

public class Versao4 {

    /**
     * @param args
     *             Nessa versão estamos UTILIZANDO AS CLASSES BARALHO e POKEMON.
     *             Diferente da ultima versão(1) q so utilizava a classe pokemon.
     *             1 - O jogo esta distribuindo as cartas igualmente para o jogador
     *             é PC.
     *             2 - O jogo esta ganhando ou perdendo a carta depois da
     *             comparação.
     *             3 - O Jogo so Acabara quando o jogador ou pc estiverem sem
     *             cartas.
     *             4 - Nessa Versão foi implementado o Empate( regra do empate = as
     *             cartas de empate vao pra fora dos dois baralhaos é quem ganha a
     *             proxima rodada ganha elas e as
     *             atuais)
     *             5 - Precisa ser implementado Metodo para que caso o jogador
     *             perca, a maquina escolha o melhor atributo da proxima,
     *             Carta dela. (uma comparação entre todos os atributos int? e pegar
     *             o maior? )
     *                  
     *             6 - muito importante criar metodos para dimunuir o main
     * 
     *              GWT/=====/
     *              SMARTGIT
     */
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int a = 2;

        // CRIANDO BARALHO QUE SERA USADO

        baralho baralho = new baralho();// criando o objeto baralho
        // jogometodos baralho = new jogometodos(); //criando objeto dos jogometodos
        // para que se possa usar seus metodos.

        baralho.criandoBaralhoPlayes();

        baralho.sortearBaralho(baralho); // realiza o sorteio do baralho

        System.out.println("cartas do jogador, voce recebeu " + baralho.getTamanhoJogador() + " Cartas.");
        System.out.println("*********************************************");
        System.out.println("cartas do Pc tambem recebeu " + baralho.getTamanhoPC() + " Cartas.");
        System.out.println("---------------------------------------- \n");
        System.out.println("vamos jogar super trunfo.\n");

        int i = 0;
        int contadorDeEmpate = 0;// variavel criada para ativar o empate 0 não 1 sim

        // while principal para continuar o JOGO ate que alguem fique sem cartas.
        while (baralho.getTamanhoJogador() > 0 && baralho.getTamanhoPC() > 0) {
            System.out.println("sua " + (i + 1) + "ª Carta");

            pokemon jogadorCarta = baralho.getCartaBaralhoJogador(0);
            pokemon pcCarta = baralho.getCartaBaralhoPc(0);
            i++;
            System.out.println("---------------------------------------- \n");
            System.out.println("NUMERO DE CARTAS QUE VC POSSUI >>>> " + baralho.getTamanhoJogador() + " <<<<<");
            System.out.println("Jogador  " + jogadorCarta);

            System.out.println("---------------------------------------- \n");
            System.out.println("NUMERO DE CARTAS QUE O PC POSSUI >>>> " + baralho.getTamanhoPC() + " <<<<<");
            System.out.println("carta PC " + pcCarta);

            System.out.println("---------------------------------------- \n");
            System.out.println("NUMERO DE CARTAS BARALHO DE EMPATE >>>>" + baralho.getTamanhoEmpate() + "<<<<<");

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

            // If para receber a variavel atributo correta para confirmar se ganhou ou
            // perdeu.

            baralho.realizarJogada(atributo, jogadorCarta, pcCarta, contadorDeEmpate, baralho.getBaralhoEmpate());
        } // FINAL DE JOGO DEPOIS QUE A CONDIÇÃO DO WHILE FICA FALSA.
        if (baralho.getTamanhoJogador() > 0) {
            System.out.println("""
                    *************************************

                        Jogo encerrado você Venceu!!!

                        Um Verdadeiro Mestre Pokemon.

                    *************************************
                        """);
        } else {
            System.out.println("""
                    *************************************
                        Jogo encerrado você PERDEU...

                            MAIS SORTE NA PROXIMA.
                    *************************************
                        """);
        }
    }

}
