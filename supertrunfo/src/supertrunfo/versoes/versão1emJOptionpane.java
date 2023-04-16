package supertrunfo.versoes;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import supertrunfo.classes.pokemon;

import java.security.SecureRandom;

public class versão1emJOptionpane {
   public static void main(String[] args) {
      //Scanner leitor = new Scanner(System.in);
      ArrayList<pokemon> pokemon = new ArrayList<pokemon>();

      pokemon.add(new pokemon("Pikachu", 5, 4, 7));
      pokemon.add(new pokemon("Chamander", 7, 3, 8));
      pokemon.add(new pokemon("Bulbasouro", 4, 8, 6));
      pokemon.add(new pokemon("Ratata", 6, 5, 5));
      
      int escolhaFINAL = JOptionPane.YES_OPTION;
      while (escolhaFINAL != JOptionPane.NO_OPTION) {
      int jogador = new SecureRandom().nextInt(pokemon.size());
      int pc = new SecureRandom().nextInt(pokemon.size());
      // while para não sortear a msm carta.
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
      //String certeza = "n";

      JOptionPane.showMessageDialog(null, "vamos jogar super trunfo.");
      JOptionPane.showMessageDialog(null, "sua carta: " + jogadorCarta);

     
      int escolhaConfirmada = JOptionPane.NO_OPTION;
      while (escolhaConfirmada != JOptionPane.YES_OPTION) {
         atributo = JOptionPane.showInputDialog(null,
               "Digite o nome do atributo que você escolhe (ataque, defesa ou magia):");

         // while para digitar nome do atributo correto;
         while (!atributo.equals("ataque") && !atributo.equals("defesa") && !atributo.equals("magia")) {
            atributo = JOptionPane.showInputDialog(null,
                  "Atributo inválido. Por favor digite ataque, defesa ou magia.");
         }

         escolhaConfirmada = JOptionPane.showConfirmDialog(null,
               "Você escolheu " + atributo + ". Confirma sua escolha?", "Confirmação de escolha",
               JOptionPane.YES_NO_OPTION);
      }
      System.out.println("----------------------------------------\n");

      // If para receber a variavel atributo correta para confirmar se ganhou ou
      // perdeu.
      if (atributo.equals("ataque")) {
         if (jogadorCarta.getAtaque() > pcCarta.getAtaque()) {
            JOptionPane.showMessageDialog(null,
                  "Parabens!!!, você ganhou.\n Seu ataque era: " + jogadorCarta.getAtaque() + "\n ataque do Oponente "
                        + pcCarta.getAtaque() + " Carta do oponente era: \n" + pcCarta);
         } else {
            JOptionPane.showMessageDialog(null, "Você Perdeu, \n Seu Ataque era: " + jogadorCarta.getAtaque()
                  + "\n Ataque do Oponente " + pcCarta.getAtaque() + " Carta do oponente era: \n" + pcCarta);
         }
      }
      if (atributo.equals("defesa")) {
         if (jogadorCarta.getDefesa() > pcCarta.getDefesa()) {
            JOptionPane.showMessageDialog(null,
                  "Parabens!!!, você ganhou.\n Sua Defesa era: " + jogadorCarta.getDefesa()
                        + "\n Defesa do Oponente era " + pcCarta.getDefesa() + " Carta do oponente era: \n" + pcCarta);
         } else {
            JOptionPane.showMessageDialog(null, "Você Perdeu, \n Sua defesa era: " + jogadorCarta.getDefesa()
                  + "\n Defesa do Oponente " + pcCarta.getDefesa() + " Carta do oponente era: \n" + pcCarta);
         }
      }
      if (atributo.equals("magia")) {
         if (jogadorCarta.getMagia() > pcCarta.getMagia()) {
            JOptionPane.showMessageDialog(null, "Parabens!!!, você ganhou.\n Sua Magia era: " + jogadorCarta.getMagia()
                  + "\n A Magia do Oponente era " + pcCarta.getMagia() + " Carta do oponente era: \n" + pcCarta);
         } else {
            JOptionPane.showMessageDialog(null, "Você Perdeu, \n Sua Magia era: " + jogadorCarta.getMagia()
                  + "\n Magia do Oponente era " + pcCarta.getMagia() + " Carta do oponente era: \n" + pcCarta);
         }
      }

      JOptionPane.showMessageDialog(null, "FIM DE JOGO\n\n  Obrigado por jogar.");
      escolhaFINAL = JOptionPane.showConfirmDialog(null,
               "Deseja jogar novamente", "Jogar Novamente",
               JOptionPane.YES_NO_OPTION);
   }
      // JOptionPane.showInputDialog(null, "jogar novamente", "pokemon",
      // JOptionPane.YES_NO_CANCEL_OPTION);
      /*
       * int resposta = JOptionPane.showConfirmDialog(null, "Sua mensagem aqui",
       * "Título da caixa de diálogo", JOptionPane.YES_NO_OPTION);
       * 
       * if (resposta == JOptionPane.YES_OPTION) {
       * // Códiguo a ser executado se o usário clicar em "Sim"
       * } else if (resposta == JOptionPane.NO_OPTION) {
       * // Código a ser executado se o usuário clicar em "Não"
       * } else {
       * // Código a ser executado se o usuário fechar a caixa de diálogo sem clicar
       * em nenhum botão
       * }
       */

   }
}
