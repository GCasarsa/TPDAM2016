package ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.partidos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabDetalle;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabFixture;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabResultados;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Actividades.equipo.EquipoTabUbicacion;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Equipo;
import ccv.dam.isi.frsf.utn.edu.ar.tpdam2016.Entidades.Partido;

/**
 * Created by Gabriel on 29/01/2017.
 */
public class AdapterTabsPartido extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 1;
    private static Partido partidoAPasar;


    public AdapterTabsPartido(FragmentManager fragmentManager, Partido partido) {
        super(fragmentManager);
        partidoAPasar = partido;
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
            case 0: return PartidoTabDetalle.newInstance(0, "Detalle", partidoAPasar);
            /*case 1: return PartidoTabCaraACara.newInstance(1, "Cara a Cara", partidoAPasar);
            case 2: return PartidoTabTabla.newInstance(2, "Próximos Partidos", partidoAPasar);*/
            default:
                return null;
        }
    }
    String[] titulos = { "DETALLE"/*, "CARA A CARA", "TABLA DE POSICIONES"*/};

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return titulos[position];
    }


}

