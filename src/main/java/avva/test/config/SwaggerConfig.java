package avva.test.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.ArrayList;

@Component
@Configuration
@EnableSwagger2
public class SwaggerConfig /*extends WebSecurityConfigurerAdapter */{
    public static String[] SWAGGER_URL_PATHS = new String[] { "/swagger-ui.html**", "/swagger-resources/**",
            "/v2/api-docs**", "/webjars/**" };

//     @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.requestMatchers().antMatchers(SWAGGER_URL_PATHS).and().authorizeRequests().antMatchers(SWAGGER_URL_PATHS)
//                .permitAll();
//    }

    @Bean
    public Docket api(ServletContext servletContext) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        return (docket)
                .useDefaultResponseMessages(false)
                .select()
                .apis(Predicates.or(RequestHandlerSelectors.basePackage("avva.test")))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
    }

    /**
     * Настройка информации по API
     * @return Настройка информации по API
     */
    protected ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "avva/test",
                "avva/test",
                "1",
                null,
                null,
                null,
                null,
                new ArrayList<>());
        return apiInfo;
    }
}
