package br.com.alysongustavo.egestaofrete.repository;

import br.com.alysongustavo.egestaofrete.domain.ShippingCompanyInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingCompanyInformationRepository extends JpaRepository<ShippingCompanyInformation, Integer> {
}
