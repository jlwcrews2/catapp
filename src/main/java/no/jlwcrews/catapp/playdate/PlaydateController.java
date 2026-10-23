package no.jlwcrews.catapp.playdate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playdate")
public class PlaydateController {

    private final PlaydateService playdateService;

    public PlaydateController(PlaydateService playdateService) {
        this.playdateService = playdateService;
    }

    @GetMapping
    public ResponseEntity<List<PlaydateReponseDTO>> getPlaydates(){
        return ResponseEntity.ok(playdateService.getAllPlaydates());
    }

    @PostMapping
    public ResponseEntity<Playdate> createNewPlaydate(@RequestBody PlaydateDTO playdateDTO){
        return ResponseEntity.ok(playdateService.createPlaydate(playdateDTO));
    }
}
