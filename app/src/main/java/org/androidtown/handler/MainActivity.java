package org.androidtown.handler;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  Handler handler = null;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    handler = new Handler() {
      @Override
      public void handleMessage(Message msg) {
        if (msg.what == 0) {
          Intent intent = new Intent(MainActivity.this, SubActivity.class);
          startActivity(intent);
        }
      }
    };

    new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 3; ++i) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        handler.sendEmptyMessage(0);
      }
    }.start();
  }

}
