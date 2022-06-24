package com.imgarena.licensing.tennis.model;

import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.model.converter.TennisPlayerConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = TableNames.TENNIS_PLAYER)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class TennisPlayer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = TennisPlayerConverter.class)
    private TennisPlayerId tennisPlayerId;

    private String firstName;

    private String lastName;
}
