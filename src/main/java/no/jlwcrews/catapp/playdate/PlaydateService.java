package no.jlwcrews.catapp.playdate;

import no.jlwcrews.catapp.cat.Cat;
import no.jlwcrews.catapp.cat.CatResponseDTO;
import no.jlwcrews.catapp.cat.CatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaydateService {

    private final PlaydateRepo playdateRepo;
    private final CatService catService;

    public PlaydateService(PlaydateRepo playdateRepo, CatService catService) {
        this.playdateRepo = playdateRepo;
        this.catService = catService;
    }

    public Playdate getPlaydateById(Long id){
        return playdateRepo.findById(id).orElse(null);
    }

    public List<PlaydateReponseDTO> getAllPlaydates(){
        var playdates = playdateRepo.findAll();
        return createPlaydateReponseDTO(playdates);
    }

    private static ArrayList<PlaydateReponseDTO> createPlaydateReponseDTO(List<Playdate> playdates) {
        var playdatesDto = new ArrayList<PlaydateReponseDTO>();
        var catDtos = new ArrayList<CatResponseDTO>();
        for(Playdate playdate: playdates){
            for(Cat cat : playdate.getPlaydateCats()){
                catDtos.add(new CatResponseDTO(cat.getCatId(), cat.getCatName(), cat.getCatAge()));
            }
            playdatesDto.add(new PlaydateReponseDTO(
                    playdate.getPlaydateId(),
                    playdate.getPlaydateDate(),
                    playdate.getPlaydateLocation(),
                    catDtos)
            );
        }
        return playdatesDto;
    }

    public Playdate createPlaydate(PlaydateDTO playdateDto){
        Playdate playdate = new Playdate();
        playdate.setPlaydateLocation(playdateDto.location());
        playdate.setPlaydateDate(playdateDto.date());
        playdate.setPlaydateCats(new ArrayList<>());
        for (Long catId: playdateDto.catIds()){
            playdate.getPlaydateCats().add(catService.getCat(catId));
        }
        return playdateRepo.save(playdate);
    }
}
