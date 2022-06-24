package com.imgarena.licensing.tennis.model;

import com.imgarena.licensing.tennis.identifiers.MatchId;
import com.imgarena.licensing.tennis.model.converter.MatchIdConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = TableNames.TENNIS_MATCH)
public class TennisMatch {
    @Id
    @Convert(converter = MatchIdConverter.class)
    private MatchId id;

    private ZonedDateTime startDate;

    @OneToOne
    @JoinColumn(name = "TENNIS_PLAYER_A_ID", referencedColumnName = "ID")
    private TennisPlayer playerA;

    @OneToOne
    @JoinColumn(name = "TENNIS_PLAYER_B_ID", referencedColumnName = "ID")
    private TennisPlayer playerB;
}
