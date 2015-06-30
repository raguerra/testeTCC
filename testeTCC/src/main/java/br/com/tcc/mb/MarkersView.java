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
        LatLng coord1 = new LatLng(-23.2914953, -45.9585716);
        LatLng coord2 = new LatLng(-23.3018888, -45.9626905);
        LatLng coord3 = new LatLng(-23.304161, -45.962347);
        LatLng coord4 = new LatLng(-23.303395, -45.961120);
        LatLng coord5 = new LatLng(-23.2914955, -45.9585718);
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "WallMart"));
        simpleModel.addOverlay(new Marker(coord2, "Maktub"));
        simpleModel.addOverlay(new Marker(coord3, "Shopping Jacareí"));
        simpleModel.addOverlay(new Marker(coord4, "ETEP"));
        simpleModel.addOverlay(new Marker(coord5, "WallMart - Retorno"));
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}