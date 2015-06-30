package br.com.tcc.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;

import br.com.tcc.dao.GraficoPizzaGravidadeMultaDao;

@Named
@RequestScoped
public class GraficoPizzaGravidadeMultaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GraficoPizzaGravidadeMultaDao dao;
	
	private PieChartModel pie;
	
	@PostConstruct
	public void init(){
		createPie();
	}
	
	public PieChartModel getPie(){
		return pie;
	}
	
	private void createPie(){
		
		pie = new PieChartModel();
		
		pie.set("GRAVISSIMA", dao.gravissima());
		pie.set("GRAVE", dao.grave());
		pie.set("MEDIA", dao.media());
		pie.set("LEVE", dao.leve());
		
		pie.setTitle("Gravidade de Infração Cometida");
		pie.setLegendPosition("w");
		pie.setShowDataLabels(true);
	}
	
	public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selecionado",
                        "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
