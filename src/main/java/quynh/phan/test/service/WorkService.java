package quynh.phan.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import quynh.phan.test.dao.WorkRepository;
import quynh.phan.test.exception.NotFoundException;
import quynh.phan.test.model.Work;
import quynh.phan.test.model.WorkEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    public Work save(Work work){
        WorkEntity workEntity = WorkConverter.toWorkEntity(work);
        workEntity.setId(null);
        return WorkConverter.toWork(workRepository.save(workEntity));
    }
    public Work update(Long workId, Work work) throws NotFoundException {
        WorkEntity existingTask = findById(workId);
        WorkEntity workEntity = WorkConverter.toWorkEntity(work);
        workEntity.setId(existingTask.getId());
        return WorkConverter.toWork(workRepository.save(workEntity));
    }

    public void delete(Long workId) throws NotFoundException {
        WorkEntity existingTask = findById(workId);
        workRepository.delete(existingTask);
    }

    public List<Work> getAllWorks(int pageNumber, int pageSize) {
        Page<WorkEntity> works = workRepository.findAll(PageRequest.of(pageNumber, pageSize));
        if (works == null || works.isEmpty()) {
            return Collections.emptyList();
        }
        return works.stream().map(WorkConverter::toWork).collect(Collectors.toList());
    }

    private WorkEntity findById(Long workId) throws NotFoundException {
        return workRepository.findById(workId)
                .orElseThrow(() -> new NotFoundException("Work not found with id: " + workId));
    }
}
