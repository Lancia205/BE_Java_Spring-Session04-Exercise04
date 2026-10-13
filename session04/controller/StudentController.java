
package com.example.session04.controller;

import com.example.session04.dto.*;
import com.example.session04.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(
            @RequestBody StudentCreateRequest req) {
        service.createStudent(req);
        return ResponseEntity.ok(
                new ApiResponse<>("Tạo sinh viên thành công", null));
    }
}
