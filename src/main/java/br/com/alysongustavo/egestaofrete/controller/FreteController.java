package br.com.alysongustavo.egestaofrete.controller;

import br.com.alysongustavo.egestaofrete.domain.ShippingCompany;
import br.com.alysongustavo.egestaofrete.service.ShippingCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/frete")
public class FreteController {

    @Autowired
    private ShippingCompanyService shippingCompanyService;

    @RequestMapping("/index")
    public ModelAndView index(){

        List<ShippingCompany> todas = shippingCompanyService.todas();

        todas.forEach(m -> System.out.println(m.getName()));

        ModelAndView modelAndView = new ModelAndView("frete/index");
        modelAndView.addObject("shippingCompanies", todas);
        return  modelAndView;

    }

}
