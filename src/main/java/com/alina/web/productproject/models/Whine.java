package com.alina.web.productproject.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "whines")
public class Whine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "whined_at")
    private Date date;
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Whine whine = (Whine) o;
        return Objects.equals(id, whine.id) && Objects.equals(date, whine.date) && Objects.equals(message, whine.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, message);
    }

}
