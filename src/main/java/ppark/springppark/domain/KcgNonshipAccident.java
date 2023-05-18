package ppark.springppark.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Getter
@Setter
@Entity
@Table(name = "kcg_nonship_accidents")
public class KcgNonshipAccident {
    @Id
    @Column(name = "kcg_nonship_accidents_id", nullable = false)
    private Long id;

/*
    TODO [JPA Buddy] create field to map the 'geometry' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "geometry", columnDefinition = "public.geometry")
    private Object geometry;
*/
    @Column(name = "geometry", nullable = false)
    private Point geometry;
}