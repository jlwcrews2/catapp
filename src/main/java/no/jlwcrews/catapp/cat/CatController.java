package no.jlwcrews.catapp.cat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getCats(){
        return ResponseEntity.ok(catService.getCats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cat> getCat(@PathVariable int id){
        return ResponseEntity.ok(catService.getCat(id));
    }

    @PostMapping
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat){
        return ResponseEntity.ok(catService.createCat(cat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCat(@PathVariable int id){
        catService.deleteCat(id);
        return ResponseEntity.ok("Cat deleted");
    }

    @PutMapping
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat){
        return ResponseEntity.ok(catService.updateCat(cat));
    }
}
