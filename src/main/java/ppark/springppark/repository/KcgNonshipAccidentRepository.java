package ppark.springppark.repository;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ppark.springppark.domain.KcgNonshipAccident;

import java.util.List;



@Repository

public interface KcgNonshipAccidentRepository extends JpaRepository<KcgNonshipAccident, Long> {

    @Query(value = "SELECT ST_AsGeoJSON(geometry) FROM characteristics_accidents.kcg_nonship_accidents", nativeQuery = true)
    List<String> getGeoJSON();
//    String sqlStatement = "SELECT ST_AsGeoJSON(characteristics_accidents.kcg_ship_accidents.geometry) AS \"ST_AsGeoJSON_1\" FROM characteristics_accidents.kcg_ship_accidents";
//    @Query(value = sqlStatement, nativeQuery = true)
//    List<KcgNonshipAccident> findKcgNonshipAccident();

}
