package sn.uasz.declarationNaissance.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name = "formationSanitaires")
public class FormationSanitaireDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idFormation;
    public String code;
    public String libele;
    public String localisation;
    public String type;
    @OneToMany(mappedBy = "formationSanitaire")
    public List<DeclarationNaissanceDto> declarationNaissance = new ArrayList<>();
}
