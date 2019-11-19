package com.first.hrm.controllers;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class PoiWriteController {

    public static void main(String[] args) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet1 = workbook.createSheet("sheet1");

        for (int i =0 ;i<10;i++){

            HSSFRow row = sheet1.createRow(i);

            for (int j =0;j<10;i++){
                HSSFCell cell = row.createCell(j);
                HSSFRichTextString string = new HSSFRichTextString("");
                string.applyFont(workbook.createFont());
                cell.setCellValue(string);
            }
        }
        workbook.write(new FileOutputStream("user.xls"));
    }

}
