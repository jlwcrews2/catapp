package no.jlwcrews.catapp.cat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatRepo {

    private final ArrayList<Cat> cats = new ArrayList<>();

    public Cat getCat(int id){
        return cats.get(id);
    }

    public List<Cat> getCats(){
        return cats;
    }

    public Cat addCat(Cat cat){
        cats.add(cat);
        return cat;
    }

    public void deleteCat(int id){
        cats.remove(id);
    }

    public Cat updateCat(Cat cat){
        //find cat
        //replace cat
        return cat;
    }
}
