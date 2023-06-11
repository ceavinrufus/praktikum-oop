public class GameMaster {
  int correctAnswer;

  /*
    Menghasilkan angka acak yang akan ditebak yang nilainya
    dibawah max
  */
  public GameMaster(int max) {
    correctAnswer = (int) (Math.random() * max);
  }

  /*
    Melakukan komparasi nilai answer pada argument
    dengan nilai correctAnswer

    Menghasilkan true jika nilainya sama
  */
  public boolean isCorrect(int answer){
      return (this.correctAnswer==answer);
  }

  /*
    Menghasilkan true jika game sudah selesai
    Game dinyatakan selesai ketika ada seorang pemain
    Bot maupun Manusia yang mampu menebak angka yang benar
  */
  public boolean isGameOver(){
      return true;
  }
}