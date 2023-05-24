package ppark.springppark.service;

import org.springframework.transaction.annotation.Transactional;
import ppark.springppark.repository.KcgNonshipAccidentRepository;

import java.util.ArrayList;
import java.util.HashMap;
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
    public HashMap<String, Object> getGeoJSON() {

        // json form 만들기

        // In python
        //        json_form = {
//                "type": "FeatureCollection",
//                "features":[]
//        }
//        for elem in data:
//        # print(coast)
//        json_data['features'].append(
//                {
//                        'type': 'Feature',
//                'properties': {},
//        "geometry" : json.loads(elem[0])
//            }
//        )
        HashMap<String, Object> json_form = new HashMap<>();
//        List<String> resultlist = new ArrayList<>();
        List<HashMap<String, Object>> resultlist = new ArrayList<>();
        json_form.put("type", "FeatureCollection");
        json_form.put("features", resultlist);
//        System.out.println(json_form);

        List<String> geoJSONList = kcgNonshipAccidentRepository.getGeoJSON();
//        System.out.println(geoJSONList.get(0));

        HashMap<String, Object> elem = new HashMap<>();
        elem.put("type", "Feature");
        elem.put("properties", "{}");
        elem.put("geometry", "");
        for (String s: geoJSONList) {
            elem.put("geometry", s);
            resultlist.add(elem);

        }
        json_form.put("features", resultlist);
//        System.out.println(json_form);
        return json_form;
    }

    // 다른 기능 추가...

}
