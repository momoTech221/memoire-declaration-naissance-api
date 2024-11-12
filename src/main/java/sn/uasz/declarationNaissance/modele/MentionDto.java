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
@Table(name = "mentions")
public class MentionDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idMention;
    public String apposition;
    public String libele;
    @ManyToMany
    @JoinTable(name = "T_mention_declarationNaissance",
            joinColumns = @JoinColumn(name= "idMention"),
            inverseJoinColumns = @JoinColumn(name="idDeclaration"))
    public List<DeclarationNaissanceDto> declarationNaissance = new ArrayList<>();

}
