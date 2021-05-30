package com.company.design;


import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.decorator.*;
import com.company.design.proxy.BroeserProxy;
import com.company.design.proxy.Browser;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;
import java.util.concurrent.atomic.AtomicLong;



public class Main {

    public static void main(String[] args) {

        //싱글톤 패턴
        //Singleton();

        //어댑터 패턴
        //Adapter();

        //Proxy 패턴
        //Proxy();

        //Decorator 패턴
        Decorator();

    }

    //콘센트
    public static void connect(Electron110V electron110V){
        electron110V.powerOn();
    }

    public static void Singleton(){
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
    }

    public static void Adapter(){
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electron110V adapter = new SocketAdapter(cleaner);
        connect(adapter);
        // connect(cleaner);

        AirConditioner airConditioner = new AirConditioner();
        Electron110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);

    }

    public static void Proxy(){
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        IBrowser browser1 = new BroeserProxy("www.naver.com");
        browser1.show();
        browser1.show();
        browser1.show();
        browser1.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );
        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
    }

    public static void Decorator(){
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        // a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();

    }
}
