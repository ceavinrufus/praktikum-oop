class Bot implements Runnable {
    GameMaster  master;
  Bot(GameMaster master){
      this.master= master;
  }

  /*
    Bot akan menebak angka berkali-kali sampai game dinyatakan over
    dengan delay tiap tebakan 500 ms

    Setiap tebakan akan dibandingkan dengan nilai pada GameMaster
    Jika tebakan benar, maka tuliskan

    "Bot wins"

    Hint: Gunakan Thread.sleep(duration) untuk pause jalannya thread
    selama nilai duration 
  */
  public void run() {
      int guess;
     
      boolean tertebak = false;
    while (!tertebak) {
        guess = ((int) (Math.random() * (master.correctAnswer*3)));
        if (guess==(master.correctAnswer)) {
            System.out.println("Bot wins");
            tertebak = true;
            System.exit(0);
          }
          try {
            Thread.sleep(500);
          } catch(InterruptedException ex) {
            System.out.println("Bot is dead");
          }
    }
  }
}