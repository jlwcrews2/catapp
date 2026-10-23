package no.jlwcrews.catapp.playdate;

import no.jlwcrews.catapp.cat.CatResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record PlaydateReponseDTO(
        Long playdateId,
        LocalDateTime playdateDate,
        String location,
        List<CatResponseDTO> cats
) {
}
