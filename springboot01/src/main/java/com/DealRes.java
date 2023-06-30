package com;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wushaoya
 * @date 2023-06-02
 * Time: 13:55
 */
public class DealRes {

    //把一个文件中的内容读取成一个String字符串
    public static String getStr(File jsonFile) {
        String jsonStr = "";
        try {
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deal() throws Exception {
        File json = new File("D:\\study\\springboot\\springboot01\\src\\main\\resources\\static\\rest.json");
        //通过上面那个方法获取json文件的内容
        String jsonData = getStr(json);
        //转json对象
        JSONObject parse = (JSONObject) JSONObject.parse(jsonData);
        JSONArray list = parse.getJSONArray("list");
        List<List<List>> sheetList = new ArrayList<>();
        List<List> sheet = new ArrayList<>();
        List row = new ArrayList();
        row.add("序号");
        row.add("工单名称");
        row.add("审批结果");
        row.add("申请人部门");
        row.add("申请人");
        row.add("处理人");
        row.add("结束时间");
        sheet.add(row);
        for (int i = 0; i < list.size(); i++) {
            JSONObject temp = list.getJSONObject(i);
            JSONObject processVariables = temp.getJSONObject("processVariables");
            List rowTemp = new ArrayList();
            rowTemp.add(String.valueOf(i));
            rowTemp.add(processVariables.get("key"));
            rowTemp.add("0".equals(processVariables.get("approve_result")) ? "通过" : "不通过");
            rowTemp.add(processVariables.get("createDeptName"));
            rowTemp.add(processVariables.get("apply_user"));
            rowTemp.add(temp.get("audit_member"));
            rowTemp.add(temp.get("proc_end_time"));
            sheet.add(rowTemp);
        }
        sheetList.add(sheet);
        OperateExcel.outPutToAExcel(sheetList, "D:\\study\\springboot\\springboot01\\src\\main\\resources\\static\\res1.xlsx");

    }

    public static void main(String[] args) {
        try {
            deal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
