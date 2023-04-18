package supertrunfo.classes;

import java.security.SecureRandom;
import java.util.ArrayList;

//CLASSE para criar as cartas dentro de um array do tipo pokemon 
//OU SEJA NOSSO BARALHO
public class baralho {

   private ArrayList<pokemon> baralho;
   private ArrayList<pokemon> jogadorBaralho;
   private ArrayList<pokemon> pcBaralho;
   private ArrayList<pokemon> baralhoDeEmpate;

   public baralho() {

      this.baralho = new ArrayList<pokemon>();

      
      baralho.add(new pokemon("Pikachu", 5, 4, 7));
      baralho.add(new pokemon("Chamander", 5, 3, 8));
      baralho.add(new pokemon("Bulbasouro", 5, 8, 6));
      baralho.add(new pokemon("Ratata", 5, 5, 5));
      baralho.add(new pokemon("Squirtle", 5, 6, 4));
      baralho.add(new pokemon("Caterpie", 5, 4, 3));
      baralho.add(new pokemon("Weedle", 5, 5, 6));
      baralho.add(new pokemon("Pidgey", 4, 4, 6));
      baralho.add(new pokemon("Spearow", 6, 5, 5));
      baralho.add(new pokemon("Ekans", 5, 6, 3));

   }

   public ArrayList<pokemon> getBaralho() {
      return baralho;
      
   }

   
   public ArrayList<pokemon> getBaralhoEmpate() {
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

   //
   public void criandoBaralhoPlayes() {

      this.jogadorBaralho = new ArrayList<>();
      this.pcBaralho = new ArrayList<>();
      this.baralhoDeEmpate = new ArrayList<>();
   }

   public void sortearBaralho(baralho baralho) {
      int tamanhoDoBaralho = (int) (baralho.getTamanho() / 2);

      for (int i = 0; i < tamanhoDoBaralho; i++) {
         int jogadorRecebe = new SecureRandom().nextInt(baralho.getTamanho());
         pokemon jogadorCarta = baralho.getCartaBaralho(jogadorRecebe);
         jogadorBaralho.add(jogadorCarta);
         baralho.removeCarta(jogadorCarta);
      }

      pcBaralho.addAll(baralho.getBaralho());
   }

   public int getValorAtributo(String atributo, pokemon carta) {
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

      
   public void realizarJogada(String atributo, pokemon jogadorCarta, pokemon pcCarta, int contadorDeEmpate, ArrayList<pokemon> baralhoDeEmpate) {
      int valorAtributoJogador = getValorAtributo(atributo, jogadorCarta);
      int valorAtributoPC = getValorAtributo(atributo, pcCarta);

      
         if (valorAtributoJogador > valorAtributoPC) {
            System.out.println("Parabens!!!, você ganhou.");
            System.out.printf("Seu ataque era: %d, e o do seu oponente era: %d, carta %s \n",
                  jogadorCarta.getAtaque(), pcCarta.getAtaque(), pcCarta.getNome());
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

            }
         } else if (valorAtributoJogador < valorAtributoPC) {
            System.out.println("Você Perdeu, seu ataque é menor do que a do seu oponente.");
            System.out.printf("Seu ataque era: %d, e o do seu oponente era: %d, carta %s \n",
                  jogadorCarta.getAtaque(), pcCarta.getAtaque(), pcCarta.getNome());
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

            }
         } else if (valorAtributoJogador == valorAtributoPC) {
            System.out.println("Você EMPATOU, seu ataque é igual ao do  seu oponente.");
            System.out.printf("Seu ataque era: %d, e o do seu oponente era: %d, carta %s \n",
                  jogadorCarta.getAtaque(), pcCarta.getAtaque(), pcCarta.getNome());
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
      

      
      
}
}





