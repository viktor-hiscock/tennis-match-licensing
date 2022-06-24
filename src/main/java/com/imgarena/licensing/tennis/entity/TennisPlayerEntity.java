package com.imgarena.licensing.tennis.entity;

import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.entity.converter.TennisPlayerConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = TableNames.TENNIS_PLAYER)
public class TennisPlayerEntity {
    @Id
    @Convert(converter = TennisPlayerConverter.class)
    private TennisPlayerId id;

    private String firstName;

    private String lastName;
}