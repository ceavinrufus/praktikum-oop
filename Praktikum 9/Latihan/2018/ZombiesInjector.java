import java.util.*;
import java.lang.*;
import java.lang.reflect.*;

class ZombiesInjector {
  static Object inject(Class c1) throws Exception {
    Object object;
    // TODO: Construct the class here
    //mengambil konstruktor
    Constructor constructor = c1.getConstructor(c1);
    //create object baru
    object = c1.newInstance();
    try {
      // TODO: Set zombies field in the created object to new ArrayList<String>() here.
      Class c2 = object.getClass();
      Field f = c2.getField("zombies");
      f.set(object, new ArrayList<String>());
      return object;
    } catch (Exception ex) {
      // TODO: Exception will happen if there are no zombies variable
      //       handle it here
      return object;
    }
  }
}