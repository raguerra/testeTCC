package br.com.tcc.mb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
public class MarkersView implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private MapModel simpleModel;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(-23.2911, -45.9561);
        LatLng coord2 = new LatLng(-23.3019, -45.9626);
        LatLng coord3 = new LatLng(-23.3019, -45.9626);
        LatLng coord4 = new LatLng(-23.3034, -45.9612);
        LatLng coord5 = new LatLng(-23.2911, -45.9561);
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "WallMart"));
        simpleModel.addOverlay(new Marker(coord2, "Maktub"));
        simpleModel.addOverlay(new Marker(coord3, "Shopping Jacareí"));
        simpleModel.addOverlay(new Marker(coord4, "ETEP"));
        simpleModel.addOverlay(new Marker(coord5, "WallMart"));
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}