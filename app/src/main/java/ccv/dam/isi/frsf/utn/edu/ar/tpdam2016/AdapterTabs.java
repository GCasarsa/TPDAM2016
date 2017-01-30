package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabDetalle;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabUbicacion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class AdapterTabs extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;


    public AdapterTabs(FragmentManager fragmentManager) {
        super(fragmentManager);
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
            case 0: // Fragment # 0 - This will show FirstFragment
                return EquipoTabDetalle.newInstance(0, "Detalle");
            case 1: // Fragment # 1 - This will show FirstFragment different title
                return EquipoTabUbicacion.newInstance(1, "Page # 2");

            default:
                return null;
        }
    }
    String[] titulos = { "INFORMACIÓN", "UBICACIÓN"};

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }


}

