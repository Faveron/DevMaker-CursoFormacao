package br.com.ada.sinqia.ProjetoWesleyFaveron.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", unique = true)
    private String nome;

    @ManyToMany(mappedBy = "jogos")
    private Set<Usuario> usuarios;

    @OneToMany(mappedBy = "jogo")
    @JsonIgnoreProperties("jogo")
    private Set<Conquista> conquistas;
}
