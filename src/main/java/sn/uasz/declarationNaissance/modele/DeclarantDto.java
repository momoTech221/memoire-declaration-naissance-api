package sn.uasz.declarationNaissance.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
//import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "declarants")
public class DeclarantDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idDeclarant;
    public String nom;
    public String prenom;
    public String typePiece;
    public String numeroPiece;
    public String adresse;
    public String profession;
    public String dateNaissance;
    public String lieuNaissance;
    public String degreParental;
    @OneToMany(mappedBy = "declarant")
    public List<DeclarationNaissanceDto> declarationNaissance = new ArrayList<>();
}
