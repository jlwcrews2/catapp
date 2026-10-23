package no.jlwcrews.catapp.cat;

public record CatResponseDTO(
        Long catId,
        String catName,
        int catAge
) {
}
