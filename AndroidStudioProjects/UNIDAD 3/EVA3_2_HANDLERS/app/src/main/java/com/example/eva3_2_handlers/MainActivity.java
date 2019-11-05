package com.example.eva3_2_handlers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtVwMensa;
    Thread tHilo;
    //HANDLER
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //AQUI PUEDEN INTERACTUAR CON LA UI
            //AQUI PUEDEN
            String mensa = (String) msg.obj;
            txtVwMensa.append(mensa);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensa = findViewById(R.id.txtVwMensa);
        tHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;

                while(true){
                    try {
                        Thread.sleep(500);
                        String sCade = "i =" + i + "\n";
                        Message msg = handler.obtainMessage(1, sCade);
                        handler.sendMessage(msg);
                        Log.wtf("Hilo",sCade);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    i++;
                }
            }
        };
        tHilo.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tHilo.interrupt();

    }
}
