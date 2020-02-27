package br.com.alysongustavo.egestaofrete.service;

import br.com.alysongustavo.egestaofrete.domain.ShippingCompany;
import br.com.alysongustavo.egestaofrete.domain.ShippingCompanyInformation;
import br.com.alysongustavo.egestaofrete.filter.OrcamentoFilter;
import br.com.alysongustavo.egestaofrete.repository.ShippingCompanyInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingCompanyInformationService {

    @Autowired
    private ShippingCompanyInformationRepository shippingCompanyInformationRepository;

    public List<ShippingCompanyInformation> obterTransporteFilter(OrcamentoFilter orcamentoFilter){

        if(orcamentoFilter.getOrigem() != null){

            List<ShippingCompanyInformation> shippingCompanyInformations = this.unificateCallDomainShippingCompanyInformation();

            // Removendo objeto pelo tipo de Transporte
            if(orcamentoFilter.getTipoTransporte().equals("A")){
                shippingCompanyInformations.removeIf(m -> m.getTypeTransport().equals("T"));
            }else if(orcamentoFilter.getTipoTransporte().equals("T")){
                shippingCompanyInformations.removeIf(m -> m.getTypeTransport().equals("A"));
            }

            shippingCompanyInformations.forEach(n -> {
                n.setPrecoTotal((orcamentoFilter.getDistancia() * n.getValuePerKm()) / 10);
                n.setTempoTotal(Double.valueOf(orcamentoFilter.getDistancia() * n.getTimeAvgPerKm()));
            });

            if(orcamentoFilter.getPrioridade().equals("1")){

                shippingCompanyInformations.stream()
                        .sorted(Comparator.comparing(ShippingCompanyInformation::getPrecoTotal)).collect(Collectors.toList());

                int b  = 1;

                int todosIguais = 0;

                for(ShippingCompanyInformation s: shippingCompanyInformations){
                    if(s.getPrecoTotal() == shippingCompanyInformations.get(b).getPrecoTotal()){
                        todosIguais = (b - 1);
                        b++;
                    }else{
                        break;
                    }
                }

                if(b == 1){
                    return shippingCompanyInformations.subList(0,1);
                }

                if(shippingCompanyInformations.size() == todosIguais){
                    return shippingCompanyInformations;
                }

                List<ShippingCompanyInformation> novaListaOrder = shippingCompanyInformations.subList(0,b);

                return novaListaOrder.stream()
                        .sorted(Comparator.comparing(ShippingCompanyInformation::getTempoTotal))
                        .collect(Collectors.toList()).subList(0,1);


            }else{

                shippingCompanyInformations.stream()
                        .sorted(Comparator.comparingDouble(ShippingCompanyInformation::getTempoTotal))
                        .collect(Collectors.toList());


                int i  = 1;

                int todosIguais = 0;

                for(ShippingCompanyInformation s: shippingCompanyInformations){
                    if(s.getTempoTotal() == shippingCompanyInformations.get(i).getTempoTotal()){
                        todosIguais = (i - 1);
                        i++;
                    }else{
                        break;
                    }
                }

                if(i == 1){
                    return shippingCompanyInformations.subList(0,1);
                }

                if(shippingCompanyInformations.size() == todosIguais){
                    return shippingCompanyInformations;
                }

                List<ShippingCompanyInformation> novaListaOrder = shippingCompanyInformations.subList(0,i);

                return novaListaOrder.stream()
                        .sorted(Comparator.comparing(ShippingCompanyInformation::getPrecoTotal))
                        .collect(Collectors.toList()).subList(0,1);

            }

        }

        return null;
    }

    public List<ShippingCompanyInformation> todos(){
        return this.shippingCompanyInformationRepository.findAll();
    }

    public List<ShippingCompanyInformation> consumerForAPI(){

        List<ShippingCompanyInformation> shippingCompanyInformations = new ArrayList<>();

        ShippingCompany shippingCompany = new ShippingCompany();
        shippingCompany.setId(200);
        shippingCompany.setName("Transportadora 200");

        ShippingCompanyInformation shippingCompanyInformation = new ShippingCompanyInformation();
        shippingCompanyInformation.setId(1000);
        shippingCompanyInformation.setShippingCompany(shippingCompany);
        shippingCompanyInformation.setPrecoTotal(Double.valueOf(500));
        shippingCompanyInformation.setTempoTotal(Double.valueOf(300));
        shippingCompanyInformation.setTimeAvgPerKm(10);
        shippingCompanyInformation.setTypeTransport("A");

        shippingCompanyInformations.add(shippingCompanyInformation);

        return shippingCompanyInformations;
    }

    public List<ShippingCompanyInformation> unificateCallDomainShippingCompanyInformation(){
        List<ShippingCompanyInformation> shippingCompanyInformationList = this.todos();
        List<ShippingCompanyInformation> shippingCompanyInformationListAPI = this.consumerForAPI();

        shippingCompanyInformationList.addAll(shippingCompanyInformationListAPI);

        return shippingCompanyInformationList;
    }
}
