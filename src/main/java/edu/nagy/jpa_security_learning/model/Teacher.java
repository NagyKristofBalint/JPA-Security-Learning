package edu.nagy.jpa_security_learning.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "Teachers")
public class Teacher extends BaseEntity {
    @Min(1)
    @Max(10)
    @NotNull
    private Integer proficiency;

    @ToString.Exclude
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teaching> teachings;
}
