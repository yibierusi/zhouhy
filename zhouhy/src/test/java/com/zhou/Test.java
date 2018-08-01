package com.zhou;

import com.zhou.ciri.DateFormatHelper;
import com.zhou.entry.entity.Entry;
import com.zhou.entry.service.EntryService;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhouhy on 2017/12/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private EntryService entryService;

    //导入考勤数据
    @org.junit.Test
    public void aaa() throws Exception{
        File file = new File("C:/Users/zhouhy/Documents/WeChat Files/zy4670049/Files/7月考勤.xls");
        // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<Entry> outerList = new ArrayList<Entry>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 1; i < sheet.getRows(); i++) {
                    Entry entry = new Entry();
                    entry.setDepartment(sheet.getCell(0, i).getContents());
                    entry.setName(sheet.getCell(1, i).getContents());
                    entry.setNumber(sheet.getCell(2, i).getContents());

                    String date = sheet.getCell(3, i).getContents();
                    entry.setDate(DateFormatHelper.stringToDate(date,"MM/dd/yy HH:mm"));
                    entryService.insert(entry);
                    //outerList.add(entry);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
