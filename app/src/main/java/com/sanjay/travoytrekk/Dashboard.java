package com.sanjay.travoytrekk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton home,gallery,offers,rainbowplans;
    ImageView facebook, whatsapp;

    public void openWhatsappContact(String number) {
        Uri uri = Uri.parse("smsto:" + number);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(i, ""));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ImageButton home = findViewById(R.id.imageButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        ImageButton gallery = findViewById(R.id.imageButton2);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(), Dashboard.class);
                startActivity(i);
            }
        });
        ImageView facebook = findViewById(R.id.facebook_button);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                try {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + "1609098012470183"));
                    startActivity(intent);
                } catch (Exception e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + "1609098012470183"));
                    startActivity(intent);
                }
            }
        });
        ImageView whatsapp = findViewById(R.id.whatsapp_button);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsappContact("9989015918");
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_offers) {
            Intent i = new Intent(this, Pre_launch_offer.class);
            startActivity(i);

        } else if (id == R.id.nav_rainbowplan) {
            Intent i = new Intent(this, Rainbow_plan.class);
            startActivity(i);

        } else if (id == R.id.nav_share) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_send) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
