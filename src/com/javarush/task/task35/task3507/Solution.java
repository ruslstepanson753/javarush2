package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/*
ClassLoader - что это такое?
*/
/*
Реализуй логику метода getAllAnimals. Аргумент метода pathToAnimals - это абсолютный путь к директории,
в которой хранятся скомпилированные классы. Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal. НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров,
- создать по одному объекту. Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/";
        File dir = new File(pathToAnimals);
        //поиск файлов с расширением
        String[] pathes = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir1, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        for (String p : pathes) {
            try {
                // финалим директорию с файлами, среди которых ищем нужный класс
                final String finalPathToAnimals = pathToAnimals;
                // индикатор поиска в классе нужного интерфейса
                boolean hasInterface = false;
                //индикатор наличия конструктора
                boolean hasConstructor = false;

                // далее настройка получения класса из файла
                ClassLoader loader = new ClassLoader() {
                    @Override
                    //переписываем метод findClass, который будет получать аргумент - имя файла из списка
                    public Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            // добавляем полный путь к файлу из директории, имени и расширения
                            // fetchClassFromFS возвращает массив байт файла с проверкой размера
                            byte[] b = fetchClassFromFS(finalPathToAnimals + className + ".class");
                            //defineClass Преобразует массив байтов в экземпляр класса Class
                            return defineClass(null, b, 0, b.length);
                        } catch (FileNotFoundException ex) {
                            return super.findClass(className);
                        } catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };
                // получаем имя файла без расширения
                String className = p.substring(0, p.length() - 6);
                //вызываем метод класслодера, который ранее переписали
                // получаем необходимый класс таким образом
                Class clazz = loader.loadClass(className);
                // получаем массив интерфейсов из полученного класса
                Class[] interfaces = clazz.getInterfaces();
                //сверка, есть ли нужные нам интерфейсы в массиве
                for (Class i : interfaces) {
                    if (Animal.class == i) {
                        hasInterface = true;
                        break;
                    }
                }
                if (!hasInterface) continue;
                //проверка на наличие конструкторов
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if (c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }
                if (!hasConstructor) continue;
                result.add((Animal) clazz.newInstance());
            } catch (Exception e) {
            }
        }
        return result;
    }


    private static byte[] fetchClassFromFS(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        // Get the size of the file
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}

