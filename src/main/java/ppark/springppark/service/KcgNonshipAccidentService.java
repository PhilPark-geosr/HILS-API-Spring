package ppark.springppark.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ppark.springppark.repository.KcgNonshipAccidentRepository;

import java.io.IOException;
import java.util.*;

@Transactional
public class KcgNonshipAccidentService {

    private final KcgNonshipAccidentRepository kcgNonshipAccidentRepository;

    @Autowired
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
        elem.put("properties", new HashMap<Object, Object>());
        elem.put("geometry", null);


        for (String s: geoJSONList) {
            JSONObject json = new JSONObject(String.valueOf(s)); // 받아온 string을 json 으로로 변환
//            System.out.println("json " + json);
            Map<String, Object> mapFromJsonObject = getMapFromJsonObject(json);
            elem.put("geometry", mapFromJsonObject);
            resultlist.add(elem);

        }
        json_form.put("features", resultlist);
//        System.out.println(json_form);
        return json_form;
    }
    public static Map<String, Object> getMapFromJsonObject(JSONObject jsonObj){
        Map<String, Object> map = null;

        try {
            map = new ObjectMapper().readValue(jsonObj.toString(), Map.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

}

