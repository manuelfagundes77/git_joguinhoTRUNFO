package supertrunfo.classes;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;
import java.util.List;

//CLASSE para criar as cartas dentro de um array do tipo pokemon 
//OU SEJA NOSSO BARALHO
public class baralho {

   private List<pokemon> baralho;
   private List<pokemon> jogadorBaralho;
   private List<pokemon> pcBaralho;
   private List<pokemon> baralhoDeEmpate;

   public baralho() {

      this.baralho = new ArrayList<pokemon>();

      
      baralho.add(new pokemon("Pikachu", 7, 4, 7));
      baralho.add(new pokemon("Chamander", 6, 3, 8));
      baralho.add(new pokemon("Bulbasouro", 5, 8, 6));
      baralho.add(new pokemon("Ratata", 5, 4, 5));
/*       baralho.add(new pokemon("Squirtle", 4, 6, 4));
      baralho.add(new pokemon("Caterpie", 5, 4, 3));
      baralho.add(new pokemon("Weedle", 3, 5, 6));
      baralho.add(new pokemon("Pidgey", 4, 4, 6));
      baralho.add(new pokemon("Spearow", 6, 5, 5));
      baralho.add(new pokemon("Ekans", 5, 6, 3));
      baralho.add(new pokemon("Vulpix", 4, 3, 7));
      baralho.add(new pokemon("Gastly", 3, 3, 8));
      baralho.add(new pokemon("Onix", 8, 8, 2));
      baralho.add(new pokemon("Drowzee", 5, 5, 5));
      baralho.add(new pokemon("Krabby", 6, 4, 4));
      baralho.add(new pokemon("Voltorb", 4, 4, 7));
      baralho.add(new pokemon("Exeggcute", 5, 6, 4));
      baralho.add(new pokemon("Cubone", 6, 7, 3));
      baralho.add(new pokemon("Hitmonlee", 8, 3, 3));
      baralho.add(new pokemon("Hitmonchan", 6, 5, 3));
      baralho.add(new pokemon("Lickitung", 6, 8, 2));
      baralho.add(new pokemon("Koffing", 6, 5, 3));
      baralho.add(new pokemon("Tangela", 4, 7, 4));
      baralho.add(new pokemon("Kangaskhan", 7, 6, 2));
      baralho.add(new pokemon("Horsea", 4, 5, 6));
      baralho.add(new pokemon("Goldeen", 5, 4, 6));
      baralho.add(new pokemon("Staryu", 4, 4, 7));
      baralho.add(new pokemon("Mr. Mime", 2, 7, 6));
      baralho.add(new pokemon("Scyther", 8, 5, 2));
      baralho.add(new pokemon("Jynx", 5, 4, 6));
      baralho.add(new pokemon("Electabuzz", 7, 5, 3));
      baralho.add(new pokemon("Magmar", 6, 5, 4));
 */
   }

   public List<pokemon> getBaralho() {
      
      return baralho;
      
   }

   
   public List<pokemon> getBaralhoEmpate() {
      return baralhoDeEmpate;
   }

   public pokemon getCartaBaralho(int i) {
      return baralho.get(i);
   }

   public pokemon getCartaBaralhoJogador(int i) {
      return jogadorBaralho.get(i);
   }

   public pokemon getCartaBaralhoPc(int i) {
      return pcBaralho.get(i);
   }

   public pokemon getCartaBaralhoEmpate(int i) {
      return baralhoDeEmpate.get(i);
   }

   public int getTamanho() {
      return baralho.size();
   }

   public int getTamanhoJogador() {
      return jogadorBaralho.size();
   }

   public int getTamanhoPC() {
      return pcBaralho.size();
   }

   public int getTamanhoEmpate() {
      return baralhoDeEmpate.size();
   }

   public boolean removeCarta(pokemon i) {
      return baralho.remove(i);
   }

   public boolean addCartaJogador(pokemon i) {
      return jogadorBaralho.add(i);
   }

