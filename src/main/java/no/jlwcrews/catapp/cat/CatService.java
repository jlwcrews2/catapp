package no.jlwcrews.catapp.cat;

import no.jlwcrews.catapp.owner.OwnerService;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepo catRepo;
    private final OwnerService ownerService;

    public CatService(CatRepo catRepo, OwnerService ownerService) {
        this.catRepo = catRepo;
        this.ownerService = ownerService;
    }

    public Cat getCat(long id){
        return catRepo.findById(id).orElse(null);
    }

    public List<Cat> getCats(){
        return catRepo.findAll();
    }

    public Cat createCat(Cat cat){
        return catRepo.save(cat);
    }

    public Cat updateCat(Cat cat){
        return catRepo.save(cat);
    }

    public void deleteCat(long id){
        catRepo.deleteById(id);
    }

    public Cat changeOwnership(OwnershipChangeRequest changeRequest) {
        var cat = catRepo.findById(changeRequest.catId()).orElse(null);
        var owner = ownerService.getOwner(changeRequest.ownerId());
        cat.setOwner(owner);
        return catRepo.save(cat);
    }
}
