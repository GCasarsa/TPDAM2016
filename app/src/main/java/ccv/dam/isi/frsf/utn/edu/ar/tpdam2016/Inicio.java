package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.TabFixture;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.TabGoleadores;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.TabPosiciones;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.TabTarjetas;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.VerEquiposActivity;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;

public class Inicio extends FragmentActivity implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab_fixture").setIndicator("PARTIDOS"),
                TabFixture.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab_goleadores").setIndicator("GOLEADORES"),
                TabGoleadores.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab_posiciones").setIndicator("POSICIONES"),
                TabPosiciones.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab_tarjetas").setIndicator("TARJETAS"),
                TabTarjetas.class, null);
        //tabHost.canScrollHorizontally(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuOpcionEquipos) {
            Intent intent = new Intent(this, VerEquiposActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menuOpcionInicio) {
            // Handle the camera action
        } else if (id == R.id.menuOpcionCompetencias) {

        } else if (id == R.id.menuOpcionEquipos) {
            Intent intent = new Intent(this, VerEquiposActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.menuOpcionContacto) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}