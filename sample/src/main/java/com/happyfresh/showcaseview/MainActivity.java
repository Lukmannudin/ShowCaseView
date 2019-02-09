package com.happyfresh.showcaseview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.happyfresh.showcase.GuideView;
import com.happyfresh.showcase.config.AlignType;
import com.happyfresh.showcase.listener.GuideListener;

public class MainActivity extends AppCompatActivity {

    private GuideView mGuideView;
    private GuideView.Builder builder;
    private Button myButton;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.my_button);
        showCoachLayout();
    }

    private void showCoachLayout() {
        builder = new GuideView.Builder(this)
                .setTitle("Kami butuh alamatmu")
                .setContentText("Untuk memastikan alamat pengantaran berada dalam jangkauan HappyFresh")
                .setViewAlign(AlignType.center)
                .setTitleGravity(Gravity.LEFT)
                .setContentGravity(Gravity.LEFT)
                .setButtonGravity(Gravity.RIGHT)
                .setPaddingTitle(50,10,40,10)
                .setPaddingMessage(50,10,40,10)
                .setPaddingButton(0,10,40,10)
                .setButtonText("OK")
                .setTargetView(myButton)
                .setGuideListener(new GuideListener() {
                    @Override
                    public void onDismiss(View view) {
                       Log.d(TAG,"Success");
                    }
                });

        mGuideView = builder.build();
        mGuideView.show();

    }
}
