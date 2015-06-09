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

import br.com.tcc.dao.Grafico1Dao;

@Named
@RequestScoped
public class GraficoAtivoInativoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Grafico1Dao grafico1Dao;

	private BarChartModel animatedModel;

	@PostConstruct
	public void init() {
		createAnimatedModels();
	}

	public BarChartModel getAnimatedModel() {
		return animatedModel;
	}

	private void createAnimatedModels() {

		animatedModel = getRelatorioQuantidadePorCarro();
		animatedModel.setTitle("Quantidade de Carros");
		animatedModel.setAnimate(true);
		animatedModel.setLegendPosition("ne");
		Axis yAxis = animatedModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(grafico1Dao.getQuantidadeTotal());

	}

	private BarChartModel getRelatorioQuantidadePorCarro() {

		BarChartModel model = new BarChartModel();

		ChartSeries ativo = new ChartSeries();
		ativo.setLabel("Carros na Garagem");
		ativo.set("Carros", grafico1Dao.quantidadeA());

		ChartSeries inativo = new ChartSeries();
		inativo.setLabel("Carros na Vendidos");
		inativo.set("Carros", grafico1Dao.quantidadeI());

		model.addSeries(inativo);
		model.addSeries(ativo);

		return model;
	}

}
