package com.example.googlemapsmarcadores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// IMPORTANTE: Incluye en el fichero AndroidManifest.xml tu clave de API de Google Map
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener{

    private GoogleMap mapa;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ***** Ligamos los recursos de la actividad *****
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map)
    {
        mapa = map;
        mapa.setOnMapClickListener(this); // Para capturar el OnClick
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        insertarMarcador(latLng);
    }

    /**
     * Inserta un marcado en un Google Maps
     * @param coordenadas Coordenadas para insertar dicho marcador
     */
    private void insertarMarcador(LatLng coordenadas)
    {
        mapa.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("Marcador"));
    }
}