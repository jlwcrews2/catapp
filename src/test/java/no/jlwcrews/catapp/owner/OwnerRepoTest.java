package no.jlwcrews.catapp.owner;

import no.jlwcrews.catapp.testdata.TestDataController;
import no.jlwcrews.catapp.util.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OwnerRepoTest extends BaseIT {

    @Autowired
    private OwnerRepo repo;

    @Autowired
    private TestDataController testDataController;

    @Test
    void shouldGetOwners(){
        testDataController.createSampleData();
        assert repo.findAll().size() == 20;
    }
}