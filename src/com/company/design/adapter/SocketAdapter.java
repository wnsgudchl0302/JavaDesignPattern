package com.company.design.adapter;

public class SocketAdapter implements Electron110V{

    private Electron220V electron220V;

    public SocketAdapter(Electron220V electron220V){
        this.electron220V = electron220V;
    }
    @Override
    public void powerOn() {
        electron220V.connect();
    }
}
