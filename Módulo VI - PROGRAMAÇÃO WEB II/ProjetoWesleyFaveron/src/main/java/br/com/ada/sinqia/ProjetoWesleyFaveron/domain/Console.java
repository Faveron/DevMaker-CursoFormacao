package br.com.ada.sinqia.ProjetoWesleyFaveron.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Consoles")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", unique = true)
    private String nome;
    private Integer ano;

    @OneToMany(mappedBy = "console")
    @JsonIgnoreProperties("console")
    private Set<Usuario> usuarios;
}
