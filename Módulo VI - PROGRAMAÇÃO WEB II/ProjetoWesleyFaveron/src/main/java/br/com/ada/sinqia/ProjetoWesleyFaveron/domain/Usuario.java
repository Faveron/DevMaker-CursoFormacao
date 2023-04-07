package br.com.ada.sinqia.ProjetoWesleyFaveron.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", unique = true)
    private String nome;
    private String cpf;
    private LocalDateTime dataNascimento;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER)
    private Console console;

    @ManyToMany
    @JoinTable(
            name = "usuarios_jogos",
            joinColumns = @JoinColumn(name = "usuarios_id"),
            inverseJoinColumns = @JoinColumn(name = "jogos_id")
    )
    @JsonIgnoreProperties("usuarios")
    private Set<Jogo> jogos;
}
