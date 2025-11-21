package com.example.certistage.dto;

import lombok.Data;
import java.util.List;

@Data
public class ExamApiResponse {

    private Header header;
    private Body body;

    @Data
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Data
    public static class Body {
        private List<ExamItem> items;
        private int numOfRows;
        private int pageNo;
        private int totalCount;
    }

    @Data
    public static class ExamItem {
        private String implYy;
        private int implSeq;
        private String qualgbCd;
        private String qualgbNm;
        private String description;

        private String docRegStartDt;
        private String docRegEndDt;
        private String docExamStartDt;
        private String docExamEndDt;
        private String docPassDt;

        private String pracRegStartDt;
        private String pracRegEndDt;
        private String pracExamStartDt;
        private String pracExamEndDt;
        private String pracPassDt;
    }
}
