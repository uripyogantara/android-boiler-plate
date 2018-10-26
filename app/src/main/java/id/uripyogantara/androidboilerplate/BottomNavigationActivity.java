package id.uripyogantara.androidboilerplate;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import id.uripyogantara.androidboilerplate.fragment.home.HomeFragment;
import id.uripyogantara.androidboilerplate.fragment.profil.ProfilFragment;
import id.uripyogantara.androidboilerplate.fragment.tab.TabFragment;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationViewEx bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        bnv=findViewById(R.id.bnv);

        setUpBnv();
        setFragment(new HomeFragment());
    }

    private void setUpBnv(){
        bnv.enableAnimation(false);
        bnv.enableShiftingMode(false);
        bnv.enableItemShiftingMode(false);
        bnv.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_home:
                setFragment(new HomeFragment());
                break;
            case R.id.menu_profil:
                setFragment(new ProfilFragment());
                break;
            case R.id.menu_notif:
                setFragment(new TabFragment());
                break;
        }
        return true;
    }

    private void setFragment(Fragment fragment){
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.fl_container,fragment)
                .commit();
    }
}
