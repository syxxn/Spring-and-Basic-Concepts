package com.example.poitest;

import lombok.NoArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor //Could not autowire. No beans of 'String' type found. 오류날 때 붙이세요
public class SchoolInfo {

    private final HSSFWorkbook workbook = new HSSFWorkbook();
    private final HSSFSheet sheet = workbook.createSheet("school info");

    private String name;
    private String openingDay;
    private String lesson;
    private String phoneNumber;
    private String address;

    public Workbook getWorkbook() {
        return workbook;
    }

    public SchoolInfo(String name, String openingDay, String lesson, String phoneNumber, String address) {
        this.name = name;
        this.openingDay = openingDay;
        this.lesson = lesson;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void format() {
        sheet.setDefaultColumnWidth(20);
        CellStyle alignCenter = alignCenter();

        Row row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("학교 이름");
        row1.createCell(1).setCellValue(name);

        Row row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("개교일");
        row2.createCell(1).setCellValue(openingDay);

        Row row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("교훈");
        row3.createCell(1).setCellValue(lesson);

        Row row4 = sheet.createRow(3);
        row4.createCell(0).setCellValue("연락처");
        row4.createCell(1).setCellValue(phoneNumber);

        Row row5 = sheet.createRow(4);
        row5.createCell(0).setCellValue("주소");
        row5.createCell(1).setCellValue(address);

        sheet.setColumnWidth(1,40);
    }

    private CellStyle alignCenter() {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

}
