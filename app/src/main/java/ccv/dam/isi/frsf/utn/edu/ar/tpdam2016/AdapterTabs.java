package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabDetalle;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabResultados;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabUbicacion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class AdapterTabs extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private static Equipo equipoAPasar;


    public AdapterTabs(FragmentManager fragmentManager, Equipo equipo) {
        super(fragmentManager);
        equipoAPasar = equipo;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return EquipoTabDetalle.newInstance(0, "Detalle", equipoAPasar);
            case 1: return EquipoTabResultados.newInstance(1, "Resultados", equipoAPasar);
            case 2: return EquipoTabUbicacion.newInstance(2, "Estadio", equipoAPasar);
            default:
                return null;
        }
    }
    String[] titulos = { "INFORMACIÓN", "RESULTADOS", "UBICACIÓN"};

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }


}

