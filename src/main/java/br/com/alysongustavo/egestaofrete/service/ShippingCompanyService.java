package br.com.alysongustavo.egestaofrete.service;

import br.com.alysongustavo.egestaofrete.domain.ShippingCompany;
import br.com.alysongustavo.egestaofrete.repository.ShippingCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingCompanyService {

    @Autowired
    private ShippingCompanyRepository shippingCompanyRepository;

    public List<ShippingCompany> todas(){
        return shippingCompanyRepository.findAll();
    }
}
