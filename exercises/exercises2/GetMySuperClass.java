import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetMySuperClass {

    public static void main(String[] args) {
        Class<?> superClass = getSuperClass(GetMySuperClass.class);
        System.out.println("The superclass is: " + superClass.getName());
        System.out.println("The superclass is: " + getSuperClass(superClass.getSuperclass()));
    }

    public static Class<?> getSuperClass(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.getSuperclass();
    }
}