package com.jinternal.employee.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

@Configuration
public class EmployeeConfiguration {

    public static final String  DATE_TIME_FORMAT = "yyyy-MM-dd";


    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(ofPattern(DATE_TIME_FORMAT)));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(ofPattern(DATE_TIME_FORMAT)));
        mapper.registerModule(module);
        return mapper;
    }

}
