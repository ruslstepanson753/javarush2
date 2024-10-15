package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject("test string");
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }
    //метод сверки хэш-кода из стринг с хэшкодом от ByteArrayOutputStream
    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        // далее создаётся переменная, которая передаст нам сообщение хэшкода MD5 в байтах
        MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
        // загружаем в переменную массив байт, из которого нужно получить код
        mdAlgorithm.update(byteArrayOutputStream.toByteArray());
        // получаем массив байт хэшкода
        byte[] digest = mdAlgorithm.digest();
        //создаём переменную для хранения результата в 16ричной системе
        StringBuffer hexString = new StringBuffer();
        //далее цикл преобразования чисел из двоичной в 16ричную
        for (int i = 0; i < digest.length; i++) {

            String x = Integer.toHexString(0xFF & digest[i]);
            if (x.length() < 2) x = "0" + x;
            hexString.append(x);
        }
        /*альтернативный вариант
        for (byte b : bytes){
        builder.append(String.format("%02X",b)):
        }
         */
        // далее сверка хэшкодов
        return hexString.toString().equals(md5);
    }
}
