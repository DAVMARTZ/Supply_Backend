package co.edu.ue.dev.insumos.back.controller;

import co.edu.ue.dev.insumos.back.entity.Insumos;
import co.edu.ue.dev.insumos.back.service.SupplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supply")
@CrossOrigin(origins = "http://localhost:4200")
public class SupplyController {

    private final SupplyService service;

    public SupplyController(SupplyService service) {
        this.service = service;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Insumos> postSupply(@RequestBody Insumos insumos) {
        Insumos saved = service.addSupply(insumos);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Insumos>> getAll() {
        List<Insumos> list = service.listAll();
        return ResponseEntity.ok()
                .header("cantDates", String.valueOf(list.size()))
                .body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Insumos> getById(@PathVariable Integer id) {
        Optional<Insumos> result = service.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putSupply(@RequestBody Insumos insumos) {
        Insumos updated = service.updateSupply(insumos);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontró el insumo que se desea actualizar.");
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> inactiveSupply(@PathVariable Integer id) {
        Insumos inactive = service.inactiveSupply(id);
        if (inactive != null) {
            return ResponseEntity.ok(inactive);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontró el insumo con ID " + id + ".");
    }
}
