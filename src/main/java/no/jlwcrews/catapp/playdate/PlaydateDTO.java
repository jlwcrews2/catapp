package no.jlwcrews.catapp.playdate;

import java.time.LocalDateTime;
import java.util.List;

public record PlaydateDTO(
        String location,
        LocalDateTime date,
        List<Long> catIds
) {
}
