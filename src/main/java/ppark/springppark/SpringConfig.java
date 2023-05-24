package ppark.springppark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ppark.springppark.repository.KcgNonshipAccidentRepository;
import ppark.springppark.service.KcgNonshipAccidentService;

@Configuration
public class SpringConfig {
    private final KcgNonshipAccidentRepository kcgNonshipAccidentRepository;

    @Autowired
    public SpringConfig(KcgNonshipAccidentRepository kcgNonshipAccidentRepository) {
        this.kcgNonshipAccidentRepository = kcgNonshipAccidentRepository;
    }
//    private final JpaKcgNonshipAccidentRepository kcgNonshipAccidentRepository;

//    @Autowired
//    public SpringConfig(JpaKcgNonshipAccidentRepository kcgNonshipAccidentRepository) {
//        this.kcgNonshipAccidentRepository = kcgNonshipAccidentRepository;
//    }

    @Bean //스프링 빈에 등록해라!
    public KcgNonshipAccidentService KcgNonshipAccidentService() {
        return new KcgNonshipAccidentService(kcgNonshipAccidentRepository);
    }
}
