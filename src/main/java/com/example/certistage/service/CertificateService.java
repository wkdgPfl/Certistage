package com.example.certistage.service;

import com.example.certistage.dto.CertificateDto;
import com.example.certistage.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository certificateRepository;

    public List<CertificateDto> getCertificatesByMajor(Long majorId) {
        return certificateRepository.findByMajorId(majorId)
                .stream()
                .map(CertificateDto::from)
                .toList();
    }
}
