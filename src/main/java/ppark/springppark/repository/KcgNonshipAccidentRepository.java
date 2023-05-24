package ppark.springppark.repository;

import ppark.springppark.domain.KcgNonshipAccident;
import ppark.springppark.domain.KcgShipAccident;

import java.util.List;
import java.util.Optional;

public interface KcgNonshipAccidentRepository {

//    KcgNonshipAccident save(KcgShipAccident kcgShipAccident);
//    Optional<KcgNonshipAccident> findById(Long id);
//
//    Optional<KcgNonshipAccident> findByName(String name);

    List<String> getGeoJSON();

    //다른 기능들 추가...
}
