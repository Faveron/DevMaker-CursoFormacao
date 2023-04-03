package br.com.ada.Industria.eolica.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Aerogerador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String modelo;

    @Column(unique = true)
    private String numeroSerie;

    @Enumerated(EnumType.STRING)
    private AerogeradorStatus status;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private ParqueEolico parqueEolico;
}