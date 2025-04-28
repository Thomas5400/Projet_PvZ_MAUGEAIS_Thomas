package com.epf.Controleur;

import com.epf.Controleur.DTO_Zombie;
import com.epf.Persistance.Zombie;
import com.epf.Service.Serv_Interface_Zombies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zombies")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class Controller_Zombie {

    @Autowired
    private Serv_Interface_Zombies servZombie;

    @GetMapping
    public List<DTO_Zombie> getAllZombies() {
        return servZombie.getAllZombies().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DTO_Zombie getZombieById(@PathVariable int id) {
        Zombie zombie = servZombie.getZombieById(id);
        return convertToDTO(zombie);
    }

    @GetMapping("/validation")
    public ResponseEntity<String> validateZombie() {
        return ResponseEntity.ok("zombies ok");
    }


    @PostMapping
    public void addZombie(@RequestBody DTO_Zombie dto) {
        servZombie.addZombie(convertToEntity(dto));
    }

    @PutMapping("/{id}")
    public void updateZombie(@PathVariable int id, @RequestBody DTO_Zombie dto) {
        dto.setId_zombie(id);
        servZombie.updateZombie(convertToEntity(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable int id) {
        servZombie.deleteZombie(id);
    }

    private DTO_Zombie convertToDTO(Zombie zombie) {
        return new DTO_Zombie(
                zombie.getId_zombie(),
                zombie.getPoint_de_vie(),
                zombie.getNom(),
                zombie.getVitesse_de_deplacement(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getChemin_image(),
                zombie.getId_map()
        );
    }

    private Zombie convertToEntity(DTO_Zombie dto) {
        return new Zombie(
                dto.getId_zombie(),
                dto.getPoint_de_vie(),
                dto.getNom(),
                dto.getVitesse_de_deplacement(),
                dto.getAttaque_par_seconde(),
                dto.getDegat_attaque(),
                dto.getChemin_image(),
                dto.getId_map()
        );
    }
}

