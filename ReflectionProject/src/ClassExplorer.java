import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ClassExplorer {

    public static void explorerMetadata(Object o) throws Exception {
        System.out.println("----> Extracting attributes");
        for (Field f : o.getClass().getDeclaredFields()) {
            System.out.println(f.getName() + ":" + f.getType().getName());
        }
        System.out.println();
        System.out.println("----> Extracting methods");
        for (Method m : o.getClass().getDeclaredMethods()) {
            System.out.println(m.getName() + ":" + m.getReturnType().getName());
        }
        System.out.println();
        System.out.println("----> Extracting data object");
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.get(o));
            f.setAccessible(false);
        }
        System.out.println();
        System.out.println("----> Extracting by method execution");
        for (Method m : o.getClass().getDeclaredMethods()) {
            if (m.getName().startsWith("get")) {
                System.out.println(m.getName() + " - value:" + m.invoke(o, null));
            }
        }
    }
}
