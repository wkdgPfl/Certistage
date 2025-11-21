package com.example.certistage.entity;

import com.example.certistage.entity.Major;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;          // 자격증 이름
    private String level;         // 기사 / 산업기사 / 기능사 등
    private String field;         // IT, 기계 같은 분야
    private String nextExamDate;  // 다음 시험일 (간단하게 String)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_id")
    private Major major;          // 어떤 전공과 관련된 자격증인지
}

