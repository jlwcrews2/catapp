package no.jlwcrews.catapp.testdata;

import com.github.javafaker.Faker;
import no.jlwcrews.catapp.cat.Cat;
import no.jlwcrews.catapp.cat.CatService;
import no.jlwcrews.catapp.owner.Owner;
import no.jlwcrews.catapp.owner.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/testdata")
public class TestDataController {

    public final CatService catService;
    public final OwnerService ownerService;
    public final Faker faker = new Faker();

    public TestDataController(CatService catService, OwnerService ownerService) {
        this.catService = catService;
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<String> createSampleData(){
        List<Owner> owners = new ArrayList<>();
        for (int i = 0; i <20; i++) {
            var createdOwner = ownerService.createOwner(new Owner(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.internet().emailAddress()
            ));
            owners.add(createdOwner);
        }

        for (int i = 0; i <100; i++) {
            var ownerId = new Random().nextInt(owners.size());
            var randAge = new Random().nextInt(19);
            catService.createCat(
                    new Cat(
                            faker.cat().name(),
                            faker.cat().breed(),
                            randAge,
                            owners.get(ownerId)
                    )
            );
        }
        return ResponseEntity.ok("test cats and owners created");
    }
}
