package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;

/* 
Дженерики для создания прокси-объекта
*/

public class Solution {
    //пример возврата прокси для Дженериков
    //Метод getProxy должен возвращать прокси для любого интерфейса, который наследуется от Item.
    //в мэйне предлагаются возможные варианты перегрузки метода
    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }
    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;//проверка на наследование от Item
        boolean isBig = proxy instanceof Big;//проверка на наследование от Big
        boolean isSmall = proxy instanceof Small;//проверка на наследование от Small
        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
// далее пример , как создать метод с расширенным типом интерфейсов, наследуемых от заданного
    //первым аргументом указан тип класса
    //остальные аргументы - перечень интерфейсов
    public <T extends Item> T getProxy(Class<T> type, Class<?>... additionalInterfaces) {
        Class<?>[] interfaces = new Class<?>[additionalInterfaces.length + 1];//создаём массив наследуемых интерфейсов
        interfaces[0] = type;//создаём переменную базового типа класса
        //далее заносим аргументы в массив интерфейсов
        System.arraycopy(additionalInterfaces, 0, interfaces, 1, additionalInterfaces.length);
        Object instance = Proxy.newProxyInstance//создаём объект, завязанный с прокси
                (
        //во внутрь прокси грузим шаблон этого класса, массив интерфейсов, новый объект прокси
                this.getClass().getClassLoader(),interfaces,new ItemInvocationHandler()
                );
        return (T) instance; // возвращаем объект текущего типа ,связанный с прокси
    }
}
