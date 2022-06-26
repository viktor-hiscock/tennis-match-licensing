package com.imgarena.licensing.tennis.model;

import com.imgarena.licensing.tennis.model.converter.ZoneIdConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = TableNames.TENNIS_MATCH)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TennisMatch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;

    @Convert(converter = ZoneIdConverter.class)
    private ZoneId zoneId;

    @OneToOne
    @JoinColumn(name = "TENNIS_PLAYER_A_ID", referencedColumnName = "ID")
    private TennisPlayer playerA;

    @OneToOne
    @JoinColumn(name = "TENNIS_PLAYER_B_ID", referencedColumnName = "ID")
    private TennisPlayer playerB;
}
