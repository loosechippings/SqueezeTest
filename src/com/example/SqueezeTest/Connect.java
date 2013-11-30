package com.example.SqueezeTest;

import android.os.AsyncTask;
import android.util.Log;
import com.example.SqueezeTest.SqueezeMain;
import org.bff.squeezeserver.SqueezeServer;
import org.bff.squeezeserver.exception.ConnectionException;

public class Connect extends AsyncTask<String,Void,Void> {

    private final SqueezeMain squeezeMain;

    public Connect(SqueezeMain squeezeMain) {
        this.squeezeMain=squeezeMain;
    }

    @Override
    protected Void doInBackground(String... params) {
        SqueezeServer ss= null;
        try {
            ss = new SqueezeServer("192.168.1.80",9002);
        } catch (ConnectionException e) {
            Log.d("Connect",e.toString());
        }
        if (ss.isConnected()) {
            squeezeMain.setSqueezeServer(ss);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        squeezeMain.setup();
    }
}
