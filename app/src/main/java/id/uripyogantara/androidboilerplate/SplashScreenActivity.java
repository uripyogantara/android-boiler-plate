package id.uripyogantara.androidboilerplate;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.uripyogantara.androidboilerplate.utils.PreferencesHelper;

public class SplashScreenActivity extends AppCompatActivity {
    PreferencesHelper preferencesHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        preferencesHelper=new PreferencesHelper(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
//        kondisi ketika login
                if (preferencesHelper.getLogin()){
                    intent=new Intent(SplashScreenActivity.this,BottomNavigationActivity.class);
                }else {
                    intent=new Intent(SplashScreenActivity.this,BottomNavigationActivity.class);
                }
                startActivity(intent);
            }
        },2000);
    }
}
