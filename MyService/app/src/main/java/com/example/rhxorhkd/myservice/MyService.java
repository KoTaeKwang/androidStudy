package com.example.rhxorhkd.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";
    public MyService() {

    }
    @Override
    public void onCreate() {  //서비스도 수명주기가 존재  메모리에 올라가면 실행된다.
        Log.d(TAG,"onCreate() 호출됨.");  //->디버깅할때 찍는 로그
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestory() 호출됨.");  //->디버깅할때 찍는 로그
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {   //service는 웬만하면 죽지 않음 메모리가 부족한경우에만 강제 종료됨. 서비스로 명령을 보낸것을 받아주는 함수가 onStartCommand
        Log.d(TAG,"onStartCommand() 호출됨.");  //->디버깅할때 찍는 로그

        if(intent!=null){
            String command =intent.getStringExtra("command");
            if(command!=null){
                if(command.equals("start")){
                    //스레드 생성
                    PrintThread thread = new PrintThread();
                    thread.start();// start실행하면 run이 실행되
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    class PrintThread extends Thread{
        public void run(){
            for(int i=0;i<100;i++)
            {
                Log.d(TAG, "# " + i + " 서비스에서 반복됨.");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
