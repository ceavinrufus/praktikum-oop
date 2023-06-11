import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);

        String com, fuel;
        int nilai, n1, n2;
        boolean exc;
        exc = false;

        com = input.next();
        try {
            if (!com.equals("End")||!com.equals("Selesai")) {
                do {
                    Car c = new Car(com);
                    com = input.next();
                    if (com.equals("Fill")) {
                        fuel = input.next();
                        nilai = input.nextInt();
                        try {
                             c.fillingFuel(fuel, nilai);
                        } catch (FuelException e) {
                            exc = true;
                            System.out.println("["+e.getClass().getName()+"] " + e.getMessage());
                        }
                    } else if (com.equals("Service")) {
                        fuel = input.next();
                        nilai = input.nextInt();
                        n1 = input.nextInt();
                        n2 = input.nextInt();
                        try {
                            c.start();
                            c.fillingFuel(fuel, nilai);
                            c.changeGear(n1);
                            c.changeAcPower(n2);
                        }catch (FuelException e) {
                            exc = true;
                            System.out.println("["+e.getClass().getName()+"] " + e.getMessage());
                        }catch(InvalidInputCarException e){
                            exc = true;
                            System.out.println("["+e.getClass().getName()+"] " + e.getMessage());
                        }catch (TheCarIsOnException e) {
                            exc = true;
                            System.out.println("["+e.getClass().getName()+"] " + e.getMessage());
                        }
                        
                        
        
                    } else if (com.equals("Start")) {
                        try {
                            c.start();
                        } catch (TheCarIsOnException e) {
                            exc = true;
                            System.out.println("["+e.getClass().getName()+"] " + e.getMessage());
                        }
                        
                    } else if(com.equals("ChangeGear")) {
                        nilai = input.nextInt();
                        try{
                            c.changeGear(nilai);}
                        catch(InvalidInputCarException e){
                            exc = true;
                            System.out.println("["+e.getClass().getName()+"] " + e.getMessage());
                        }
                    } else if (com.equals("ChangeAcPower")) {
                        nilai = input.nextInt();
                        try {
                            c.changeAcPower(nilai);
                        } catch (InvalidInputCarException e) {
                            exc = true;
                            System.out.println("["+e.getClass().getName()+"] " + e.getMessage());
                        }    
                    } else if (com.equals("End")) {
                        System.out.println("Program selesai");
                        if (exc) {
                            System.out.println("Tidak ada unhandled exception");
                        }
                    }else{
                        throw new Exception();
                    }

                } while(!com.equals("End"));
        }
            
        } catch (Exception e) {
            System.out.println("Masukan tidak valid");
        }
    }
}