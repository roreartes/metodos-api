package ar.com.ada.spring.demo.controller;


import ar.com.ada.spring.demo.model.DTO.DogDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @GetMapping({"", "/"})
    private ResponseEntity getAllDogs(){

        List <DogDTO> dog = new ArrayList<>();
        dog.add(new DogDTO("Caniche", "Macho"));
        dog.add(new DogDTO("Puddle", "Hembra"));
        dog.add(new DogDTO("Boxer", "Hembra"));

        return ResponseEntity.ok().body(dog);

    }
    private ResponseEntity addNewDog(@RequestBody DogDTO dog) throws URISyntaxException {
        int id = (int) (Math.random()* (1000-1)+ 1);

        dog.setId(Integer.toUnsignedLong(id));

        return ResponseEntity.created(new URI("/dogs/" + dog.getId())).body(dog);

    }

    @GetMapping("/{id}")
    private  ResponseEntity getById(@PathVariable long id) {
        DogDTO dog = new DogDTO(id, "Maltez","hembra" );
        return ResponseEntity.ok().body(dog);
    }

    @PutMapping("/{id}")
    private ResponseEntity updateDog(@RequestBody DogDTO dog, @PathVariable Long id){
        dog.setId(id);
        return ResponseEntity.ok().body(dog);

    }

    @DeleteMapping("{/id}")
    private ResponseEntity deleteDog(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }




}
