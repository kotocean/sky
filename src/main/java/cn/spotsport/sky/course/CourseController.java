package cn.spotsport.sky.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<Course> getCollectionByPageable(Pageable pageable){
        return courseRepository.findAll(pageable).getContent();
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course){
        Course createdCourse =  courseRepository.save(course);
        if(null==createdCourse){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Course> update(@RequestBody Course course){
        Course updatedCourse =  courseRepository.save(course);
        if(null==updatedCourse){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping
    public void delete(@RequestBody Course course){
        courseRepository.delete(course);
    }
}
