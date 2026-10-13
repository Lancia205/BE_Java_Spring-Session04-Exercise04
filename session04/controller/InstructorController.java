
package com.example.session04.controller;

import com.example.session04.dto.ApiResponse;
import com.example.session04.dto.InstructorCreateRequest;
import com.example.session04.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(
            @RequestBody InstructorCreateRequest req) {
        service.createInstructor(req);
        return ResponseEntity.ok(
                new ApiResponse<>("Tạo giảng viên thành công", null));
    }
}
