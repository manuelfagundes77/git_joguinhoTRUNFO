package supertrunfo;

import java.security.SecureRandom;
import java.util.Scanner;

import supertrunfo.classes.baralho;
import supertrunfo.classes.pokemon;

public class Versao4 {

    /**
     * @param args
     *             Nessa versão estamos UTILIZANDO AS CLASSES BARALHO e POKEMON.
     *             Diferente da ultima versão(5.1) q so utilizava a classe pokemon.
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
     *             o maior? ) FEITO
     * 
     *             6 - Foram Feitos Muitos METODOS PARA diminuir tamnho do main e
     *             tambem para diminuir repetição de codigo
     * 
     *             GWT/=====/
     *             SMARTGIT
     */
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {

           
            System.out.println("""
                       BEM VINDO AO JOGO SUPERTRUNFO

                    DIGITE
                        1 - Para jogar
                        2 - ler as Regras
                        3 - Encerrar o programa
                    """);
            int principal = leitor.nextInt();
            leitor.nextLine();

            if (principal == 1) {

                 // CRIANDO BARALHO QUE SERA USADO
                baralho baralho = new baralho();// criando o objeto baralho
                // jogometodos baralho = new jogometodos(); //criando objeto dos jogometodos
                // para que se possa usar seus metodos.

                baralho.criandoBaralhoPlayes();
                baralho.sortearBaralho(baralho); // realiza o sorteio do baralho

                System.out.println("   Você Recebeu  " + baralho.getTamanhoJogador() + " Cartas.");
                System.out.println("*********************************************");
                System.out.println("   O PC também Recebeu " + baralho.getTamanhoPC() + " Cartas.");
                System.out.println("---------------------------------------- \n");
                System.out.println("    vamos jogar super trunfo.\n");

                int contadorJogada = 1;
                int contadorDeEmpate = 0;// variavel criada para ativar o empate 0 não 1 sim
                String quemJoga2 = "";
                int caraOuCoroa = new SecureRandom().nextInt(10) + 1;
                String começaJogando = "";

                // if do cara ou coroa
                if (caraOuCoroa % 2 == 0) {
                    quemJoga2 = "jogador";
                    começaJogando = "Você";
                } else {
                    quemJoga2 = "PC";
                    começaJogando = "PC";
                }
                System.out.println("""
                            QUEM COMEÇA JOGANDO É %s !!!
                        """.formatted(começaJogando));

                // while principal para continuar o JOGO ate que alguem fique sem cartas.
                while (baralho.getTamanhoJogador() > 0 && baralho.getTamanhoPC() > 0) {
                    System.out.println("Numeros de Rodadas: " + contadorJogada + "ª Rodada");

                    pokemon jogadorCarta = baralho.getCartaBaralhoJogador(0);
                    pokemon pcCarta = baralho.getCartaBaralhoPc(0);
                    contadorJogada++;
                    System.out.println("---------------------------------------- \n");
                    System.out.println("NUMERO DE CARTAS QUE VC POSSUI >>>> " + baralho.getTamanhoJogador() + " <<<<<");
                    System.out.println("Jogador  " + jogadorCarta);

                    System.out.println("---------------------------------------- \n");
                    System.out.println("NUMERO DE CARTAS QUE O PC POSSUI >>>> " + baralho.getTamanhoPC() + " <<<<<");
                    System.out.println("carta PC " + pcCarta);

                    System.out.println("---------------------------------------- \n");
                    System.out.println(
                            "NUMERO DE CARTAS BARALHO DE EMPATE >>>>   " + baralho.getTamanhoEmpate() + "   <<<<<\n ");

                    String atributo = "";
                    String certeza = "n";

                    if (quemJoga2.equals("jogador")) {
                        // while para confirma a escolha do atributo
                        while (certeza.equals("n")) {
                            System.out.println("     ---- JOGADOR ESCOLHE ----");
                            System.out.println("digite o nome do atributo que voce escolhe:");
                            atributo = leitor.nextLine();

                            // while para digitar nome do atributo correto;
                            while (!atributo.equals("ataque") && !atributo.equals("defesa")
                                    && !atributo.equals("magia")) {
                                System.out.println("Atributo invalido. Porfavor digite ataque, defesa ou magia");
                                atributo = leitor.nextLine();
                            }

                            System.out.println("voce escolheu: " + atributo + ", tem  certeza desse atributo? s /n");
                            certeza = leitor.nextLine();
                        }
                        System.out.println("----------------------------------------\n");
                    } else if (quemJoga2.equals("PC")) {
                        atributo = baralho.pcVaiJogar(pcCarta);
                        System.out.println("     ---- PC  ESCOLHE ----");
                        System.out.println("PC VAI ESCOLHER   **** " + atributo + "  ****");
                        System.out.println("aperte qualquer coisa para continuar");
                        String nada = leitor.nextLine();

                    }

                    // metodo para realizar comparação de atritubo se ganhou ou perdeu
                    String recebeString = baralho.realizarJogada(atributo, jogadorCarta, pcCarta, contadorDeEmpate,
                            baralho.getBaralhoEmpate());

                    // if para mudar a vez de quem joga pc ou jogador, ele recebe uma string do
                    // metodo realizarjogada;
                    if (recebeString.equals("PC")) {
                        quemJoga2 = recebeString;
                    } else if (recebeString.equals("jogador")) {
                        quemJoga2 = recebeString;
                    }             
                } // FINAL DE JOGO DEPOIS QUE A CONDIÇÃO DO WHILE FICA FALSA.


                if (baralho.getTamanhoJogador() > 0) {
                    System.out.println("""
                            *************************************

                                      Você Venceu!!! =)

                                Um Verdadeiro Mestre Pokemon.

                            *************************************
                                """);
                } else {
                    System.out.println("""
                            *************************************
                                      Você PERDEU... :(

                                    MAIS SORTE NA PROXIMA.
                            *************************************
                                """);
                }

                System.out.println("""

                        DIGITE...
                               1 - jogar Novamente.
                               2-  Encerrar o programa.
                        """);
                int fimdejogo = leitor.nextInt();
                leitor.nextLine();
                if (fimdejogo == 1) {
                    continuar = true;
                    for (int i = 0; i < 100; i++) {
                        System.out.println("");
                    }
                } else if (fimdejogo == 2) {
                    continuar = false;
                    System.out.println(">>>>>>>>>>>>>>>>  JOGO ENCERRADO <<<<<<<<<<<<<<<<<");
                }
            }

            if (principal == 2) {
                System.out.println("""
                                        REGRAS
                        1 - Perde quem não tiver cartas na mão.
                        2 - em caso de empate do atributo escolhido, o jogador da vez escolhe outro atributo da proxima carta.
                        2.1 - as cartas q empataram vão para o baralho de empate, e quem ganhar a proxima rodada leva todas as cartas.
                        3 - quem ganha a rodada tem direito de escolher o atributo que sera jogado na proxima rodada

                        Deseja voltar ao menu inicial?
                                >>>> Aperte ENTER para voltar <<<<                              
                        """);
                        leitor.nextLine();
            } else if (principal == 3) {
                System.out.println(">>>>>>>>>>>>>>>>  JOGO ENCERRADO <<<<<<<<<<<<<<<<<");
                continuar = false;
            }

        }
    }
}
