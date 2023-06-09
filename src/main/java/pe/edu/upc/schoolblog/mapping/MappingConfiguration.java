package pe.edu.upc.schoolblog.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public MarkMapper markMapper() {
        return new MarkMapper();
    }
}