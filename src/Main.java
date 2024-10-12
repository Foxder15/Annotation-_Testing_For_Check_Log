import Annotation.*;
import Entity.User;
import Entity.UserVIP;
import constant.VIPLevel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String run(Object user) {
        if (user.getClass().isAnnotationPresent(CheckLog.class)) {
            System.out.println("A user log........");
            for (Method method : user.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(RunLog.class)) {
                    RunLog annotation = method.getAnnotation(RunLog.class);
                    System.out.println(annotation.value());
                    try {
                        method.invoke(user);
                        System.out.println("Process successful!");
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        return "Error: " + e.getMessage();
                    }
                }
            }
        } else {
            System.out.println("VIP access log");
        }
        return "Secure!";
    }

    @SuppressWarnings("cast")
    public static void main(String[] args) {
        System.out.println("Running.....");
        List<Object> list = new ArrayList<>();
        Object user = new User(1, "Thanh Duy", "thanhduy@gmail.com");
        Object user2 = new User(2, "Anh Thu", "anhthu@gmail.com");
        Object user3 = new User(3, "Thu Duy", "thuduy@gmail.com");
        Object user4 = new User(4, "Thu Bi", "thubi@gmail.com");
        list.add(user);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        for (int i = 0; i < 20; i++) {
            int index = (int) (Math.random() * 4);
            System.out.println("\n" + run(list.get(index)));
            System.out.println("------");
        }

        //System.out.println(run(user));
        //System.out.println(run(userVIP));

//        for (Field field : userVIP.getClass().getDeclaredFields()) {
//            if (field.isAnnotationPresent(VIPLog.class)) {
//                try {
//                    field.setAccessible(true);
//                    Object value = field.get(userVIP);
//
//                    if (value instanceof VIPLevel level) {
//                        System.out.println(level + " logged in to the system");
//                    }
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
    }
}