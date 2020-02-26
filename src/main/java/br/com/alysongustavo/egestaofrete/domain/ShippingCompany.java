package br.com.alysongustavo.egestaofrete.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_shippingcompany")
public class ShippingCompany {

    @Id
    @SequenceGenerator(name="seq_shippingcompany_id",
            sequenceName="seq_shippingcompany_id",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seq_shippingcompany_id")
    private Integer id;

    private String name;

    @Column(name = "value_per_km")
    private Double valuePerKm;

    @Column(name = "type_transport")
    private String typeTransport;

    @Column(name = "time_avg_per_km")
    private Integer timeAvgPerKm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
