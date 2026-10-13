
package com.example.session04.controller;

import com.example.session04.dto.*;
import com.example.session04.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(
            @RequestBody CourseCreateRequest req) {
        service.createCourse(req);
        return ResponseEntity.ok(
                new ApiResponse<>("Tạo khóa học thành công", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> update(
            @PathVariable Long id,
            @RequestBody CourseUpdateRequest req) {
        service.updateCourse(id, req);
        return ResponseEntity.ok(
                new ApiResponse<>("Cập nhật khóa học thành công", null));
    }
}
