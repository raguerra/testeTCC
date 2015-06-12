package br.com.tcc.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.tcc.dao.GraficoQuantidadeTipoManutencaoDao;

@Named
@RequestScoped
public class GraficoQuantidadeTipoManutencaoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GraficoQuantidadeTipoManutencaoDao dao;
	
	private LineChartModel animatedModel;
	
	@PostConstruct
	public void init(){
		createAnimatedModels();
	}
	
	public LineChartModel getAnimatedModel(){
		return animatedModel;
	}
	
	private void createAnimatedModels(){
		animatedModel = initLinearModel();
        animatedModel.setTitle("Line Chart");
        animatedModel.setAnimate(true);
        animatedModel.setLegendPosition("se");
        Axis yAxis = animatedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(dao.totalManutencao());
        Axis xAxis = animatedModel.getAxis(AxisType.X);
        
	}

	private LineChartModel initLinearModel() {
		
		LineChartModel model = new LineChartModel();
		
		LineChartSeries preventiva = new LineChartSeries();
		preventiva.setLabel("Preventiva");
		
		LineChartSeries corretiva = new LineChartSeries();
		corretiva.setLabel("Corretiva");
		
		LineChartSeries preditiva = new LineChartSeries();
		preditiva.setLabel("Preditiva");
		
		
		model.addSeries(preventiva);
		model.addSeries(corretiva);
		model.addSeries(preditiva);
		
		return model;
	}

}
