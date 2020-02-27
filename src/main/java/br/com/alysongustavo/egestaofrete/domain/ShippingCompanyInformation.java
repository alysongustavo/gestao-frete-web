package br.com.alysongustavo.egestaofrete.domain;

import javax.persistence.*;

@Entity
@Table(name = "tbl_shippingcompany_information")
public class ShippingCompanyInformation {

    @Id
    @SequenceGenerator(name="seq_shippingcompany_information_id",
            sequenceName="seq_shippingcompany_information_id",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seq_shippingcompany_information_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "shippingcompany_id")
    private ShippingCompany shippingCompany;

    @Column(name = "value_per_km")
    private Double valuePerKm;

    @Column(name = "type_transport")
    private String typeTransport;

    @Column(name = "time_avg_per_km")
    private Integer timeAvgPerKm;

    @Transient
    private boolean ehMenorPreco;

    @Transient
    private boolean ehMenorTempo;

    @Transient
    private Double precoTotal;

    @Transient
    private Double tempoTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShippingCompany getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(ShippingCompany shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public Double getValuePerKm() {
        return valuePerKm;
    }

    public void setValuePerKm(Double valuePerKm) {
        this.valuePerKm = valuePerKm;
    }

    public String getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(String typeTransport) {
        this.typeTransport = typeTransport;
    }

    public Integer getTimeAvgPerKm() {
        return timeAvgPerKm;
    }

    public void setTimeAvgPerKm(Integer timeAvgPerKm) {
        this.timeAvgPerKm = timeAvgPerKm;
    }

    public boolean isEhMenorPreco() {
        return ehMenorPreco;
    }

    public void setEhMenorPreco(boolean ehMenorPreco) {
        this.ehMenorPreco = ehMenorPreco;
    }

    public boolean isEhMenorTempo() {
        return ehMenorTempo;
    }

    public void setEhMenorTempo(boolean ehMenorTempo) {
        this.ehMenorTempo = ehMenorTempo;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Double getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(Double tempoTotal) {
        this.tempoTotal = tempoTotal;
    }
}
