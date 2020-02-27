package br.com.alysongustavo.egestaofrete.controller;

import br.com.alysongustavo.egestaofrete.domain.ShippingCompanyInformation;
import br.com.alysongustavo.egestaofrete.filter.OrcamentoFilter;
import br.com.alysongustavo.egestaofrete.service.ShippingCompanyInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/frete")
public class FreteController {

    @Autowired
    private ShippingCompanyInformationService shippingCompanyInformationService;

    @RequestMapping("/index")
    public ModelAndView index(OrcamentoFilter orcamentoFilter, BindingResult result){

        ModelAndView modelAndView = new ModelAndView("frete/index");
        List<ShippingCompanyInformation> todas = shippingCompanyInformationService.obterTransporteFilter(orcamentoFilter);
        modelAndView.addObject("transportadoras", (todas == null) ? new ArrayList<ShippingCompanyInformation>() : todas);

        return  modelAndView;

    }

}
