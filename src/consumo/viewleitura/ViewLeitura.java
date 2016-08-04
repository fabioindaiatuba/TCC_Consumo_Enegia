package consumo.viewleitura;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;

import consumo.equipamento.Equipamento;
import consumo.local.Local;

@Entity
@Table(name="viewleitura")
public class ViewLeitura implements Serializable {

	@Id
	@Column(name="codigo")
	private Integer viewleitura;
	
	@ManyToOne
	@JoinColumn(name = "local", nullable = false)
	private Local local;
	
	@ManyToOne
	@JoinColumn(name = "equipamento", nullable = false)
	private Equipamento equipamento;
	
	@Column(name="descricao")
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	
	@Column(precision = 10, scale = 6)
	private BigDecimal leitura_kwh;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal tensao;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal potencia_max;
	
	@Column(precision = 10, scale = 6)
	private BigDecimal corrente;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal potencia;
	
	@Column(precision = 10, scale = 0)
	private BigDecimal dia1;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal media1;
	
	@Column(precision = 10, scale = 0)
	private BigDecimal dia2;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal media2;
	
	@Column(precision = 10, scale = 0)
	private BigDecimal dia3;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal media3;
	
	@Column(precision = 10, scale = 0)
	private BigDecimal dia4;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal media4;
	
	@Column(precision = 10, scale = 0)
	private BigDecimal dia5;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal media5;
	
	@Transient
	private MeterGaugeChartModel meterAtual;
	
	@Transient
	private CartesianChartModel  graficoAtual;
	
	
	public Integer getViewleitura() {
		return viewleitura;
	}

	public Local getLocal() {
		return local;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getData() {
		return data;
	}

	public BigDecimal getLeitura_kwh() {
		return leitura_kwh;
	}

	public BigDecimal getTensao() {
		return tensao;
	}

	public BigDecimal getPotencia_max() {
		return potencia_max;
	}

	public BigDecimal getCorrente() {
		return corrente;
	}

	public BigDecimal getPotencia() {
		return potencia;
	}

	public MeterGaugeChartModel getMeterAtual() {
		
		final BigDecimal valor1 = potencia_max.multiply(new BigDecimal(0.5));
		final BigDecimal valor2 = potencia_max.multiply(new BigDecimal(0.85));
		final BigDecimal valor3 = potencia_max.multiply(new BigDecimal(1.1));
		
		List<Number> intervals = new ArrayList<Number>() {
			{
				add(valor1.setScale(2,RoundingMode.HALF_UP));
				add(valor2.setScale(2,RoundingMode.HALF_UP));
				add(valor3.setScale(2,RoundingMode.HALF_UP));
			}
		};
		
		if (this.potencia.compareTo(this.potencia_max) == 1){
			return new MeterGaugeChartModel(this.potencia_max, intervals);
		} else {
			return new MeterGaugeChartModel(this.potencia, intervals);
		}
	}

	public void setMeterAtual(MeterGaugeChartModel meterAtual) {
		this.meterAtual = meterAtual;
	}
	
	public CartesianChartModel getGraficoAtual() {
		
		CartesianChartModel linearModel = new CartesianChartModel();  
		  
		ChartSeries series1 = new ChartSeries();  
	    series1.setLabel(descricao);  
	    
	    series1.set(dia5, media5.multiply(tensao).setScale(0,RoundingMode.HALF_UP));  
	    series1.set(dia4, media4.multiply(tensao).setScale(0,RoundingMode.HALF_UP));  
	    series1.set(dia3, media3.multiply(tensao).setScale(0,RoundingMode.HALF_UP));  
	    series1.set(dia2, media2.multiply(tensao).setScale(0,RoundingMode.HALF_UP));  
	    series1.set(dia1, media1.multiply(tensao).setScale(0,RoundingMode.HALF_UP));  
	    linearModel.addSeries(series1);
	    
	    return linearModel;
	}

	public void setGraficoAtual(CartesianChartModel graficoAtual) {
		this.graficoAtual = graficoAtual;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((corrente == null) ? 0 : corrente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((equipamento == null) ? 0 : equipamento.hashCode());
		result = prime * result
				+ ((leitura_kwh == null) ? 0 : leitura_kwh.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result
				+ ((meterAtual == null) ? 0 : meterAtual.hashCode());
		result = prime * result
				+ ((potencia == null) ? 0 : potencia.hashCode());
		result = prime * result
				+ ((potencia_max == null) ? 0 : potencia_max.hashCode());
		result = prime * result + ((tensao == null) ? 0 : tensao.hashCode());
		result = prime * result
				+ ((viewleitura == null) ? 0 : viewleitura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewLeitura other = (ViewLeitura) obj;
		if (corrente == null) {
			if (other.corrente != null)
				return false;
		} else if (!corrente.equals(other.corrente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (equipamento == null) {
			if (other.equipamento != null)
				return false;
		} else if (!equipamento.equals(other.equipamento))
			return false;
		if (leitura_kwh == null) {
			if (other.leitura_kwh != null)
				return false;
		} else if (!leitura_kwh.equals(other.leitura_kwh))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (meterAtual == null) {
			if (other.meterAtual != null)
				return false;
		} else if (!meterAtual.equals(other.meterAtual))
			return false;
		if (potencia == null) {
			if (other.potencia != null)
				return false;
		} else if (!potencia.equals(other.potencia))
			return false;
		if (potencia_max == null) {
			if (other.potencia_max != null)
				return false;
		} else if (!potencia_max.equals(other.potencia_max))
			return false;
		if (tensao == null) {
			if (other.tensao != null)
				return false;
		} else if (!tensao.equals(other.tensao))
			return false;
		if (viewleitura == null) {
			if (other.viewleitura != null)
				return false;
		} else if (!viewleitura.equals(other.viewleitura))
			return false;
		return true;
	}

	
	
}
