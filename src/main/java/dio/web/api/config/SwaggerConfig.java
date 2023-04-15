package dio.web.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

    public Contact contato(){
        return new Contact(
                "Alcides Thiago",
                "https://www.alcides.com.br",
                "alcides_thiago@hotmail.com"
        );
    }

    private ApiInfoBuilder informacoesApi(){

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Teste Api - Rest API");
        apiInfoBuilder.description("Exemplo de uma pequena API com Swagger e Rest API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termos de uso: Open Source");
        apiInfoBuilder.license("Licença: Alcides Desenvolvimentos");
        apiInfoBuilder.licenseUrl("https://www.alcides.com.br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }
    @Bean
    public Docket detalheApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select().apis(RequestHandlerSelectors.basePackage("dio.web.api.config"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));


        return docket;
    }
}
