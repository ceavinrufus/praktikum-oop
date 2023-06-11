import java.util.*;
import java.lang.reflect.*;

class Detektif {
  static String bukaRahasia(Asisten asisten) throws Exception {
    // TODO: Kembalikan nilai variabel gebetan yang terdapat pada asisten
    Field[] gebetanFields = asisten.getClass().getDeclaredFields();
    for (Field f : gebetanFields) {
        f.setAccessible(true);
        }
    Field f = asisten.getClass().getField("gebetan");
    return (String) f.get(asisten);
    }
  static void intipBankSoal(Asisten asisten) throws Exception {
      Method[] asisMethods = asisten.getClass().getDeclaredMethods();
      for (Method e : asisMethods) {
        e.setAccessible(true);
        //   if (asisMethods[i].getName().equals("showBankSoalPraktikum")) {
        //     Class o = new Class();
        //     asisMethods[i].invoke(o);
        //   }
      }
      Method m = asisten.getClass().getMethod("showBankSoalPraktikum");
        m.invoke(null);
    // TODO: Panggil method showBankSoalPraktikum pada objek asisten 
  }
}