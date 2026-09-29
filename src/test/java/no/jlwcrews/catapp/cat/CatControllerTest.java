package no.jlwcrews.catapp.cat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest
public class CatControllerTest {

    @Autowired
    private CatController controller;

    @MockitoBean
    private CatService catService;

    @BeforeEach
    public void setup() {
        var cat1 = new Cat("Noodle", "Orange and White", 8);
        var cat2 = new Cat("Behemoth", "Black", 8);

        when(catService.getCats()).thenReturn(List.of(cat1, cat2));
    }

    @Test
    void shouldGetCats(){
        var result = controller.getCats();
        assert 2 == result.getBody().size();
    }
}
