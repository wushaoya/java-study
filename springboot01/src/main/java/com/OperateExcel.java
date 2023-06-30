package com;


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
 * @date 2021/8/25
 */
public class OperateExcel {
    public static void main(String[] args) {
        /*List<List<List>> salary = readExcel(new File("D:\\test\\salary.xls"));
        List<List<List>> zhao = readExcel(new File("D:\\test\\test.xls"));
        for (List<List> list1 : zhao) {
            for (List<String> list2 : list1) {
                dealList(list2, salary);
            }
        }
        try {
            outPutToAExcel(zhao,"D:\\test\\res.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        List<List<List>> master = readExcel(new File("D:\\work\\思特奇\\试用期\\SC新人培养计划&跟踪表@吴少亚.xlsx"));
        /*List<List<List>> slave = readExcel(new File("D:\\study\\表格\\花名册\\12全县人员档案花名册.xlsx"));
        for (List<List> list1 : slave) {
            for (List<String> list2 : list1) {
                dealList花名册(list2, master);
            }
        }
        try {
            outPutToAExcel(master,"D:\\study\\表格\\res.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println("success");

    }

    public static void dealList花名册(List<String> list2, List<List<List>> master) {
        for (List<List> list3 : master) {
            for (List<String> list4 : list3) {
                for (int j = 2; j < list2.size(); j++) {
                    if (list2.get(8).equals(list4.get(7))) {
                        list4.set(11, "低保==>保障人口数：" + list2.get(18) + ";保障金额：" + list2.get(30));
                    }
                }
            }
        }
    }

    public static void dealList火化(List<String> list2, List<List<List>> master) {
        for (int i = 2; i < list2.size(); i++) {
            for (List<List> list3 : master) {
                for (List<String> list4 : list3) {
                    for (int j = 2; j < list2.size(); j++) {
                        if (list2.get(4).equals(list4.get(7))) {
                            list4.set(11, "死亡");
                        }
                    }
                }
            }
        }
    }

    public static void dealList(List<String> list2, List<List<List>> salary) {
        for (int i = 2; i < list2.size(); i++) {
            for (List<List> list3 : salary) {
                for (List<String> list4 : list3) {
                    for (int j = 2; j < list2.size(); j++) {
                        if (list2.get(9).equals(list4.get(2))) {
                            list2.set(5, list4.get(0));
                        }
                    }
                }
            }
        }
    }


    public static List<List<List>> readExcel(File file) {
        try {
            //create input stream ,get data
            //InputStream stream = new FileInputStream(file);
            Workbook wb = readExcel(file.getCanonicalPath());
            int sheetSize = wb.getNumberOfSheets();
            List<List<List>> sheetList = new ArrayList<>();
            for (int i = 0; i < sheetSize; i++) {
                List<List> outerList = new ArrayList<>();
                Sheet sheet = wb.getSheetAt(i);
                if (sheet.getLastRowNum() == 0) {
                    continue;
                }
                for (int j = 0; j <= sheet.getLastRowNum(); j++) {
                    if (j == 280) {
                        System.out.println("HH");
                    }
                    List<String> list = new ArrayList<>();
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
        }
        return null;

    }

    //根据文件后缀读取对应版本的excel
    public static Workbook readExcel(String filePath) throws Exception {
        Workbook wb = null;
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
        }
        return wb;
    }

    /**
     * 导出xlsx文件
     * https://www.2cto.com/kf/201605/510933.html
     * https://www.cnblogs.com/f-anything/p/5996380.html
     */
    public static void outPutToAExcel(List<List<List>> res, String filePath) throws Exception {
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
    private static XSSFCellStyle createCellStyle(XSSFWorkbook workbook) {
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
