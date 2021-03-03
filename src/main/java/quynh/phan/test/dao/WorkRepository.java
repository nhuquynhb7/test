package quynh.phan.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quynh.phan.test.model.WorkEntity;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity,Long> {

}
