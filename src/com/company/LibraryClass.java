package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LibraryClass {
    String s = "";
    public void doIt(Object object){
        Class objectClass = object.getClass();
        Method [] methods = objectClass.getMethods();
        for (Method m: methods) {
            Annotation ann = m.getAnnotation(NeedMethod.class);

            if(ann != null){
                try {
                    s = (String)m.invoke(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                System.out.println(s);
            }
        }
    }
}
