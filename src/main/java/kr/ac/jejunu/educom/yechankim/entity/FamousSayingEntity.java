package kr.ac.jejunu.educom.yechankim.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_famous_saying")
@NoArgsConstructor
@Data
public class FamousSayingEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idx;

    @Column(nullable = false)
    private String celebName;

    @Column(nullable = false)
    private String celebInfo;

    @Column(nullable = false)
    private String saying;

    @Column(nullable = false)
    private String celebPhotoUrl;
}
