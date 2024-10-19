package ar.com.ale94.pet_adoption_api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "pet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer age;
    @Column(nullable = false)
    private Boolean available;
    private String breed;
    private String description;
    @Column(nullable = false)
    private LocalDateTime entryDate;
    private String imageUrl;
    @Column(nullable = false)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet-type_id")
    private PetTypeEntity petType;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER,
        orphanRemoval = true,
        mappedBy = "pet"
    )
    private Set<AdoptionEntity> adoptions;
}
