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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "centres")
public class CentreDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idCentre;
    public String code;
    public String libele;
    public String collectiviteLocale;
    public String departement;
    public String region;
    @OneToMany(mappedBy = "centre")
    public List<DeclarationNaissanceDto> declarationNaissance = new ArrayList<>();
}
