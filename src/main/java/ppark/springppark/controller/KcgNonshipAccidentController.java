package ppark.springppark.controller;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import org.locationtech.jts.io.WKBReader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ppark.springppark.domain.KcgNonshipAccident;
import ppark.springppark.repository.KcgNonshipAccidentRepository;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBWriter;

import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//@RestController
//@RequestMapping("/api/accidents")
//public class KcgNonshipAccidentController {
//    private final KcgNonshipAccidentRepository accidentRepository;
//
//    @Autowired
//    public KcgNonshipAccidentController(KcgNonshipAccidentRepository accidentRepository) {
//        this.accidentRepository = accidentRepository;
//    }
//
//    @GetMapping
//    public List<KcgNonshipAccident> getAccidents() {
//        List<KcgNonshipAccident> all = accidentRepository.findAll();
//        for (KcgNonshipAccident elem:all
//             ) {
//            System.out.println("myelem" + elem.getGeometry());
//
//        }
//        return all;
//    }
//}
@RestController
@RequestMapping("/api/geo-entities")
public class KcgNonshipAccidentController {
    private final KcgNonshipAccidentRepository geoEntityRepository;
    private final ObjectMapper objectMapper;

    public KcgNonshipAccidentController(KcgNonshipAccidentRepository geoEntityRepository, ObjectMapper objectMapper) {
        this.geoEntityRepository = geoEntityRepository;
        this.objectMapper = objectMapper.registerModule(new JtsModule());
    }

    @GetMapping
    public List<byte[]> getAllGeoEntitiesAsWkb() {
        List<KcgNonshipAccident> geoEntities = geoEntityRepository.findAll();
        WKBWriter wkbWriter = new WKBWriter();

        return geoEntities.stream()
                .map(entity -> {
                    byte[] geometry = entity.getGeometry();

                    return geometry;
                })
                .collect(Collectors.toList());
    }
}
//    @GetMapping
//    public List<Geometry> getAllGeoEntitiesAsGeometry() {
//        List<KcgNonshipAccident> geoEntities = geoEntityRepository.findAll();
//        WKBReader wkbReader = new WKBReader();
//
//        return geoEntities.stream()
//                .map(entity -> {
//                    byte[] geometryData = entity.getGeometry();
//
//                    try {
//                        Geometry geometry = wkbReader.read(geometryData);
//                        return geometry;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        return null;
//                    }
//                })
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//    }
//}
//    @GetMapping
//    public List<String> getAllGeoEntitiesAsGeoJson() {
//        List<KcgNonshipAccident> geoEntities = geoEntityRepository.findAll();
//
//        return geoEntities.stream()
//                .map(entity -> {
//                    byte[] wkb = entity.getGeometry();
//                    Geometry geometry = wkbToGeometry(wkb);
//                    String geoJson = geometryToGeoJson(geometry);
//                    return geoJson;
//                })
//                .collect(Collectors.toList());
//    }

//    @GetMapping
//    public List<String> getAllGeoEntitiesAsGeoJson() {
//        List<KcgNonshipAccident> geoEntities = geoEntityRepository.findAll();
//
//        return geoEntities.stream()
//                .map(entity -> {
//                    byte[] wkb = entity.getGeometry();
//                    Geometry geometry = wkbToGeometry(wkb);
//                    String geoJson = geometryToGeoJson(geometry);
//                    return geoJson;
//                })
//                .collect(Collectors.toList());
//    }
//    private Geometry wkbToGeometry(byte[] wkb) {
//        Geometry geometry = null;
//        try {
//            WKBReader wkbReader = new WKBReader();
//            geometry = wkbReader.read(wkb);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return geometry;
//    }
//
//    private String geometryToGeoJson(Geometry geometry) {
//        String geoJson = null;
//        try {
//            geoJson = objectMapper.writeValueAsString(geometry);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return geoJson;
//    }
