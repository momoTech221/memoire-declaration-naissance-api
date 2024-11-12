package sn.uasz.declarationNaissance.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name = "registres")

public class RegistreDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idRegistre;
    public String numero;
    public Boolean active;
    public String annee;
    @OneToMany(mappedBy = "registre")
    public List<DeclarationNaissanceDto> declarationissance = new ArrayList<>();
}
