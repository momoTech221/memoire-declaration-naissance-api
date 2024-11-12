package sn.uasz.declarationNaissance.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name = "declares")
public class DeclareDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idDeclare;
    public String nom;
    public String prenom;
    public String sexe;
//    @Temporal(TemporalType.DATE)
    public String dateNaissance;
    public String lieuNaissance;
    @OneToOne(mappedBy = "declare")
    public DeclarationNaissanceDto declarationNaissance;
}
