package com.example.md_nayeem_asha.smsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener
{
    private CardView LoveCardView,SadCardView,EidCardView,PujaCardView,GdMrnCardView,GdNightCardView,RamadanCardView,SarodioCardView,EkusCardView,SadinotaCardView;

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Bandla Sms App");

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Floating Button
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Id Find
        LoveCardView = findViewById(R.id.LoveCardViewID);
        SadCardView = findViewById(R.id.SadCardViewID);
        EidCardView = findViewById(R.id.EidCardViewID);
        PujaCardView = findViewById(R.id.PujaCardViewID);
        GdMrnCardView = findViewById(R.id.MorningCardViewID);
        GdNightCardView = findViewById(R.id.NightCardViewID);
        RamadanCardView = findViewById(R.id.RamaCardViewID);
        SarodioCardView = findViewById(R.id.SarodioCardViewID);
        EkusCardView = findViewById(R.id.ekusCardViewID);
        SadinotaCardView = findViewById(R.id.SadinotaCardViewID);


        //Set Onclick Listener
        LoveCardView.setOnClickListener(this);
        SadCardView.setOnClickListener(this);
        EidCardView.setOnClickListener(this);
        PujaCardView.setOnClickListener(this);
        GdMrnCardView.setOnClickListener(this);
        GdNightCardView.setOnClickListener(this);
        RamadanCardView.setOnClickListener(this);
        SarodioCardView.setOnClickListener(this);
        EkusCardView.setOnClickListener(this);
        SadinotaCardView.setOnClickListener(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7101518284791547/9825730778");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

    }

    public void showInterstitialAd(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            showInterstitialAd();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.nav_love)
        {
            // Handle the camera action
            Toast.makeText(this, "Long press to copy any sms", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoveSms.class));
        }
        else if (id == R.id.nav_sad)
        {
            Toast.makeText(this, "Long press to copy any sms", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SadSms.class));
        }
        else if (id == R.id.nav_morning)
        {
            Toast.makeText(this, "Long press to copy any sms", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MorningSms.class));
        }
        else if (id == R.id.nav_night)
        {
            Toast.makeText(this, "Long press to copy any sms", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, NightSms.class));
        }
        else if (id == R.id.nav_eid)
        {
            Toast.makeText(this, "Long press to copy any sms", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, EidSms.class));
        }
        else if (id == R.id.nav_puja)
        {
            Toast.makeText(this, "Long press to copy any sms", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, PujaSms.class));
        }
        else if (id == R.id.nav_ramadan)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, RamadanSms.class));
        }
        else if (id == R.id.nav_sarodio)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SarodioSms.class));
        }
        else if (id == R.id.nav_ekus)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, EkuserSms.class));
        }
        else if (id == R.id.nav_sarodio)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ShadinotarSms.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.LoveCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoveSms.class));
        }
        else if (v.getId() == R.id.SadCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SadSms.class));
        }
        else if (v.getId() == R.id.MorningCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MorningSms.class));
        }
        else if (v.getId() == R.id.NightCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, NightSms.class));
        }
        else if (v.getId() == R.id.EidCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, EidSms.class));
        }
        else if (v.getId() == R.id.PujaCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, PujaSms.class));
        }
        else if (v.getId() == R.id.RamaCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, RamadanSms.class));
        }
        else if (v.getId() == R.id.SarodioCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SarodioSms.class));
        }
        else if (v.getId() == R.id.ekusCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, EkuserSms.class));
        }
        else if (v.getId() == R.id.SadinotaCardViewID)
        {
            Toast.makeText(this, "Long press to copy any sms" , Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ShadinotarSms.class));
        }
    }
}
