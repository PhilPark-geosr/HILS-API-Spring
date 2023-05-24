package ppark.springppark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ppark.springppark.service.KcgNonshipAccidentService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/characteristic")
@Controller
public class JpaKcgNonshipAccidentController {

    private final KcgNonshipAccidentService kcgNonshipAccidentService;

    @Autowired // spring bean 에 찾아서 등록
    public JpaKcgNonshipAccidentController(KcgNonshipAccidentService kcgNonshipAccidentService) {
        this.kcgNonshipAccidentService = kcgNonshipAccidentService;
    }

//    private final KcgNonshipAccidentRepository repository;
//
//    @Autowired
//    public JpaKcgNonshipAccidentController(KcgNonshipAccidentRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping("/KcgNonshipAccident")
    public ResponseEntity<HashMap<String, Object>> getGeoJSON() {
//    public ResponseEntity<List<String> getGeoJSON() // for List response
//        List<String> Result = kcgNonshipAccidentService.getGeoJSON();
        HashMap<String, Object> Result = kcgNonshipAccidentService.getGeoJSON();
        return ResponseEntity.ok(Result);
    }
}