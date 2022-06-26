package com.imgarena.licensing.tennis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = TableNames.TENNIS_TOURNAMENT)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TennisTournament {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "TENNIS_TOURNAMENT_ID")
    List<TennisMatch> tennisMatches;
}
