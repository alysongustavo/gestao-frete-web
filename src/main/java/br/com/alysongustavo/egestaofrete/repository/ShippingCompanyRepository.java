package br.com.alysongustavo.egestaofrete.repository;

import br.com.alysongustavo.egestaofrete.domain.ShippingCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Integer> {
}
