package quynh.phan.test.service;

import quynh.phan.test.model.Work;
import quynh.phan.test.model.WorkEntity;

import javax.persistence.Entity;

public final class WorkConverter {
    private WorkConverter() {

    }
    public static Work toWork(WorkEntity workEntity){
        return Work.builder()
                .id(workEntity.getId())
                .name(workEntity.getName())
                .startingDate(workEntity.getStartingDate())
                .endingDate(workEntity.getEndingDate())
                .status(workEntity.getStatus()).build();
    }

    public static WorkEntity toWorkEntity(Work work){
        return WorkEntity.builder().name(work.getName())
                .startingDate(work.getStartingDate())
                .endingDate(work.getEndingDate())
                .status(work.getStatus()).build();
    }
}
