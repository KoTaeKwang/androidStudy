package com.example.rhxorhkd.mypagesliding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout slidingpanel;
    Button button;
    Animation translate_leftAnim;
    Animation translate_rightAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translate_leftAnim = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        translate_rightAnim = AnimationUtils.loadAnimation(this,R.anim.translate_right);

        translate_leftAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { //에니메이션이 시작할 때

            }
            @Override
            public void onAnimationEnd(Animation animation) { //에니메이션이 끝날 때
                button.setText("Close");
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        slidingpanel = (LinearLayout) findViewById(R.id.slidingPanel);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingpanel.setVisibility(View.VISIBLE);
                slidingpanel.startAnimation(translate_leftAnim);
            }
        });
    }
}
