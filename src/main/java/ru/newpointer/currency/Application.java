package ru.newpointer.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Properties;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        if (args.length == 2) {
            Properties props = System.getProperties();
            props.put("http.proxyHost", args[0]);
            props.put("http.proxyPort", args[1]);
        }
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MappingJackson2HttpMessageConverter jsonConverter() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(BigDecimal.class, new ToStringSerializer());
        module.addSerializer(LocalDate.class, new ToStringSerializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper);
        converter.setPrettyPrint(true);

        return converter;
    }
}