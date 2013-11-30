package com.example.SqueezeTest;

import org.bff.squeezeserver.SqueezeServer;

import java.util.Map;

public interface SqueezeMain {

    public void setSqueezeServer(SqueezeServer ss);

    public SqueezeServer getSqueezeServer();

    void addPlayers(Map<String, String> playerNames);

    void setup();
}
