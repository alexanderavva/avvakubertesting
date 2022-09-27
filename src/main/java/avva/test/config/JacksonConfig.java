package avva.test.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
/**
 * Конфигурация {@link ObjectMapper}
 */
@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID);
        mapper.registerModule(javaTimeModule());
        mapper.registerModule(new JaxbAnnotationModule());
//        mapper.registerModule(stringModule());
        return mapper;
    }

    private Module javaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
 //      module.addDeserializer(LocalDate.class, new LocalDateJsonDeserializer());
//        module.addDeserializer(LocalTime.class, new LocalTimeJsonDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeJsonDeserializer());
        return module;
    }
//
//    // treat empty strings as null
//    private Module stringModule() {
//        SimpleModule module = new SimpleModule("StringModule", Version.unknownVersion());
//        module.addDeserializer(String.class, new StringJsonDeserializer());
//        return module;
//    }
}
