package ppark.springppark.controller;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ppark.springppark.domain.KcgNonshipAccident;
import ppark.springppark.repository.JpaKcgNonshipAccidentRepository;
import org.locationtech.jts.io.WKBWriter;

import java.util.List;
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
//    @GetMapping

@RestController
@RequestMapping("/api/geo-entities")
public class KcgNonshipAccidentController_bck {
    private final JpaKcgNonshipAccidentRepository geoEntityRepository;
    private final ObjectMapper objectMapper;

    public KcgNonshipAccidentController_bck(JpaKcgNonshipAccidentRepository geoEntityRepository, ObjectMapper objectMapper) {
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
