package br.com.alysongustavo.egestaofrete.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_shippingcompany")
public class ShippingCompany {

    @Id
    @SequenceGenerator(name="seq_shippingcompany_id",
            sequenceName="seq_shippingcompany_id",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seq_shippingcompany_id")
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "shippingCompany")
    private List<ShippingCompanyInformation> shippingCompanyInformations = new ArrayList<>();

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

    public List<ShippingCompanyInformation> getShippingCompanyInformations() {
        return shippingCompanyInformations;
    }

}
