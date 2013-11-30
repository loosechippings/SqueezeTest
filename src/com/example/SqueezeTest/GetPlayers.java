package com.example.SqueezeTest;

import android.os.AsyncTask;
import org.bff.squeezeserver.Player;
import org.bff.squeezeserver.SqueezeServer;
import org.bff.squeezeserver.exception.ConnectionException;

import java.util.*;

public class GetPlayers extends AsyncTask<String,Void,Map<String,String>>{

    private final SqueezeMain squeezeMain;

    public GetPlayers(SqueezeMain squeezeMain) {
        this.squeezeMain=squeezeMain;
    }

    @Override
    protected Map<String,String> doInBackground(String... params) {
        SqueezeServer ss=squeezeMain.getSqueezeServer();
        Collection<Player> players;
        Map<String,String> playerNames=new HashMap<String, String>();

        try {
            players=ss.getAllPlayers();
            for (Player player:players) {
                playerNames.put(player.getId(),player.getName());
            }
        } catch (ConnectionException e) {
            // swallow
        }
        finally {
            return playerNames;
        }
    }

    @Override
    protected void onPostExecute(Map<String,String> playerNames) {
        squeezeMain.addPlayers(playerNames);
    }
}
