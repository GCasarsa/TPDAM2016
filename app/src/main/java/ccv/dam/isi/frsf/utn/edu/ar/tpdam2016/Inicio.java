package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.SettingsActivity;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.TabFixture;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.TabGoleadores;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.TabPosiciones;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.TabTarjetas;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.VerEquiposActivity;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoInicio;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarDatos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.CargarEscudos;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Database.Conexion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;

public class Inicio extends FragmentActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference posicionBD;
    ArrayList<Equipo> busqueda;
    ArrayList<String> preferencias;
    NavigationView navigationView;
    SubMenu subMenu;
    int bandera;
    ArrayList<Intent> intentos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FragmentTabHost tabHost;
        SharedPreferences pref;
        busqueda = new ArrayList<>();
        bandera = 0;

        pref = PreferenceManager.getDefaultSharedPreferences(this);

        /*
        * Obtengo los equipos que fueron almacenados como favoritos en las SharedPreferences
        * */
        preferencias = new ArrayList<>();
        for(int i = 1; i <=8; i++){
            if(pref.getBoolean(""+i,false)) preferencias.add(""+i);
        }

        System.out.println("ESTA ONLINEEE::::::" + isOnline());

        if (isOnline()){


            tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
            tabHost.setup(this,getSupportFragmentManager(), android.R.id.tabcontent);
            tabHost.addTab(tabHost.newTabSpec("tab_fixture").setIndicator("", getResources().getDrawable(R.drawable.calendario)),
                    TabFixture.class, null);
            tabHost.addTab(tabHost.newTabSpec("tab_posiciones").setIndicator("", getResources().getDrawable(R.drawable.podio)),
                    TabPosiciones.class, null);
            tabHost.addTab(tabHost.newTabSpec("tab_goleadores").setIndicator("", getResources().getDrawable(R.drawable.pelota)),
                    TabGoleadores.class, null);
            tabHost.addTab(tabHost.newTabSpec("tab_tarjetas").setIndicator("", getResources().getDrawable(R.drawable.tarjetasfutbol)),
                    TabTarjetas.class, null);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.setItemIconTintList(null);

            buscarEquipos();
        }
        else
        {
                AlertDialog alertDialog = new AlertDialog.Builder(Inicio.this).create();

                alertDialog.setTitle("Internet");
                alertDialog.setMessage("Internet no disponible. Active internet y vuelva a intentarlo");
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });;

                alertDialog.show();

        }

    }


    private Toast toast;
    private long lastBackPressTime = 0;

    @Override
    public void onBackPressed() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 3000) {
            toast = Toast.makeText(this, "Presione nuevamente para salir", Toast.LENGTH_LONG);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
                System.exit(0);
            }

        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menuOpcionInicio) {
            // Handle the botonInicio
        }
        else if (id == R.id.menuOpcionEquipos) {
            Intent intent = new Intent(this, VerEquiposActivity.class);
            startActivity(intent);
            finish();
            return true;


        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menuCargarDatos) {

            //CargarDatos.cargarEquipos();
            return true;
        }
        else{
            System.out.println("Id: " + id);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buscarEquipos(){
        posicionBD = database.getReference("datos/equipos/primeradivision");
        posicionBD.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                Map<String, Object> newPost = (Map<String, Object>) snapshot.getValue();
                for(int i = 0; i < preferencias.size(); i++){
                    if(newPost.get("id").toString().equals(preferencias.get(i))) {
                        Equipo equipo = new Equipo(newPost.get("id").toString(),newPost.get("nombre").toString(), newPost.get("escudo").toString(), newPost.get("division").toString());
                        busqueda.add(equipo);
                    }
                }

                if(busqueda.size()==preferencias.size() && bandera == 0){
                    bandera = 1;
                    final Menu menu = navigationView.getMenu();
                    subMenu = menu.addSubMenu("Equipos favoritos");

                    for(int i=0; i <busqueda.size();i++){
                        subMenu.add("" + busqueda.get(i).getNombre());

                        Intent intentEquipo = new Intent(getApplicationContext(), EquipoInicio.class);
                        intentEquipo.putExtra("equipo", Long.parseLong(busqueda.get(i).getId()));

                        intentos.add(intentEquipo);

                        setterListener(subMenu.getItem(i),i,busqueda.get(i));

                    }

                }

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

    }

    private void setterListener(MenuItem itemSubMenu, final int indice, Equipo e) {

        int escudo = CargarEscudos.cargarEscudo(e.getNombre());
        itemSubMenu.setIcon(escudo);
        itemSubMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(intentos.get(indice));
                //listener seteado a cada equipo favorito
                finish();
                return true;
                }
           });

    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }
}