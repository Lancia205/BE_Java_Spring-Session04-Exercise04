
package com.example.session04.controller;

import com.example.session04.dto.ApiResponse;
import com.example.session04.service.StudentEnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students-enrollments")
public class StudentEnrollmentController {
    private final StudentEnrollmentService service;

    public StudentEnrollmentController(StudentEnrollmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> enroll(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {
        service.enrollStudent(studentId, courseId);
        return ResponseEntity.ok(
                new ApiResponse<>("Đăng ký khóa học thành công", null));
    }
}
