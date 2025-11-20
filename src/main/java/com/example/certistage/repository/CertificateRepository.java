package com.example.certistage.repository;

import com.example.certistage.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    // 특정 전공 id에 해당하는 자격증 목록
    List<Certificate> findByMajorId(Long majorId);
}
