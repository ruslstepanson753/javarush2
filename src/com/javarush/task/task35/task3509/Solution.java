package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static <T>  ArrayList <T>newArrayList(T... elements) {
        ArrayList <T> list= new ArrayList<>(elements.length);
        Collections.addAll(list, elements);
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> list = new HashSet<>();
        list.addAll(Arrays.asList(elements));
        return list;
    }

    public static < K,V> HashMap< K,V> newHashMap(List<?extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()){
            throw new IllegalArgumentException();
        }
        HashMap<K,V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        //напишите тут ваш код
        return map;
    }
}
