import java.util.Scanner;

class Human extends Thread {
    GameMaster master;
  Human(GameMaster master){
    this.master = master;
  }


  /*
    Human akan menerima masukan dari pemain berkali-kali
    sampai game dinyatakan over

    Setiap tebakan akan dibandingkan dengan nilai pada GameMaster
    Jika tebakan benar, maka tuliskan

    "Human wins"
  */
  public void run(){
    Scanner input = new Scanner(System.in);
    int guess;
    boolean tertebak = false;
  while (!tertebak) {
        System.out.print("Tebakanmu: ");
        guess = input.nextInt();
      if (guess==(master.correctAnswer)) {
          System.out.println("Human wins");
          tertebak = true;
          super.interrupt();
          System.exit(0);
        }
  }
  }
}