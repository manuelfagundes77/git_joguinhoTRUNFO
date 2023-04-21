package supertrunfo.versoes;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import supertrunfo.classes.baralho;
import supertrunfo.classes.pokemon;

public class Versao3 {

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
    */
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);

      // CRIANDO BARALHO QUE SERA USADO
      baralho baralho2 = new baralho();

      // criando as arrays q vao receba as cartas do jogador e PC e BAralho de EMPATE,
      // arryas do tipo pokemon pois elas vão receber objeto pokemon
      List<pokemon> jogadorBaralho = new ArrayList<pokemon>();
      List<pokemon> pcBaralho = new ArrayList<pokemon>();
      List<pokemon> barahoDeEmpate = new ArrayList<pokemon>();

      // criado para facilitar
      int tamanhoDoBaralho = (int) (baralho2.getTamanho() / 2) + 1;

      // FOR para escolha aleatoria de cartas dentro do baralho criado, ira escolher a
      // metade e retirar elas do baralho e mandar para o baralho
      // do jogador
      for (int i = 1; i < tamanhoDoBaralho; i++) {
         int jogador = new SecureRandom().nextInt(baralho2.getTamanho());// modo para pegar numero aleatorio
         pokemon jogadorCarta = baralho2.getCartaBaralho(jogador);// pegando carta do baralho e colocando ela em nova
                                                                  // variavel
         jogadorBaralho.add(jogadorCarta);
         baralho2.removeCarta(jogadorCarta);
      }
      // pc baralho recebe o restantes das cartas do baralho.
      pcBaralho = baralho2.getBaralho();

      System.out.println("cartas do jogador, voce recebeu " + jogadorBaralho.size() + " Cartas.");
      System.out.println("*********************************************");
      System.out.println("cartas do Pc tambem recebeu " + pcBaralho.size() + " Cartas.");
      System.out.println("---------------------------------------- \n");
      System.out.println("vamos jogar super trunfo.\n");

      int i = 0;
      int contadorDeEmpate = 0;

      // while principal para continuar o JOGO ate que alguem fique sem cartas.
      while (jogadorBaralho.size() > 0 && pcBaralho.size() > 0) {
         System.out.println("sua " + (i + 1) + "ª Carta");

         pokemon jogadorCarta = jogadorBaralho.get(0);
         pokemon pcCarta = pcBaralho.get(0);
         i++;
         System.out.println("---------------------------------------- \n");
         System.out.println("NUMERO DE CARTAS QUE VC POSSUI >>>> " + jogadorBaralho.size() + " <<<<<");
         System.out.println("Jogador  " + jogadorCarta);

         System.out.println("---------------------------------------- \n");
         System.out.println("NUMERO DE CARTAS QUE O PC POSSUI >>>> " + pcBaralho.size() + " <<<<<");
         System.out.println("carta PC " + pcCarta);

         System.out.println("---------------------------------------- \n");
         System.out.println("NUMERO DE CARTAS BARALHO DE EMPATE >>>>" + barahoDeEmpate.size() + "<<<<<");

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

         

         if (atributo.equals("defesa")) {
            if (jogadorCarta.getDefesa() > pcCarta.getDefesa()) {
               System.out.println("Parabens!!!, você ganhou.");
               System.out.printf("Sua Defera era: %d, e a do seu oponente era: %d, carta %s \n",
                     jogadorCarta.getDefesa(), pcCarta.getDefesa(), pcCarta.getNome());
               jogadorBaralho.add(pcCarta);
               pcBaralho.remove(pcCarta);
               jogadorBaralho.remove(jogadorCarta);
               jogadorBaralho.add(jogadorCarta);

               // if caso na ultima rodada tenha acontecido empate
               // ESSE IF ESTA DENTRO DO PRIMEIRO IF
               if (contadorDeEmpate != 0) {
                  System.out.println("cartas que voce ganhou");
                  for (int in = 0; in < barahoDeEmpate.size(); in++) {
                     jogadorBaralho.add(barahoDeEmpate.get(in));
                     // System.out.println(barahoDeEmpate.get(in));
                  }
                  contadorDeEmpate = 0;
                  System.out.println("voce ganhou todas as cartas do empate. qunatidade de cartas obitidas :"
                        + barahoDeEmpate.size());
                  barahoDeEmpate.clear();
                  System.out.println("TESTE numero de cartas no empate baralho" + barahoDeEmpate.size());
                  System.out.println("todas minhas cartas");
                  for (int in = 0; in < jogadorBaralho.size(); in++) {

                     System.out.println(jogadorBaralho.get(in));
                  }
                  System.out.println("*************************************");

               }

            } else if (jogadorCarta.getDefesa() < pcCarta.getDefesa()) {
               System.out.println("Você Perdeu, sua defesa é menor do que a do seu oponente.");
               System.out.printf("Sua Defera era: %d, e a do seu oponente era: %d, carta %s \n",
                     jogadorCarta.getDefesa(), pcCarta.getDefesa(), pcCarta.getNome());
               pcBaralho.add(jogadorCarta);
               jogadorBaralho.remove(jogadorCarta);
               pcBaralho.remove(pcCarta);
               pcBaralho.add(pcCarta);

               if (contadorDeEmpate != 0) {
                  System.out.println("cartas que O PC Ganhou");
                  for (int in = 0; in < barahoDeEmpate.size(); in++) {
                     pcBaralho.add(barahoDeEmpate.get(in));
                     System.out.println(barahoDeEmpate.get(in));
                  }
                  contadorDeEmpate = 0;
                  System.out.println("O PC ganhou todas as cartas do empate. qunatidade de cartas obitidas :"
                        + barahoDeEmpate.size());
                  barahoDeEmpate.clear();
                  System.out.println("TESTE numero de cartas no empate baralho" + barahoDeEmpate.size());
                  System.out.println("todas minhas cartas");
                  for (int in = 0; in < pcBaralho.size(); in++) {

                     System.out.println(pcBaralho.get(in));
                  }
                  System.out.println("todas as  cartas do pc");
               }
            } else if (jogadorCarta.getDefesa() == pcCarta.getDefesa()) {
               System.out.println("Você EMPATOU, seu ataque é igual ao do  seu oponente.");
               System.out.printf("Seu ataque era: %d, e o do seu oponente era: %d, carta %s \n",
                     jogadorCarta.getAtaque(), pcCarta.getAtaque(), pcCarta.getNome());
               barahoDeEmpate.add(jogadorCarta);
               barahoDeEmpate.add(pcCarta);
               jogadorBaralho.remove(jogadorCarta);
               pcBaralho.remove(pcCarta);
               contadorDeEmpate = 1;
               System.out.println("cartas adicionada ao bolo de empate");
               for (int teste = 0; teste < barahoDeEmpate.size(); teste++) {
                  System.out.println(barahoDeEmpate.get(teste));
               }
               System.out.println("cartas adicionada ao bolo de empate foram: " + barahoDeEmpate.size());
            }
         }

         if (atributo.equals("magia")) {
            if (jogadorCarta.getMagia() > pcCarta.getMagia()) {
               System.out.println("Parabens!!!, você ganhou.");
               System.out.printf("Sua magia  era: %d, e a do seu oponente era: %d, carta %s \n",
                     jogadorCarta.getMagia(), pcCarta.getMagia(), pcCarta.getNome());
               jogadorBaralho.add(pcCarta);
               pcBaralho.remove(pcCarta);
               jogadorBaralho.remove(jogadorCarta);
               jogadorBaralho.add(jogadorCarta);

               // if caso na ultima rodada tenha acontecido empate
               // ESSE IF ESTA DENTRO DO PRIMEIRO IF
               if (contadorDeEmpate != 0) {
                  System.out.println("cartas que voce ganhou");
                  for (int in = 0; in < barahoDeEmpate.size(); in++) {
                     jogadorBaralho.add(barahoDeEmpate.get(in));
                     // System.out.println(barahoDeEmpate.get(in));
                  }
                  contadorDeEmpate = 0;
                  System.out.println("voce ganhou todas as cartas do empate. qunatidade de cartas obitidas :"
                        + barahoDeEmpate.size());
                  barahoDeEmpate.clear();
                  System.out.println("TESTE numero de cartas no empate baralho" + barahoDeEmpate.size());
                  System.out.println("todas minhas cartas");
                  for (int in = 0; in < jogadorBaralho.size(); in++) {

                     System.out.println(jogadorBaralho.get(in));
                  }
                  System.out.println("*************************************");

               }
            } else if (jogadorCarta.getMagia() < pcCarta.getMagia()) {
               System.out.println("Você Perdeu, sua magia é menor do que a do seu oponente.");
               System.out.printf("Sua magia  era: %d, e a do seu oponente era: %d, carta %s \n",
                     jogadorCarta.getMagia(), pcCarta.getMagia(), pcCarta.getNome());
               pcBaralho.add(jogadorCarta);
               jogadorBaralho.remove(jogadorCarta);
               pcBaralho.remove(pcCarta);
               pcBaralho.add(pcCarta);
               if (contadorDeEmpate != 0) {
                  System.out.println("cartas que O PC Ganhou");
                  for (int in = 0; in < barahoDeEmpate.size(); in++) {
                     pcBaralho.add(barahoDeEmpate.get(in));
                     System.out.println(barahoDeEmpate.get(in));
                  }
                  contadorDeEmpate = 0;
                  System.out.println("O PC ganhou todas as cartas do empate. qunatidade de cartas obitidas :"
                        + barahoDeEmpate.size());
                  barahoDeEmpate.clear();
                  System.out.println("TESTE numero de cartas no empate baralho" + barahoDeEmpate.size());
                  System.out.println("todas minhas cartas");
                  for (int in = 0; in < pcBaralho.size(); in++) {

                     System.out.println(pcBaralho.get(in));
                  }
                  System.out.println("todas as  cartas do pc");

               }
            } else if (jogadorCarta.getMagia() == pcCarta.getMagia()) {
               System.out.println("Você EMPATOU, sua Magia é igual ao do  seu oponente.");
               System.out.printf("Sua maria era: %d, e o do seu oponente era: %d, carta %s \n",
                     jogadorCarta.getAtaque(), pcCarta.getAtaque(), pcCarta.getNome());
               barahoDeEmpate.add(jogadorCarta);
               barahoDeEmpate.add(pcCarta);
               jogadorBaralho.remove(jogadorCarta);
               pcBaralho.remove(pcCarta);
               contadorDeEmpate = 1;
               System.out.println("cartas adicionada ao bolo de empate");
               for (int teste = 0; teste < barahoDeEmpate.size(); teste++) {
                  System.out.println(barahoDeEmpate.get(teste));
               }
               System.out.println("cartas adicionada ao bolo de empate foram: " + barahoDeEmpate.size());
            }
         }
      }
      // FINAL DE JOGO DEPOIS QUE A CONDIÇÃO DO WHILE FICA FALSA.
      if (jogadorBaralho.size() > 0) {
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
      leitor.close();
   }
}
