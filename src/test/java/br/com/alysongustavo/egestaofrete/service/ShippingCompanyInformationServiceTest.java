package br.com.alysongustavo.egestaofrete.service;

import br.com.alysongustavo.egestaofrete.config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class ShippingCompanyInformationServiceTest {

    @Autowired
    private ShippingCompanyInformationService shippingCompanyInformationService;

    @Test
    public void testTemUnicaTransportadoraDesprezandoTipoTransporte() {

    }

    @Test
    public void testTemUnicaTransportadoraComPrioridadePorMenorPreco() {

    }

    @Test
    public void testTemUnicaTransportadoraComPrioridadePorMenorTempo() {

    }

    @Test
    public void testTodasTransportadorasTemPrioridadesIguais() {

    }

}
