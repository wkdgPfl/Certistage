package com.example.certistage.dto;

import com.example.certistage.entity.Certificate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CertificateDto {

    private Long id;
    private String name;
    private String level;
    private String field;
    private String nextExamDate;

    public static CertificateDto from(Certificate c) {
        return new CertificateDto(
                c.getId(),
                c.getName(),
                c.getLevel(),
                c.getField(),
                c.getNextExamDate()
        );
    }
}
