package com.javarush.task.task32.task3207;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
К серверу по RMI
*/
//пример имитации клиентской части
public class Solution {
    //уникальное имя сервера (одинаковый у сервера и клиента)
    public static final String UNIC_BINDING_NAME = "double.string";
    //объявление регистра (одинаковый у сервера и клиента)
    public static Registry registry;
    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    //далее создание имитации потока клиента
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try{
                //создаём объект такого же типа, как у имплементированнго метода сервера со связью с прокси
                DoubleString obj = (DoubleString) registry.lookup(UNIC_BINDING_NAME);
                //вызов метода сервера
                String res = obj.doubleString("123");
                System.out.println(res);
            }
            catch (RemoteException e){
                e.printStackTrace();
            }
            catch (NotBoundException e){
                e.printStackTrace();
            }
        }
    });
    //имитация сервера
    public static void main(String[] args) {
        // Pretend we're starting an RMI server as the main thread
        //создание заглушки
        Remote stub = null;
        try {
            //создание регистра
            registry = LocateRegistry.createRegistry(2099);
            //создание класса для сервера
            final DoubleStringImpl service = new DoubleStringImpl();
            // создание заглушки - приёмника удалённых вызовов
            stub = UnicastRemoteObject.exportObject(service, 0);
            // регистрация "заглушки" в реестре
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        // Start the client
        CLIENT_THREAD.start();
    }
}
