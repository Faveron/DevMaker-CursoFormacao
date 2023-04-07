package br.com.ada.sinqia.ProjetoWesleyFaveron.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conquista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", unique = true)
    private String nome;

    @Column(name = "Detalhes")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private ConquistaStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "Grau")
    private ConquistaGrau grau;

    @Enumerated(EnumType.STRING)
    @Column(name = "Raridade")
    private ConquistaRaridade raridade;

    @Column(name = "Data_Da_Conquista")
    private LocalDateTime dataDaConquista;

    @ManyToOne(fetch = FetchType.EAGER)
    private Jogo jogo;
}
