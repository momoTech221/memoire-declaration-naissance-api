package sn.uasz.declarationNaissance.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name = "peres")

public class PereDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idPere;
    @Column(length = 30, name="nom")
    public String nom;
    public String prenom;
    public String typePiece;
//    @Size(max=16)
    public String numeroPiece;
    public String profession;
    public String adresse;
//    @Temporal(TemporalType.DATE)
    public String dateNaiss;
    public String lieuNaiss;
    @OneToMany(mappedBy = ("pere"))
    public List<DeclarationNaissanceDto> declarationNaissance = new ArrayList<>();

}
