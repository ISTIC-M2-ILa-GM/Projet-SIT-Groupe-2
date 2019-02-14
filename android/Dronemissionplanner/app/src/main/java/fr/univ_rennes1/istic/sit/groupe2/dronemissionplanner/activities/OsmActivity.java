package fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.activities;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.PathOverlay;
import org.osmdroid.views.overlay.Polyline;

import java.util.LinkedList;
import java.util.List;

import fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.R;


public class OsmActivity extends AppCompatActivity {

    private MapView mMapView;
    private MapController mMapController;
    private final GeoPoint RENNES = new GeoPoint(48.117266, -1.6777926);
    private final GeoPoint ISTIC = new GeoPoint(48.1151495,-1.6383743);
    private final GeoPoint GARE = new GeoPoint(48.1049525,-1.6723698);
    private final GeoPoint STADE = new GeoPoint(48.1083243,-1.7077132);
    private final GeoPoint PISCINE = new GeoPoint(48.1318028,-1.6520706);
    private Marker drone;
    private Polyline line;
    private List<Marker> markers = new LinkedList<>();

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
        mMapView.setTileSource(MAPQUESTOSM);

        updateDronePosition(ISTIC);
        addMarker(PISCINE);
        addMarker(STADE);
        addMarker(GARE);
        showPath(markers);
    }

    /**
     * Définit / update la position du drone.
     *
     * @param position du Marker
     */
    public void updateDronePosition(GeoPoint position) {
        if (drone != null) {
            drone.setPosition(position);
        } else {
            drone = addMarker(position);
            drone.setTitle("Drone");
            Drawable icon = getResources().getDrawable(R.drawable.marker_drone_foreground);
            drone.setIcon(icon);
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
        Drawable icon = getResources().getDrawable(R.drawable.marker_foreground);
        marker.setIcon(icon);
        mMapView.getOverlays().add(marker);
        markers.add(marker);
        return marker;
    }

    public void showPath(List<Marker> markers) {
        line = new Polyline();
        List<GeoPoint> geoPoints = new LinkedList<>();
        for (Marker marker : markers) {
            geoPoints.add(marker.getPosition());
        }
        line.setPoints(geoPoints);
        line.setOnClickListener(new Polyline.OnClickListener() {
            @Override
            public boolean onClick(Polyline polyline, MapView mapView, GeoPoint eventPos) {
                Toast.makeText(mapView.getContext(), "polyline with " + polyline.getPoints().size() + "pts was tapped", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        mMapView.getOverlayManager().add(line);
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
