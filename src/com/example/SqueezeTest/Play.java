package com.example.SqueezeTest;

import android.os.AsyncTask;
import org.bff.squeezeserver.Player;
import org.bff.squeezeserver.SqueezeServer;
import org.bff.squeezeserver.exception.ConnectionException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Play extends AsyncTask<String,Void,Void>{

    private final SqueezeMain squeezeMain;

    public Play(SqueezeMain squeezeMain) {
        this.squeezeMain=squeezeMain;
    }

    @Override
    protected Void doInBackground(String... params) {
        SqueezeServer ss=squeezeMain.getSqueezeServer();

        Player player=ss.getPlayer(params[0]);
        try {
            player.play();
        } catch (ConnectionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
    }
}
