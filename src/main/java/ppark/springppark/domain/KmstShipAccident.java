package ppark.springppark.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "kmst_ship_accidents")
public class KmstShipAccident {
    @Id
    @Column(name = "kmst_ship_accidents_id", nullable = false)
    private Long id;

/*
    TODO [JPA Buddy] create field to map the 'geometry' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "geometry", columnDefinition = "public.geometry")
    private Object geometry;
*/
}