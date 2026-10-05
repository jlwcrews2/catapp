package no.jlwcrews.catapp.cat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CatServiceComponentTest {

    @Autowired
    private CatService catService;

    @Test
    void shouldCreateCat(){
        var result = catService.createCat(new Cat("BK", "Tuxedo", 6));

        assert result.getCatName().equals("BK");

        var catList = catService.getCats();
        assert catList.size() == 1;
    }
}
