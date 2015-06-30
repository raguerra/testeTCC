package br.com.tcc.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import br.com.tcc.dao.GraficoQuantidadeTipoManutencaoDao;

@Named
@RequestScoped
public class GraficoQuantidadeTipoManutencaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GraficoQuantidadeTipoManutencaoDao dao;

	private PieChartModel pie;

	@PostConstruct
	public void init() {
		createPie();
	}

	public PieChartModel getPie() {
		return pie;
	}

	private void createPie() {

		pie = new PieChartModel();

		pie.set("PREVENTIVA", dao.preventiva());
		pie.set("CORRETIVA", dao.corretiva());
		pie.set("PREDITIVA", dao.preditiva());

		pie.setTitle("Tipos de Manutenção Realizada");
		pie.setLegendPosition("w");
		pie.setShowDataLabels(true);
	}

}
