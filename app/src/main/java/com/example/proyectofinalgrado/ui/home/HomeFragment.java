package com.example.proyectofinalgrado.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinalgrado.MainActivity;
import com.example.proyectofinalgrado.R;
import com.example.proyectofinalgrado.chat.ChatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener {

    private HomeViewModel homeViewModel;

    private GoogleMap googleMaps;
    private MapView mapView;
    View root;

    /**
     *Free google maps api doesn't provide markers as shown in
     * Maps app so for Testing the app we must create some markers.
     * Consider also that paid maps api follows the same params as free api.
     * So if we change the api the integration should works fine.
     */

    private Marker marker1;
    private Marker marker2;
    private Marker marker3;
    private Marker marker4;
    private Marker marker5;
    private Marker marker6;
    private Marker marker7;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        super.onCreateView(inflater, container, savedInstanceState);
        root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) root.findViewById(R.id.mapView);
        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this::onMapReady);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        googleMaps = googleMap;
        googleMaps.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        initializeMarkers(googleMap);
        //googleMaps.setOnMarkerClickListener(this);
        googleMaps.setOnInfoWindowClickListener(this);
        googleMaps.setOnMarkerClickListener(this);
        CameraPosition defaultPosition = CameraPosition.builder().target(new LatLng(40.04253781066574, -6.087924015453656)).zoom(16).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(defaultPosition));
    }

    private void initializeMarkers(GoogleMap googleMap){
        marker1 = googleMap.addMarker(new MarkerOptions().position(new LatLng(40.04253781066574, -6.087924015453656)).title("Marcador 1"));
        marker2 = googleMap.addMarker(new MarkerOptions().position(new LatLng(40.040667280077784, -6.08623511609299)).title("Marcador 2"));
        marker3 = googleMap.addMarker(new MarkerOptions().position(new LatLng(40.039692336944505, -6.082462737128786)).title("Marcador 3"));
        marker4 = googleMap.addMarker(new MarkerOptions().position(new LatLng(40.040998728095666, -6.078210665184567)).title("Marcador 4"));
        marker5 = googleMap.addMarker(new MarkerOptions().position(new LatLng(40.03733049431723, -6.082032158901517)).title("Marcador 5"));
        marker6 = googleMap.addMarker(new MarkerOptions().position(new LatLng(40.035640149117015, -6.084233757240491)).title("Marcador 6"));
        marker7 = googleMap.addMarker(new MarkerOptions().position(new LatLng(40.033018688563985, -6.080353863350438)).title("Marcador 7"));
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intentChat = new Intent(this.getActivity(), ChatActivity.class);
        startActivity(intentChat);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent intentChat = new Intent(this.getActivity(),ChatActivity.class);
        startActivity(intentChat);
        return false;
    }
}