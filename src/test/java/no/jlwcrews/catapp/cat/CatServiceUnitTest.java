package no.jlwcrews.catapp.cat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatServiceUnitTest {

    private final CatRepo mockCatRepo = mock(CatRepo.class);
    private final CatService catService = new CatService(mockCatRepo);

    @Test
    void shouldCreateCat(){

        var fuzzyBoi = new Cat("Unknown", "Tuxedo", 0);

        when(mockCatRepo.save(any())).thenReturn(fuzzyBoi);

        var result = catService.createCat(fuzzyBoi);
        assert result.getAge() == 0;
        assert result.getName().equals("Unknown");
        assert result.getColor().equals("Tuxedo");
    }

    @Test
    void shouldGetCat(){

    }

    @Test
    void shouldGetAllCats(){
        var firstCat = new Cat("Noodle", "Orange and white", 8);
        var secondCat = new Cat("Behemoth", "Black", 8);
        when(mockCatRepo.findAll()).thenReturn(List.of(firstCat, secondCat));

        var result = catService.getCats();

        assert result.size() == 2;
        assert result.get(0).getName().equals("Noodle");
        assert result.get(1).getColor().equals("Black");
    }

    @Test
    void shouldDeleteCat(){

    }
}
