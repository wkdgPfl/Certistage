package com.example.certistage.controller;

import com.example.certistage.dto.CertificateDto;
import com.example.certistage.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CertificateController {

    private final CertificateService certificateService;

    // GET /api/certificates?majorId=1
    @GetMapping("/certificates")
    public List<CertificateDto> getCertificates(@RequestParam Long majorId) {
        return certificateService.getCertificatesByMajor(majorId);
    }
}
