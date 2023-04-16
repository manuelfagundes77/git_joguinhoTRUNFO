package supertrunfo.classes;

//CLASSE PARA CRIAR AS CARTAS!!!
public class pokemon {
   
  private String nome;
  private int ataque, defesa, magia;



   public pokemon(String nome, int ataque, int defesa, int magia) {
      this.nome = nome;
      this.ataque = ataque;
      this.defesa = defesa;
      this.magia = magia;
   }

   public String getNome() {
      return nome;
   }

   public int getAtaque() {
      return ataque;
   }

   public int getDefesa() {
      return defesa;
   }

   public int getMagia() {
      return magia;
   }
   
   @Override
   public String toString() {
     // return "O pokemon criadou foi: \n " + this.nome +", Ataque: " + this.ataque + ", Defesa: " +this.defesa + ", Magia: " +this.magia + "\n";
      return " Carta: \n " + this.nome +", Ataque: " + this.ataque + ", Defesa: " +this.defesa + ", Magia: " +this.magia + "\n";
   }

  

  

}


