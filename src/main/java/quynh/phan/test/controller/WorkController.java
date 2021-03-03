package quynh.phan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import quynh.phan.test.exception.NotFoundException;
import quynh.phan.test.service.WorkService;
import quynh.phan.test.model.Work;

import java.util.List;

@RestController
@RequestMapping("/api/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    /**
     * Get list of works.
     */
    @GetMapping(params = { "page", "size" })
    public List<Work> getAllWorks(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize) {
        return workService.getAllWorks(pageNumber, pageSize);
    }

    /**
     * Create work
     *
     */
    @PostMapping("/")
    public ResponseEntity<Work> createWork(@RequestBody Work work) {
        return ResponseEntity.ok(workService.save(work));
    }

    /**
     * Update work
     */
    @PutMapping({"{id}"})
    public ResponseEntity<Work> updateWork(@PathVariable(value = "id") Long workId, @RequestBody Work work) {
        try {
            Work updatedWork = workService.update(workId, work);
            return ResponseEntity.ok(updatedWork);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * Delete work.
     */
    @DeleteMapping("{id}")
    public void deleteWork(@PathVariable(value = "id") Long workId) {
        try {
            workService.delete(workId);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
