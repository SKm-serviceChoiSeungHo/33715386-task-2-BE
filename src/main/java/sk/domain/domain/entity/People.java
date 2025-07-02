package sk.domain.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@NoArgsConstructor
@DynamicUpdate
public class People {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private String country;


    @Builder
    public People(String id, String name, String gender, String age, String country) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.country = country;
    }
}
