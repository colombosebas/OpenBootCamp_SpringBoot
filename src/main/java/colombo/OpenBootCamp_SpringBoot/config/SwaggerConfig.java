package colombo.OpenBootCamp_SpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

//http:localhost:8051/swagger-ui/
//Configuración swagger para la generación de documentación de la api rest
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiDetails()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("SpringBoot Laptop API Rest",
                "Library API rest docs",
                "1.0",
                "http://google.com",
                new Contact("Sebastián","http://google.com", "colombosebas@gmail.com"),
                "MIT",
                "http://google.com", Collections.emptyList());
    }
}
