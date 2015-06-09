package br.com.tcc.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.tcc.dao.GraficoQuantidadeMotoristaDao;

@Named
@RequestScoped
public class GraficoQuantidadeMotoristaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GraficoQuantidadeMotoristaDao dao;
	
	private BarChartModel animatedModel;
	
	@PostConstruct
	public void init(){
		createAnimatedModels();
	}
	
	public BarChartModel getAnimatedModel(){
		return animatedModel;
	}
	
	private void createAnimatedModels(){
		
		animatedModel = getMotoristaPorCategoria();
		animatedModel.setTitle("Motorista Por Categoria");
		animatedModel.setAnimate(true);
		animatedModel.setLegendPosition("ne");
		Axis yAxis = animatedModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(dao.totalMotorista());
	}
	
	private BarChartModel getMotoristaPorCategoria(){
		
		BarChartModel model = new BarChartModel();
		
		ChartSeries catA = new ChartSeries();
		catA.setLabel("Categoria A");
		catA.set("Motoristas", dao.catA());
		
		ChartSeries catB = new ChartSeries();
		catB.setLabel("Categoria B");
		catB.set("", dao.catB());
		
		ChartSeries catAB = new ChartSeries();
		catAB.setLabel("Categoria AB");
		catAB.set("", dao.catAB());
		
		ChartSeries catC = new ChartSeries();
		catC.setLabel("Categoria C");
		catC.set("", dao.catC());
		
		ChartSeries catD = new ChartSeries();
		catD.setLabel("Categoria D");
		catD.set("", dao.catD());
		
		ChartSeries catE = new ChartSeries();
		catE.setLabel("Categoria E");
		catE.set("", dao.catE());
		
		model.addSeries(catA);
		model.addSeries(catB);
		model.addSeries(catAB);
		model.addSeries(catC);
		model.addSeries(catD);
		model.addSeries(catE);
		
		return model;
	}
	

}
