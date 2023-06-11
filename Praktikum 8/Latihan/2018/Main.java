import java.util.Scanner;

public class Main {
  /*
    Fungsi ini akan melakukan dua hal berikut:

    1. Menerima nilai maksimum tebakan dari pengguna
    2. Menjalankan permainan
  */
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Nilai maksimum: ");
    int max = input.nextInt();
    GameMaster game = new GameMaster(max);

    (new Human(game)).start();
    (new Thread(new Bot(game))).start();
  }
}