   public boolean removeCartaJogador(pokemon i) {
      return jogadorBaralho.remove(i);
   }

   public boolean addCartaPc(pokemon i) {
      return pcBaralho.add(i);
   }

   public boolean removeCartaPc(pokemon i) {
      return pcBaralho.remove(i);
   }

   public boolean addCartaEmpate(pokemon i) {
      return baralhoDeEmpate.add(i);
   }

   public boolean removeCartaEmpate(pokemon i) {
      return baralhoDeEmpate.remove(i);
   }

   public void apagaBaralhoEmpate() {
      baralhoDeEmpate.clear();
   }

   //criando arrays para guarda as cartas dos participantes
   public void criandoBaralhoPlayes() {

      this.jogadorBaralho = new ArrayList<>();
      this.pcBaralho = new ArrayList<>();
      this.baralhoDeEmpate = new ArrayList<>();
   }

   //metodo para Dividir  aleatoriamente as cartas 
   public void sortearBaralho(baralho baralho) {
      
      Collections.shuffle(baralho.getBaralho());// embaralhar a ordes das cartas antes de começar

      int tamanhoDoBaralho = (int) (baralho.getTamanho() / 2);

      for (int i = 0; i < tamanhoDoBaralho; i++) {
         int jogadorRecebe = new SecureRandom().nextInt(baralho.getTamanho());
         pokemon jogadorCarta = baralho.getCartaBaralho(jogadorRecebe);
         jogadorBaralho.add(jogadorCarta);
         baralho.removeCarta(jogadorCarta);
      }  
      pcBaralho.addAll(baralho.getBaralho());
   }

   // metodo para retorna somente o valor da carta , para diminuir codigo
   public int valorDoAtributo(String atributo, pokemon carta) {
      if (atributo.equals("ataque")) {
          return carta.getAtaque();
      } else if (atributo.equals("defesa")) {
          return carta.getDefesa();
      } else if(atributo.equals("magia")) {
         return carta.getMagia();
     } else {
      // caso o atributo seja inválido, retorna -1
      return -1;
     }
  }


//metodo para retornar somente o nome do atributo para diminuir codigo
  public String nomeDoAtributo(String atributo) {
   if (atributo.equals("ataque")) {
       return "Ataque";
   } else if (atributo.equals("defesa")) {
       return "Defesa";
   } else if(atributo.equals("magia")) {
      return "Magia";
  } else {
   // caso o atributo seja inválido, retorna -1
   return "";
  }
}

