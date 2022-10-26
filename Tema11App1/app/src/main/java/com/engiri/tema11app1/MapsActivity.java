package com.engiri.tema11app1;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.engiri.tema11app1.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private int operacion;

    private LatLng iesSimarro = new LatLng(38.986, -0.532944);
    private LatLng fpCheste = new LatLng(39.476488, -0.648207);
    private LatLng hamburgueseria = new LatLng(39.478992, -0.426408);

    private PolylineOptions POLILINEA = new PolylineOptions()
            .add(iesSimarro)
            .add(new LatLng(39.482039, -0.422245))
            .add(new LatLng(39.481244, -0.422760))
            .add(new LatLng(39.478858, -0.424340))
            .add(new LatLng(39.478352, -0.424717))
            .add(new LatLng(39.478418, -0.425030))
            .add(new LatLng(39.478762, -0.425824))
            .add(new LatLng(39.479084, -0.426598))
            .add(new LatLng(39.479337, -0.427238))
            .add(new LatLng(39.479367, -0.427436))
            .add(new LatLng(39.479287, -0.427600))
            .add(new LatLng(39.479145, -0.427570))
            .add(new LatLng(39.479061, -0.427397))
            .add(new LatLng(39.479095, -0.427119))
            .add(new LatLng(39.479080, -0.426925))
            .add(new LatLng(39.479000, -0.426538))
            .add(new LatLng(39.478808, -0.426067))
            .add(new LatLng(39.478609, -0.425992))
            .add(new LatLng(39.478544, -0.425843))
            .add(new LatLng(39.478406, -0.425858));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle extras = getIntent().getExtras();
        operacion = extras.getInt("operacion");
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        switch (operacion) {
            case 0:
                // No hacemos nada, abrimos el mapa de forma general sin información
                break;
            case 1:
                // Nos situamos en la ubicación actual
                ubicacionActual();
                break;
            case 2:
                setMarker(iesSimarro,"IES Simarro","Se encuentra en Xativa");
                setMarker(fpCheste,"CIPFP Cheste","Se encuentra en Cheste");
                break;
            case 3:
                setMarker(iesSimarro,"IES Simarro","Se encuentra en Xativa ");
                setMarker(hamburgueseria,"McDonals","Se encuentra en Mislata");
                setPolilyne(POLILINEA);
                break;
        }
    }

    // Nos posicionamos en la ubicación actual
    private void ubicacionActual() {
        //Seteamos el tipo de mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //Activamos la capa o layer MyLocation
        mMap.setMyLocationEnabled(true);
    }

    // Método que nos permite crear marcadores
    private void setMarker(LatLng position, String titulo, String info) {

        // Agregamos marcadores para indicar sitios de interés
        Marker myMaker = mMap.addMarker(new MarkerOptions()
                .position(position)
                .title(titulo)  // Agrega un título al marcador
                .snippet(info)  // Agrega información detalle relacionada
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))); //Color del marcador
    }

    // Método que añade la polilínea al mapa
    private void setPolilyne(PolylineOptions options){
        Polyline polyline = mMap.addPolyline(options);
    }

}