package fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.R;


public class OsmActivity extends AppCompatActivity {

    private MapView mMapView;
    private MapController mMapController;
    private final GeoPoint RENNES = new GeoPoint(48.117266, -1.6777926);
    private Marker drone;

    public static final OnlineTileSourceBase MAPQUESTOSM = new XYTileSource("MapquestOSM",
            0, 18, 256, ".png", new String[] {
            "http://otile1.mqcdn.com/tiles/1.0.0/map/",
            "http://otile2.mqcdn.com/tiles/1.0.0/map/",
            "http://otile3.mqcdn.com/tiles/1.0.0/map/",
            "http://otile4.mqcdn.com/tiles/1.0.0/map/" });

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osm);
        mMapView = findViewById(R.id.mapview);
        mMapController = (MapController) mMapView.getController();
        mMapController.setZoom(13);
        mMapController.setCenter(RENNES);
//        ITileSource tileSource = new XYTileSource ("tiles", 0,
//                12, 256, ".png", new String[]{});
        mMapView.setTileSource(MAPQUESTOSM);
    }

    /**
     * Définit / met à jour la position du drone.
     *
     * @param position du Marker
     */
    public void updateDronePosition(GeoPoint position) {
        if (drone != null) {
            drone.setPosition(position);
        } else {
            drone = addMarker(position);
            drone.setTitle("Drone");
            mMapView.getOverlays().add(drone);
        }
    }

    /**
     * Ajoute un Marker à la position spécifiée
     *
     * @param position du Marker
     * @return le marker
     */
    public Marker addMarker(GeoPoint position) {
        Marker marker = new Marker(mMapView);
        marker.setPosition(position);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        mMapView.getOverlays().add(marker);
        return marker;
    }

    @Override
    public void onResume() {
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        mMapView.onResume(); //needed for compass, my location overlays, v6.0.0 and up
    }

    @Override
    public void onPause() {
        super.onPause();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        mMapView.onPause();  //needed for compass, my location overlays, v6.0.0 and up
    }

}
