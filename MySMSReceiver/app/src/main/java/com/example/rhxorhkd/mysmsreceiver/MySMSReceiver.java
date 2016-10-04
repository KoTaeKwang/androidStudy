package com.example.rhxorhkd.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MySMSReceiver extends BroadcastReceiver {
    private static final String TAG= "MySMSReceiver";
    public MySMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) { //SMS에서 받을때 이 함수가 자동으롣 ㅗㅇ작해
        Log.d(TAG,"OnReceive() 호출됨 . ");

        Intent myIntent = new Intent(context, MainActivity.class); //컨텍스트는 동작하고있는 것의 주변의 정보이다.
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP); //화면이 없는 상태에서 화면을 띄어주게 하는 | 이미 실행된 화면이면 그걸 해라  flag는 옵션같은거야
        context.startActivity(myIntent);
    }
}
