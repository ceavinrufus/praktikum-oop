import java.util.*;
import java.lang.reflect.*;

class Detektif {
  static String bukaRahasia(Asisten asisten) throws Exception {
    // TODO: Kembalikan nilai variabel gebetan yang terdapat pada asisten
    Field[] f = asisten.getClass().getDeclaredFields();
    for (Field ifa : f){
        ifa.setAccessible(true);
    }
    Field gebet = asisten.getClass().getField("gebetan");
    return (String) gebet.get(asisten);

  }
  static void intipBankSoal(Asisten asisten) throws Exception {
    // TODO: Panggil method showBankSoalPraktikum pada objek asisten 
    Method[] f = asisten.getClass().getDeclaredMethods();
    for (Method ifa : f){
        ifa.setAccessible(true);
    }
    Method m = asisten.getClass().getMethod("showBankSoalPraktikum");
    m.invoke(null);
}
}