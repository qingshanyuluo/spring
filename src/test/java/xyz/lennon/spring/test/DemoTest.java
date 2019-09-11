package xyz.lennon.spring.test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoTest {

    @Test
    public void testField() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        /*Field[] declareFields = clazz.getDeclaredFields();
//        Arrays.asList(declareFields).stream().forEach(System.out::println);
        Arrays.stream(declareFields).forEach(System.out::println);*/
        Field userServiceField = clazz.getDeclaredField("userService");
        UserService userService = new UserService();
        // important access private field
        userServiceField.setAccessible(true);
        String name = userServiceField.getName();
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        String setMethodName = "set" + name;
//        System.out.println(setMethodName);
        Method method = clazz.getMethod(setMethodName, UserService.class);
        method.invoke(userController, userService);

//        userServiceField.set(userController, userServices);

        System.out.println(userController.getUserService());
    }
}
