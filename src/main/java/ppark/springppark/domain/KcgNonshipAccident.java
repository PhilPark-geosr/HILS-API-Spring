package ppark.springppark.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import ppark.springppark.converter.PointConverter;


@Getter
@Setter
@Entity
@Table(schema = "characteristics_accidents", name = "kcg_ship_accidents")
public class KcgNonshipAccident {
    @Id
    @Column(name = "kcg_ship_accidents_id", nullable = false)
    private Long id;

/*
    TODO [JPA Buddy] create field to map the 'geometry' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "geometry", columnDefinition = "public.geometry")
    private Object geometry;
*/
    @Column(name = "geometry", columnDefinition = "geometry(Point,4179)")
    private byte[] geometry;
//    @Column(columnDefinition = "geometry(Point,4326)")
//    private Geometry geometry;

}