package com.wsy.activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ActivitiApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 部署流程定义
     */
    @Test
    public void testDeployment() {
        // 1、创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3、使用RepositoryService进行部署
        Deployment deployment = repositoryService.createDeployment()
                // 添加bpmn资源
                .addClasspathResource("bpmn/排他网关接并行网关.bpmn20.xml")
                .name("请假申请流程")
                .deploy();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).list();
        System.out.println("--->" + list);
        System.out.println("流程部署id：" + deployment.getId());
        System.out.println("流程部署名称：" + deployment.getName());
        System.out.println("流程部署Key：" + deployment.getKey());
    }

    /**
     * 启动流程实例
     */
    @Test
    public void testStartProcess() {
        // 1、创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3、根据流程定义Key启动流程
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("排他网关接并行网关");
        System.out.println("流程定义id：" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例id：" + processInstance.getId());
        System.out.println("当前活动Id：" + processInstance.getActivityId());
    }

    /**
     * 查询当前个人待执行的任务
     */
    @Test
    public void testFindPersonalTaskList() throws Exception {
        // 任务负责人
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 创建TaskService
        TaskService taskService = processEngine.getTaskService();
        // 根据流程key和任务负责人查询任务
        List<Task> list = taskService.createTaskQuery()
                //流程Key
                .processDefinitionKey("排他网关接并行网关")
                //只查询该任务负责人的任务
                .taskAssignee("employee")
                .list();
        for (Task task : list) {
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }

    /**
     * 完成任务
     */
    @Test
    public void completeTask() {
        // 获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取taskService
        Map<String,Object> map = new HashMap<>();
        map.put("key", 1);
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                // 流程Key
                .processDefinitionKey("排他网关接并行网关")
                // 要查询的负责人
                .taskAssignee("lisi")
                .singleResult();
        taskService.complete(task.getId(), map);
    }


    /**
     * 查询流程定义
     */
    @Test
    public void queryProcessDefinition() {
        // 获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> definitionList = processDefinitionQuery.processDefinitionKey("Leave")
                .orderByProcessDefinitionVersion()
                .desc()
                .list();
        for (ProcessDefinition processDefinition : definitionList) {
            System.out.println("流程定义 id=" + processDefinition.getId());
            System.out.println("流程定义 name=" + processDefinition.getName());
            System.out.println("流程定义 key=" + processDefinition.getKey());
            System.out.println("流程定义 Version=" + processDefinition.getVersion());
            System.out.println("流程部署ID =" + processDefinition.getDeploymentId());
        }
    }

    /**
     * 查询流程实例
     */
    @Test
    public void queryProcessInstance() {
        // 流程定义key
        String processDefinitionKey = "Leave";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        List<ProcessInstance> list = runtimeService
                .createProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey)//
                .list();

        for (ProcessInstance processInstance : list) {
            System.out.println("----------------------------");
            System.out.println("流程实例id："
                    + processInstance.getProcessInstanceId());
            System.out.println("所属流程定义id："
                    + processInstance.getProcessDefinitionId());
            System.out.println("是否执行完成：" + processInstance.isEnded());
            System.out.println("是否暂停：" + processInstance.isSuspended());
            System.out.println("当前活动标识：" + processInstance.getActivityId());
            System.out.println("业务关键字：" + processInstance.getBusinessKey());
        }
    }

    /**
     * 查看历史信息
     */
    @Test
    public void findHistoryInfo() {
        // 获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取HistoryService
        HistoryService historyService = processEngine.getHistoryService();
        HistoricActivityInstanceQuery instanceQuery = historyService.createHistoricActivityInstanceQuery();
        instanceQuery.processInstanceId("2501");
        instanceQuery.orderByHistoricActivityInstanceStartTime().asc();
        List<HistoricActivityInstance> activityInstanceList = instanceQuery.list();
        for (HistoricActivityInstance hi : activityInstanceList) {
            System.out.println("=============" + hi.getActivityId() + " START=============");
            System.out.println(hi.getActivityId());
            System.out.println(hi.getActivityName());
            System.out.println(hi.getProcessDefinitionId());
            System.out.println(hi.getProcessInstanceId());
            System.out.println("=============" + hi.getActivityId() + " END=============");
        }
    }

    /**
     * 流程资源下载
     *
     * @throws IOException
     */
    @Test
    public void downBpmnFile() throws IOException {
        // 1、得到引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2、获取repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3、得到查询器：ProcessDefinitionQuery
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("Leave")
                .singleResult();
        // 4、通过流程定义信息，得到部署ID
        String deploymentId = processDefinition.getDeploymentId();
        // 5、通过repositoryService的方法，实现读取图片信息和bpmn信息
        InputStream pngInput = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        // bpmn文件的流
        InputStream bpmnInput = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());
        File file_png = new File("d:/Leave.png");
        File file_bpmn = new File("d:/Leave.bpmn20.xml");
        FileOutputStream bpmnOut = new FileOutputStream(file_bpmn);
        FileOutputStream pngOut = new FileOutputStream(file_png);
        IOUtils.copy(pngInput, pngOut);
        IOUtils.copy(bpmnInput, bpmnOut);
        pngOut.close();
        bpmnOut.close();
        pngInput.close();
        bpmnInput.close();
    }


}
