package com.imgarena.licensing.tennis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Optional;

@Entity
@Table(name = TableNames.TENNIS_PLAYER)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TennisPlayer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;
}
