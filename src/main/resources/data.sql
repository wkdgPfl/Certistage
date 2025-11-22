INSERT INTO major (name) VALUES ('컴퓨터공학과');
INSERT INTO major (name) VALUES ('경영학과');
INSERT INTO major (name) VALUES ('전기전자공학과');
INSERT INTO major (name) VALUES ('정보보호학과');
INSERT INTO major (name) VALUES ('소프트웨어융합학과');
INSERT INTO major (name) VALUES ('인공지능학과');
INSERT INTO major (name) VALUES ('데이터사이언스학과');
INSERT INTO major (name) VALUES ('미디어커뮤니케이션학과');
INSERT INTO major (name) VALUES ('산업경영공학과');
INSERT INTO major (name) VALUES ('화학공학과');
INSERT INTO major (name) VALUES ('기계공학과');
INSERT INTO major (name) VALUES ('간호학과');
INSERT INTO major (name) VALUES ('심리학과');
INSERT INTO major (name) VALUES ('사회복지학과');
INSERT INTO major (name) VALUES ('유아교육학과');
INSERT INTO major (name) VALUES ('체육학과');
INSERT INTO major (name) VALUES ('국어국문학과');
INSERT INTO major (name) VALUES ('영어영문학과');
INSERT INTO major (name) VALUES ('일어일문학과');
INSERT INTO major (name) VALUES ('중어중문학과');
INSERT INTO major (name) VALUES ('역사학과');
INSERT INTO major (name) VALUES ('철학과');
INSERT INTO major (name) VALUES ('경제학과');
INSERT INTO major (name) VALUES ('무역학과');
INSERT INTO major (name) VALUES ('행정학과');
INSERT INTO major (name) VALUES ('정치외교학과');
INSERT INTO major (name) VALUES ('사회학과');
INSERT INTO major (name) VALUES ('범죄학과');
INSERT INTO major (name) VALUES ('관광경영학과');
INSERT INTO major (name) VALUES ('호텔외식경영학과');
INSERT INTO major (name) VALUES ('패션디자인학과');
INSERT INTO major (name) VALUES ('시각디자인학과');
INSERT INTO major (name) VALUES ('제품디자인학과');
INSERT INTO major (name) VALUES ('건축학과');
INSERT INTO major (name) VALUES ('도시공학과');
INSERT INTO major (name) VALUES ('환경공학과');
INSERT INTO major (name) VALUES ('바이오공학과');
INSERT INTO major (name) VALUES ('생활과학과');
INSERT INTO major (name) VALUES ('식품영양학과');
INSERT INTO major (name) VALUES ('교육공학과');
INSERT INTO major (name) VALUES ('수학교육과');
INSERT INTO major (name) VALUES ('과학교육과');
INSERT INTO major (name) VALUES ('컴퓨터교육과');
INSERT INTO major (name) VALUES ('물리학과');
INSERT INTO major (name) VALUES ('화학과');
INSERT INTO major (name) VALUES ('생명과학과');
INSERT INTO major (name) VALUES ('통계학과');
INSERT INTO major (name) VALUES ('빅데이터학과');
INSERT INTO major (name) VALUES ('국제학과');

-- 컴퓨터공학과(major_id = 1) 관련 더미데이터

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('정보처리기사', '기사', 'IT / 소프트웨어', '2025-06-15', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('정보보안기사', '기사', '보안', '2025-05-30', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('SQLD', '데이터', '데이터베이스', '2025-07-20', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('SQLP', '데이터', '데이터베이스', '2025-09-18', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('네트워크관리사 2급', '2급', '네트워크', '2025-08-05', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('리눅스마스터 2급', '2급', '리눅스 / 서버', '2025-10-12', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('정보기기운용기능사', '기능사', 'IT 기기', '2025-11-03', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('ADsP(데이터분석 준전문가)', '준전문가', '데이터', '2025-08-30', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('빅데이터분석기사', '기사', '데이터 / 빅데이터', '2025-12-10', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('AWS Certified Cloud Practitioner', '기초', '클라우드', '2025-06-10', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('AWS Solutions Architect Associate', 'Associate', '클라우드', '2025-08-14', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('Azure Fundamentals', '기초', '클라우드', '2025-09-10', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('Kubernetes 관리 자격 (CKA)', '전문가', '클라우드 / 컨테이너', '2025-07-08', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('도커 전문가 자격증', '전문가', '클라우드 / DevOps', '2025-10-21', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('정보보안산업기사', '산업기사', '보안', '2025-11-18', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('IoT지능형기기개발산업기사', '산업기사', 'IoT', '2025-09-27', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('소프트웨어자산관리사(SAM)', '전문가', 'IT / 자산관리', '2025-12-05', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('정보통신기사', '기사', '통신 / 네트워크', '2025-07-01', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('컴퓨터활용능력 1급', '1급', '사무 / 컴퓨터', '2025-06-11', 1);

INSERT INTO certificate (name, level, field, next_exam_date, major_id)
VALUES ('전자계산기조직응용기사', '기사', 'IT / 전산', '2025-08-19', 1);
