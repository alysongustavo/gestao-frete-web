package br.com.alysongustavo.egestaofrete.init;

import br.com.alysongustavo.egestaofrete.config.JpaConfig;
import br.com.alysongustavo.egestaofrete.config.ServiceConfig;
import br.com.alysongustavo.egestaofrete.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{JpaConfig.class, ServiceConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
