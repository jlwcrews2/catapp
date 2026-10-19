package no.jlwcrews.catapp.owner;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepo ownerRepo;

    public OwnerService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    public List<Owner> getMoreThanXCats(int minCats){
        return ownerRepo.findOwnersWithMoreThanXCats(minCats);
    }

    public Owner getOwner(Long id){
        return ownerRepo.findById(id).orElse(null);
    }

    public List<Owner> getOwners(){
        return ownerRepo.findAll();
    }

    public Owner createOwner(Owner owner){
        return ownerRepo.save(owner);
    }

    public void deleteOwner(Long id){
        ownerRepo.deleteById(id);
    }

    public Owner updateOwner(Owner owner){
        return ownerRepo.save(owner);
    }
}
