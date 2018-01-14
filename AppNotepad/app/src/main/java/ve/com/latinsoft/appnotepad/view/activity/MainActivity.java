package ve.com.latinsoft.appnotepad.view.activity;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ve.com.latinsoft.appnotepad.R;
import ve.com.latinsoft.appnotepad.view.fragment.MainFragment;
import ve.com.latinsoft.appnotepad.view.fragment.PendientesFragment;
import ve.com.latinsoft.appnotepad.view.fragment.SuperMercadoFragment;
import ve.com.latinsoft.appnotepad.view.fragment.VacacionesFragment;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    private static boolean press=false;
    Toolbar toolbar;
    NavigationView naviationView;
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        naviationView = (NavigationView) findViewById(R.id.navigationView);

        naviationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if(item.isChecked()){
                    item.setChecked(false);
                }
                else
                {
                    item.setChecked(true);
                }

                drawerLayout.closeDrawers();
                setFragment(item.getItemId());


                return false;

            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };


        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setFragment(R.id.principal);
    }

    private void setFragment(int _Id){
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new Fragment();
        switch(_Id){

            case R.id.principal:
                fragment = new MainFragment();

                Toast.makeText(getApplicationContext(),"Principal",Toast.LENGTH_SHORT);
                break;
            case R.id.supermercado:
                fragment = new SuperMercadoFragment();
                Toast.makeText(getApplicationContext(),"Supermercado",Toast.LENGTH_SHORT);
                break;
            case R.id.pendientes:
                fragment = new PendientesFragment();
                Toast.makeText(getApplicationContext(),"Pendientes",Toast.LENGTH_SHORT);
                break;
            case R.id.vacaciones:
                fragment = new VacacionesFragment();
                Toast.makeText(getApplicationContext(),"Vacaciones",Toast.LENGTH_SHORT);
                break;

            default: break;

        }
        transaction.replace(R.id.fragment,fragment);
        transaction.commit();
    }
}
