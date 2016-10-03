package com.example.rhxorhkd.myactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent=getIntent(); //여기에 받은 데이터가 들어있어
        if(intent!=null){
            String title = intent.getStringExtra("title");
            Toast.makeText(getApplicationContext(),"전달받은 값 : "+title,Toast.LENGTH_LONG).show();
        }

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name","티아라");
                setResult(RESULT_OK,intent);

                finish();
            }
        });
    }
}
