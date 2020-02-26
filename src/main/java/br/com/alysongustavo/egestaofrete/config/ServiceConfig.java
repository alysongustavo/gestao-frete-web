package br.com.alysongustavo.egestaofrete.config;


import br.com.alysongustavo.egestaofrete.service.FreteService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {FreteService.class})
public class ServiceConfig {
}
