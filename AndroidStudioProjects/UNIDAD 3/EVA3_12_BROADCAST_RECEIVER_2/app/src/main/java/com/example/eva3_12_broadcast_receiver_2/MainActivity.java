package com.example.eva3_12_broadcast_receiver_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtVwDatos;
BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        receiver = new MiReceptorDifusion();
        IntentFilter filtro = new IntentFilter("MI_SERVICIO");
        registerReceiver(receiver, filtro);
    }

    class MiReceptorDifusion extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            txtVwDatos.append(intent.getStringExtra("MENSAJE") + "\n");

        }
    }
}
