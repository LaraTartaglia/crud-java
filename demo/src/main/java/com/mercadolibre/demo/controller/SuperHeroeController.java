package com.mercadolibre.demo.controller;

import com.mercadolibre.demo.model.SuperHeroe;
import com.mercadolibre.demo.service.SuperHeroeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superheroe")
public class SuperHeroeController {

    private final SuperHeroeService service;

    public SuperHeroeController(SuperHeroeService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<SuperHeroe> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getSuperHeroe(@PathVariable("id") int id) {
        SuperHeroe idEncontrado = service.find(id);

        if (idEncontrado == null) {
            return ResponseEntity.badRequest()
                    .body("Id no encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Id solocitado: " + idEncontrado);
    }

    @PostMapping
    public ResponseEntity<String> postSuperHeroe(@RequestBody SuperHeroe superHeroe) {
        service.save(superHeroe);
        return ResponseEntity.ok("Superheroe Cargado!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putSuperHeroe(@PathVariable("id") int id, @RequestBody SuperHeroe superHeroe) {
        service.update(id, superHeroe);
        return ResponseEntity.ok("Superheroe Actualizado!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSuperHeroe(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.ok("Superheroe Eliminado!");
    }
}
