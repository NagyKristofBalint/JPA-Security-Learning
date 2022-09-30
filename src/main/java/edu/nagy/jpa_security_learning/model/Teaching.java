package edu.nagy.jpa_security_learning.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "Teaching")
public class Teaching extends BaseEntity {
    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Course course;

    @Temporal(TemporalType.TIME)
    private Date time;
}
