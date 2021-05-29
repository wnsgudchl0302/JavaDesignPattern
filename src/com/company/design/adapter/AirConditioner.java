package com.company.design.adapter;

public class AirConditioner implements Electron220V{
    @Override
    public void connect() {
        System.out.println("에어컨 220V on");
    }
}
