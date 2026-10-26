package no.jlwcrews.catapp.cat;

import no.jlwcrews.catapp.exception.CatNameStupidException;
import no.jlwcrews.catapp.owner.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private Logger logger = LoggerFactory.getLogger(CatService.class);

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
        try {
            if (cat.getCatName().contains("P")) {
                throw new CatNameStupidException("No, your cat name is stupid");
            }
        } catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }

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
