package no.jlwcrews.catapp.owner;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getOwners(){
        return ResponseEntity.ok(ownerService.getOwners());
    }

    @GetMapping("/mincats/{minCats}")
    public ResponseEntity<List<Owner>> moreThanMinCats(@PathVariable int minCats){
        var owners = ownerService.getMoreThanXCats(minCats);
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id){
        return ResponseEntity.ok(ownerService.getOwner(id));
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@Valid @RequestBody Owner owner){
        return ResponseEntity.ok(ownerService.createOwner(owner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id){
        ownerService.deleteOwner(id);
        return ResponseEntity.ok("Owner deleted");
    }
}
