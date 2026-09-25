package no.jlwcrews.catapp.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepo catRepo;

    public CatService(CatRepo catRepo){
        this.catRepo = catRepo;
    }

    public Cat getCat(int id){
        return catRepo.getCat(id);
    }

    public List<Cat> getCats(){
        return catRepo.getCats();
    }

    public Cat createCat(Cat cat){
        return catRepo.addCat(cat);
    }

    public Cat updateCat(Cat cat){
        return catRepo.updateCat(cat);
    }

    public void deleteCat(int id){
        catRepo.deleteCat(id);
    }
}
