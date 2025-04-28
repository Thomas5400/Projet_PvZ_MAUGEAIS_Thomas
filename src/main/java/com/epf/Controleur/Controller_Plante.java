package com.epf.Controleur;

import com.epf.Persistance.Plante;
import com.epf.Service.Serv_Interface_Plantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes") 
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class Controller_Plante {

    @Autowired
    private Serv_Interface_Plantes servPlante;

    @GetMapping
    public List<DTO_Plante> getAllPlantes() {
        return servPlante.getAllPlantes().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DTO_Plante getPlanteById(@PathVariable int id) {
        return convertToDTO(servPlante.getPlanteById(id));
    }

    @GetMapping("/validation")
    public ResponseEntity<String> validatePlante() {
        return ResponseEntity.ok("plante Ok");
    }

    @PostMapping
    public void addPlante(@RequestBody DTO_Plante dto) {
        servPlante.addPlante(convertToEntity(dto));
    }

    @PutMapping("/{id}")
    public void updatePlante(@PathVariable int id, @RequestBody DTO_Plante dto) {
        dto.setId_plante(id);
        servPlante.updatePlante(convertToEntity(dto));
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable int id) {
        servPlante.deletePlante(id);
    }

    private DTO_Plante convertToDTO(Plante plante) {
        return new DTO_Plante(
                plante.getId_plante(),
                plante.getNom(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getSoleil_par_seconde(),
                plante.getChemin_image(),
                plante.getEffet()
        );
    }

    private Plante convertToEntity(DTO_Plante dto) {
        return new Plante(
                dto.getId_plante(),
                dto.getNom(),
                dto.getDegat_attaque(),
                dto.getCout(),
                dto.getPoint_de_vie(),
                dto.getAttaque_par_seconde(),
                dto.getSoleil_par_seconde(),
                dto.getChemin_image(),
                dto.getEffet()
        );
    }
}
