package com.vc.play.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private Button mButton;

    private  IMyAidlInterface mIMainAidl;
    IMyAidlInterface mInterface;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.btn);
        mTextView = (TextView) findViewById(R.id.textView);
        Intent intent =new Intent("com.vc.service");

        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                int  num=     mInterface.caculateNum(20,3);

                mTextView.setText(String.valueOf(num));


                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    ServiceConnection mConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            mInterface = IMyAidlInterface.Stub.asInterface(iBinder);



        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


}
