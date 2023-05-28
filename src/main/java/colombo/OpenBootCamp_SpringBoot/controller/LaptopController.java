package colombo.OpenBootCamp_SpringBoot.controller;

import colombo.OpenBootCamp_SpringBoot.entities.Laptop;
import colombo.OpenBootCamp_SpringBoot.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository Laptoprepository;

    public LaptopController(LaptopRepository Laptoprepository) {
        this.Laptoprepository = Laptoprepository;
    }
//    CRUD sobre la entidad Laptop

//    Buscar todos los laptops
    @GetMapping("/api/Laptops")
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
    public Laptop create(@RequestBody Laptop Laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return Laptoprepository.save(Laptop);
    }
}
