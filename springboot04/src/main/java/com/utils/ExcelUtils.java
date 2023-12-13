package com.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理excel
 *
 * @date 2021/8/25
 */
public class ExcelUtils {

    public static void main(String[] args) {
        /*for (int i = 1; i < 13; i++) {
            List<List<List>> salary = readExcel(new File("D:\\test\\2021_c\\c_" + i + ".xls"));
            List<List<List>> zhao = readExcel(new File("D:\\test\\2021.xls"));
            for (List<List> list1 : zhao) {
                for (List<String> list2 : list1) {
                    dealList(list2, salary);
                }
            }
            try {
                outPutToAExcel(zhao, "D:\\test\\res_" + i + ".xlsx");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("success");*/
        List<List<List>> table1 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\2023年汇总表.xls"));
        //List<List<List>> table2 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\1-11月汇总.xls"));
        //List<List<List>> table3 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\table3.xls"));
        //List<List<List>> table4 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\4-5月全县人员档案花名册.xlsx"));
        //List<List<List>> table6 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\6月全县人员档案花名册.xlsx"));
        //List<List<List>> table7 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\7月全县人员档案花名册.xlsx"));
        //List<List<List>> table8 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\8月全县人员档案花名册.xlsx"));
        //List<List<List>> table9 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\9月全县人员档案花名册.xlsx"));
//        List<List<List>> table10 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\10月全县人员档案花名册.xlsx"));
//        List<List<List>> table11 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\11月全县人员档案花名册.xlsx"));
        List<List<List>> table12 = readExcel(new File("C:\\Users\\Administrator\\Desktop\\12月全县人员档案花名册.xlsx"));
        List<String> ids = getIdFromTable1(table1);
        List<String> res = new ArrayList<>();
        for (String id : ids) {
            for (int i = 2; i < table12.get(0).size(); i++) {
                if(id.equals(table12.get(0).get(i).get(2).toString())){
                    //table2.get(0).get(i).add("存在");
                    res.add(id);
                    break;
                }
            }
        }
        System.out.println(res);
        //outPutToAExcel(table2, "C:\\Users\\Administrator\\Desktop\\test.xlsx");

    }

    public static List<String> getIdFromTable1(List<List<List>> table1){
        List<String> res = new ArrayList<>();
        for (int i = 3; i < table1.get(0).size(); i++) {
            res.add(table1.get(0).get(i).get(7).toString());
        }
        return res;
    }
    /**
     * 比对两个excel文件数据
     *
     * @param list2
     * @param salary
     */
    public static void dealList(List<String> list2, List<List<List>> salary) {
        for (int i = 2; i < list2.size(); i++) {
            for (List<List> list3 : salary) {
                for (List<String> list4 : list3) {
                    for (int j = 2; j < list2.size(); j++) {
                        if (list2.get(1).equals(list4.get(2)) && list2.get(0).equals(list4.get(0))) {
                            list2.set(list2.size() - 1, "同名");
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * 读取excel数据
     *
     * @param file
     * @return
     */
    public static List<List<List>> readExcel(File file) {
        Workbook wb = null;
        try {
            //create input stream ,get data
            wb = readExcelByFormat(file.getAbsolutePath());
            int sheetSize = wb.getNumberOfSheets();
            List<List<List>> sheetList = new ArrayList<>();
            // 遍历excel每个表
            for (int i = 0; i < sheetSize; i++) {
                List<List> outerList = new ArrayList<>();
                Sheet sheet = wb.getSheetAt(i);
                if (sheet.getLastRowNum() == 0) {
                    continue;
                }
                // 遍历表内每一行
                for (int j = 0; j <= sheet.getLastRowNum(); j++) {
                    List<String> list = new ArrayList<>();
                    // 遍历行内单元格数据
                    for (int c = 0; c <= sheet.getRow(j).getLastCellNum(); c++) {
                        Cell cell = sheet.getRow(j).getCell(c);
                        if (cell == null) {
                            list.add("");
                            continue;
                        }
                        cell.setCellType(CellType.STRING);
                        String str = (String) cell.getStringCellValue();
                        list.add(str);
                    }
                    outerList.add(list);
                }
                sheetList.add(outerList);
            }
            return sheetList;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                wb.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;

    }

    /**
     * 根据文件后缀读取对应版本的excel
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public static Workbook readExcelByFormat(String filePath) {
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));//获取文件格式
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {//判断Excel文件格式
                return new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                return new XSSFWorkbook(is);
            } else {
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /**
     * 导出xlsx文件
     *
     * @param res
     * @param filePath
     */
    public static void outPutToAExcel(List<List<List>> res, String filePath) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("res");

        XSSFRow row = null;
        List<List> list = res.get(0);
        XSSFCell cell;

        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i);
            for (int j = 0; j < list.get(i).size(); j++) {
                cell = row.createCell(j);
                cell.setCellValue((String) list.get(i).get(j));
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            wb.write(outputStream);
            wb.close();
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("获取不到位置");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 设置导出Excel表格样式
     *
     * @param workbook 表格
     * @return 样式
     */
    public static XSSFCellStyle createCellStyle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        //在对应的workbook中新建字体
        font.setFontName("微软雅黑");
        //字体微软雅黑
        font.setFontHeightInPoints((short) 11);
        //设置字体大小
        XSSFCellStyle style = workbook.createCellStyle();
        //新建Cell字体
        style.setFont(font);
        return style;
    }
}

