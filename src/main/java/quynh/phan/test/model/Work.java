package quynh.phan.test.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Work {
    private Long id;
    private String name;
    private LocalDateTime startingDate;
    private LocalDateTime endingDate;
    private WorkStatus status;
}
