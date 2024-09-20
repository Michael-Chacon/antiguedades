package com.app.app.country.persistence;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conde_country")
    Long codeCountry;

    @Column(nullable = false, length = 20)
    @NonNull
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country category)) return false;
        return Objects.equals(getCodeCountry(), category.getCodeCountry()) && getName().equals(category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeCountry(), getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + codeCountry +
                ", name='" + name + '\'' +
                '}';
    }
}