   //metodo para o pc Escolher entre o maior atributo de sua Carta;
   public String pcVaiJogar(pokemon pcCarta){
      int ataque = pcCarta.getAtaque();
      int defesa = pcCarta.getDefesa();
      int magia = pcCarta.getDefesa();

      if(ataque >= defesa && ataque >= magia){
         return "ataque";
      } else if(defesa >= ataque && defesa>= magia){
         return "defesa";
      } else if(magia >= ataque && magia >= defesa){
         return "magia";
      }

      return "";
   }

      
   public String realizarJogada(String atributo, pokemon jogadorCarta, pokemon pcCarta, int contadorDeEmpate, List<pokemon> baralhoDeEmpate) {
      int valorAtributoJogador = valorDoAtributo(atributo, jogadorCarta);
      int valorAtributoPC = valorDoAtributo(atributo, pcCarta);
      String nomeAtributoJogador = nomeDoAtributo(atributo);
     // String nomeAtributoPC = getNomeDoAtributo(atributo, pcCarta);

      
         if (valorAtributoJogador > valorAtributoPC) {
            System.out.println("*******************************************\n");
            System.out.println("Parabens!!!, você ganhou.");
            System.out.printf("Seu atributo escohido  %s era: %d, e o do seu oponente era: %d, carta %s \n",nomeAtributoJogador,
            valorAtributoJogador, valorAtributoPC, pcCarta.getNome());
            System.out.println("*******************************************\n");
            jogadorBaralho.add(pcCarta);
            pcBaralho.remove(pcCarta);
            jogadorBaralho.remove(jogadorCarta);
            jogadorBaralho.add(jogadorCarta);

            // if caso na ultima rodada tenha acontecido empate
            // ESSE IF ESTA DENTRO DO PRIMEIRO IF
            if (!baralhoDeEmpate.isEmpty()) {
               System.out.println("cartas que voce ganhou");
               for (int in = 0; in < baralhoDeEmpate.size(); in++) {
                  jogadorBaralho.add(baralhoDeEmpate.get(in));
                  // System.out.println(baralhoDeEmpate.get(in)ataque);
               }
               contadorDeEmpate = 0;
               System.out.println("voce ganhou todas as cartas do empate. qunatidade de cartas obitidas :"
                     + baralhoDeEmpate.size());
               baralhoDeEmpate.clear();
               System.out.println("TESTE numero de cartas no empate baralho" + baralhoDeEmpate.size());
               System.out.println("todas minhas cartas");
               for (int in = 0; in < jogadorBaralho.size(); in++) {

                  System.out.println(jogadorBaralho.get(in));
               }
               System.out.println("*************************************");

            } return "jogador";
         } else if (valorAtributoJogador < valorAtributoPC) {
            System.out.println("*******************************************\n");
            System.out.printf("Você Perdeu, seu Atributo %s é menor do que a do seu oponente.\n", nomeAtributoJogador);
            System.out.printf("Seu Atributo Escolhido %s era: %d, e o do seu oponente era: %d, carta %s \n", nomeAtributoJogador,
                  valorAtributoJogador, valorAtributoPC, pcCarta.getNome());
                  System.out.println("*******************************************\n");

            pcBaralho.add(jogadorCarta);
            jogadorBaralho.remove(jogadorCarta);
            pcBaralho.remove(pcCarta);
            pcBaralho.add(pcCarta);
            
            // if caso na ultima rodada tenha acontecido empate
            if (!baralhoDeEmpate.isEmpty()) {
               System.out.println("cartas que O PC Ganhou");
               for (int in = 0; in < baralhoDeEmpate.size(); in++) {
                  pcBaralho.add(baralhoDeEmpate.get(in));
                  System.out.println(baralhoDeEmpate.get(in));
               }
               contadorDeEmpate = 0;
               System.out.println("O PC ganhou todas as cartas do empate. qunatidade de cartas obitidas :"
                     + baralhoDeEmpate.size());
               baralhoDeEmpate.clear();
               System.out.println("TESTE numero de cartas no empate baralho" + baralhoDeEmpate.size());
               System.out.println("todas minhas cartas");
               for (int in = 0; in < pcBaralho.size(); in++) {

                  System.out.println(pcBaralho.get(in));
               }
               System.out.println("todas as  cartas do pc");
            }return  "PC";
         } else if (valorAtributoJogador == valorAtributoPC) {
            System.out.println("*******************************************\n");
            System.out.printf("Você EMPATOU!!! seu Atributo %s é igual ao do seu Oponente.\n", nomeAtributoJogador);
            System.out.printf("Seu Atributo %s era: %d, e o do seu oponente era: %d, carta %s \n",nomeAtributoJogador,
                  valorAtributoJogador, valorAtributoPC, pcCarta.getNome());
                  System.out.println("*******************************************\n");
            baralhoDeEmpate.add(jogadorCarta);
            baralhoDeEmpate.add(pcCarta);
            jogadorBaralho.remove(jogadorCarta);
            pcBaralho.remove(pcCarta);
            contadorDeEmpate++;
            System.out.println("cartas adicionada ao bolo de empate");
            for (int teste = 0; teste < baralhoDeEmpate.size(); teste++) {
               System.out.println(baralhoDeEmpate.get(teste));
            }
            System.out.println("cartas adicionada ao bolo de empate foram: " + baralhoDeEmpate.size());
         }
      
         
      
      return "nada";
}
}





