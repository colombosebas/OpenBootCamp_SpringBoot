package colombo.OpenBootCamp_SpringBoot.controller;

import colombo.OpenBootCamp_SpringBoot.entities.Laptop;
import colombo.OpenBootCamp_SpringBoot.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository Laptoprepository;

    public LaptopController(LaptopRepository Laptoprepository) {
        this.Laptoprepository = Laptoprepository;
    }
//    CRUD sobre la entidad Laptop

//    Buscar todos los laptops
    @GetMapping("/api/Laptops")
    @ApiOperation("Devuelve todas las laptop registradas en la BD")
    public List<Laptop> findAll(){
        return Laptoprepository.findAll();
    }

//    Buscar un solo laptop por id
    @GetMapping("/api/Laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> LaptopOpt = Laptoprepository.findById(id);
        if (LaptopOpt.isPresent()){
            return ResponseEntity.ok(LaptopOpt.get());
        }
        else {
             return ResponseEntity.notFound().build();
        }
    }
//    Crear un laptop nuevo en BD
    @PostMapping("/api/Laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if (laptop.getId() != null){
            log.warn("Error, intentando crear Laptop con Id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = Laptoprepository.save(laptop);
        return ResponseEntity.ok(result);
    }
//    Actualizar una laptop
    @PutMapping("/api/Laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("Intentando actualizar Laptop sin Id");
            return ResponseEntity.badRequest().build();
        }
        if(!Laptoprepository.existsById(laptop.getId())){
            log.warn("Intentando actualizar Laptop con un id incorrecto: " + laptop.getId());
            return ResponseEntity.badRequest().build();
        }
        Laptop result = Laptoprepository.save(laptop);
        return ResponseEntity.ok(result);
    }
//    Borrar una laptop
    @DeleteMapping("/api/Laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!Laptoprepository.existsById(id)){
            log.warn("Intentando actualizar Laptop con un id incorrecto: " + id);
            return ResponseEntity.badRequest().build();
        }
        Laptoprepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    //Borrar todas las laptops
    @DeleteMapping("/api/Laptops")
    public ResponseEntity<Laptop>deleteAll(){
        Laptoprepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
