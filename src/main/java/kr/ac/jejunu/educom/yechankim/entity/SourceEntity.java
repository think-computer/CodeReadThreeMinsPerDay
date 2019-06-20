package kr.ac.jejunu.educom.yechankim.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_source")
@NoArgsConstructor
@Data
public class SourceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idx;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String source;

    @Column(nullable=false)
    private String videoUrl;

    @Column(nullable=false)
    private String category;
}
