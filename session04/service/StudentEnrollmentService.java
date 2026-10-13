
package com.example.session04.service;

import com.example.session04.entity.Course;
import com.example.session04.entity.Student;
import com.example.session04.entity.StudentEnrollment;
import com.example.session04.repository.CourseRepository;
import com.example.session04.repository.StudentRepository;
import com.example.session04.repository.StudentEnrollmentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollmentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentEnrollmentRepository enrollmentRepository;

    public StudentEnrollmentService(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            StudentEnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));

        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        enrollmentRepository.save(enrollment);
    }
}
