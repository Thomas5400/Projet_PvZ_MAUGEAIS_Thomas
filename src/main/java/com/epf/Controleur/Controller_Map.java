package com.epf.Controleur;

import com.epf.Controleur.DTO_Map;
import com.epf.Persistance.Map;
import com.epf.Service.Serv_Interface_Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maps")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class Controller_Map {

    @Autowired
    private Serv_Interface_Map servMap;

    @GetMapping
    public List<DTO_Map> getAllMaps() {
        return servMap.getAllMaps().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DTO_Map getMapById(@PathVariable int id) {
        Map map = servMap.getMapById(id);
        return convertToDTO(map);
    }

    @GetMapping("/validation")
    public ResponseEntity<String> validateMap() {
        return ResponseEntity.ok("Maps OK");
    }


    @PostMapping
    public void addMap(@RequestBody DTO_Map dtoMap) {
        servMap.addMap(convertToEntity(dtoMap));
    }

    @PutMapping("/{id}")
    public void updateMap(@PathVariable int id, @RequestBody DTO_Map dtoMap) {
        dtoMap.setId_map(id);
        servMap.updateMap(convertToEntity(dtoMap));
    }

    @DeleteMapping("/{id}")
    public void deleteMap(@PathVariable int id) {
        servMap.deleteMap(id);
    }

    private DTO_Map convertToDTO(Map map) {
        return new DTO_Map(map.getId_map(), map.getChemin_image(), map.getLigne(), map.getColonne());
    }

    private Map convertToEntity(DTO_Map dto) {
        return new Map(dto.getId_map(), dto.getChemin_image(), dto.getLigne(), dto.getColonne());
    }
}
