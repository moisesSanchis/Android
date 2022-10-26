package com.engiri.tema11app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DrawerBuilder().withActivity(this).build();

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.ic_launcher)
                .addProfiles(
                        new ProfileDrawerItem()
                        .withName("myMapas v1.0").withEmail("mymapas@mapas.com")
                        .withIcon(getResources().getDrawable(
                                R.mipmap.ic_launcher_round, getTheme()))
                )
                .build();

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withIdentifier(1).withName("Opción 1"),
                        new PrimaryDrawerItem().withIdentifier(2).withName("Opción 2"),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withIdentifier(3).withName("Cerrar menú"),
                        new SecondaryDrawerItem().withIdentifier(4).withName("Salir App")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int) drawerItem.getIdentifier()) {
                            case 1:
                                Toast.makeText(MainActivity.this,"Opción 1 pulsada",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(MainActivity.this, "Opción 2 pulsada",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                break;
                                case 4:
                                finish();
                                break;
                        }

                        mDrawer.closeDrawer();
                        return true;
                    }
                }).build();
    }
}