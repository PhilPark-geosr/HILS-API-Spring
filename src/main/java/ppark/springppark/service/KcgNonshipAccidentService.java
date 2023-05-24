package ppark.springppark.service;

import org.springframework.transaction.annotation.Transactional;
import ppark.springppark.repository.KcgNonshipAccidentRepository;

import java.util.List;

@Transactional
public class KcgNonshipAccidentService {

    private final KcgNonshipAccidentRepository kcgNonshipAccidentRepository;

    public KcgNonshipAccidentService(KcgNonshipAccidentRepository kcgNonshipAccidentRepository) {
        this.kcgNonshipAccidentRepository = kcgNonshipAccidentRepository;
    }
    // 외부 생성자 주입


//    private final JpaKcgNonshipAccidentRepository kcgNonshipAccidentRepository;
//
//
//    public KcgNonshipAccidentService(JpaKcgNonshipAccidentRepository kcgNonshipAccidentRepository) {
//        this.kcgNonshipAccidentRepository = kcgNonshipAccidentRepository;


    //Geojson 리턴 기능
    public List<String> getGeoJSON() {
        List<String> geoJSONList = kcgNonshipAccidentRepository.getGeoJSON();
        return geoJSONList;
    }

    // 다른 기능 추가...

}
