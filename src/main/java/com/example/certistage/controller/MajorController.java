package com.example.certistage.controller;

import com.example.certistage.entity.Major;
import com.example.certistage.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MajorController {

    private final MajorRepository majorRepository;

    @GetMapping("/majors")
    public List<Major> getMajors() {
        return majorRepository.findAll();
    }
}
