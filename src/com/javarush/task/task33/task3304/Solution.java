package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON Ӏ 3304
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.writeValue(writer, one);
        String ss = writer.toString(); // получение строки сконвертированнного в Json объекта One
        String key1 = "\"" + one.getClass().getSimpleName().toLowerCase() + "\""; // получение строки имени класса объекта One
        String key2 = "\"" + resultClassObject.getSimpleName().toLowerCase() + "\""; // получение строки имени класса resultClassObject
        ss = ss.replaceFirst(key1, key2); // замена имени класса на нужный в строке объекта Json
        // далее обратная конвертация из Json в объект
        StringReader reader = new StringReader(ss);
        ObjectMapper mapper2 = new ObjectMapper();
        return mapper2.readValue(reader, resultClassObject);
    }
    //описание класса 1
    //в аннотации разделено поле с именем класса
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;
    }
    //описание класса 2
    //в аннотации разделено поле с именем класса
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;
    }
}
