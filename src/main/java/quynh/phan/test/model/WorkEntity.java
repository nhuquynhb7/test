package quynh.phan.test.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "startingDate")
    private LocalDateTime startingDate;

    @Column(name = "endingDate")
    private LocalDateTime endingDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private WorkStatus status;
}
