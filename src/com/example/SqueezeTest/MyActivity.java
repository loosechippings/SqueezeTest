package com.example.SqueezeTest;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import org.bff.squeezeserver.SqueezeServer;

import java.util.Map;

public class MyActivity extends Activity implements SqueezeMain {

    public static final String SQUEEZE_TEST = "SqueezeTest";
    SqueezeServer ss;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(SQUEEZE_TEST, "created");

        Connect connect=new Connect(this);
        connect.execute();
    }

    public SqueezeServer getSqueezeServer() {
        return ss;
    }

    @Override
    public void addPlayers(Map<String, String> playerNames) {
        LinearLayout layout= (LinearLayout) findViewById(R.id.layout);
        for (final Map.Entry<String,String> p:playerNames.entrySet()) {
            Log.d(SQUEEZE_TEST,"Player - "+p.getValue());
            Button button=new Button(this);
            button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setText(p.getValue());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Play play=new Play(MyActivity.this);
                    play.doInBackground(p.getKey());
                }
            });
            layout.addView(button);
        }
    }

    @Override
    public void setup() {
        GetPlayers getPlayers=new GetPlayers(this);
        getPlayers.execute();
    }

    public void setSqueezeServer(SqueezeServer ss) {
        this.ss = ss;
    }
}
