package com.vc.play.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.e("MyService","onCreate");
        super.onCreate();

    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.e("MyService","onBind");
        Log.e("MyService","thread_name" + Thread.currentThread().getName());
        return binder;
    }


  private IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {
      @Override
      public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

      }

      @Override
      public int getData() throws RemoteException {
          return 0;
      }

      @Override
      public int caculateNum(int a, int b) throws RemoteException {

          Log.e("MyService","caculateNum");
          return (a +b);
      }
  };



}
