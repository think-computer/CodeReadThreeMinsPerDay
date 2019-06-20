package kr.ac.jejunu.educom.yechankim.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_board")
@NoArgsConstructor
@Data
public class BoardEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int boardIdx;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String contents;

    @Column(nullable=false)
    private int hitCnt = 0;

    @Column(nullable=false)
    private String creatorId;

    @Column(nullable=false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDatetime = LocalDateTime.now();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedDatetime;

//    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinColumn(name="board_idx")
//    private Collection<BoardFileEntity> fileList;
}