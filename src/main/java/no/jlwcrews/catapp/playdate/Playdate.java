package no.jlwcrews.catapp.playdate;

import jakarta.persistence.*;
import no.jlwcrews.catapp.cat.Cat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Playdate {

    @Id
    @GeneratedValue(generator = "playdate_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "playdate_gen", sequenceName = "playdate_seq", initialValue = 1, allocationSize = 1)
    private Long playdateId;
    private String playdateLocation;
    private LocalDateTime playdateDate;

    @ManyToMany
    @JoinTable(
            name = "cat_playdate",
            joinColumns = @JoinColumn(name = "playdate_id"),
            inverseJoinColumns = @JoinColumn(name = "cat_id"))
    private List<Cat> playdateCats;

    public Long getPlaydateId() {
        return playdateId;
    }

    public void setPlaydateId(Long playdateId) {
        this.playdateId = playdateId;
    }

    public String getPlaydateLocation() {
        return playdateLocation;
    }

    public void setPlaydateLocation(String playdateLocation) {
        this.playdateLocation = playdateLocation;
    }

    public LocalDateTime getPlaydateDate() {
        return playdateDate;
    }

    public void setPlaydateDate(LocalDateTime playdateDate) {
        this.playdateDate = playdateDate;
    }

    public List<Cat> getPlaydateCats() {
        return playdateCats;
    }

    public void setPlaydateCats(List<Cat> playdateCats) {
        this.playdateCats = playdateCats;
    }
}
