package br.com.ada.sinqia.ProjetoWesleyFaveron.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Conquistas")
public class Conquista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "Nome", unique = true)
    private String nome;

    @NotNull
    @NotBlank
    @Column(name = "Detalhes")
    private String descricao;

    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private ConquistaStatus status;

    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "Grau")
    private ConquistaGrau grau;

    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "Raridade")
    private ConquistaRaridade raridade;

    @Column(name = "Data_Da_Conquista")
    private LocalDateTime dataDaConquista;
}
