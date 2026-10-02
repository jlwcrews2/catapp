package no.jlwcrews.catapp.cat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepo catRepo;

    public CatService(CatRepo catRepo) {
        this.catRepo = catRepo;
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
}
