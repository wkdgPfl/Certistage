package com.example.certistage.repository;

import com.example.certistage.entity.CertificateKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateKeywordRepository extends JpaRepository<CertificateKeyword, Long> {

    List<CertificateKeyword> findByKeyword(String keyword);
}
