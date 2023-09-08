package com.wsy.activiti;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.*;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wushaoya
 * @date 2023-09-06
 * Time: 9:19
 */
@SpringBootTest
public class Test1 {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;
    /**
     * 处理任务
     */
    @Test
    public void test5() {
        String processInstanceId = "fc914dc6-4d44-11ee-83ef-e86a648496f3";
        String taskId = "e2ed1158-4d4a-11ee-9c1f-e86a648496f3";
        // 认领任务
        taskService.complete(taskId);
    }


    /**
     * 认领
     */
    @Test
    public void test4() {
        // 客户点击具体的任务处理任务
        String processInstanceId = "fc914dc6-4d44-11ee-83ef-e86a648496f3";
        String taskId = "e2ed1158-4d4a-11ee-9c1f-e86a648496f3";
        // 处理人
        String userId = "Joker";
        // 认领任务
        taskService.complete(taskId);
    }

    /**
     * 查询待办任务
     */
    @Test
    public void test2() {
        // 根据当前人员组名传入参数
        String group = "activitiTeam";
        // 查询改组下所有的任务传给第三方
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(group).list();
        for (Task task : tasks) {
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
        /**/
    }

    /**
     * 启动流程
     */
    @Test
    public void test1() {
        // 启动流程，返回流程实例ID
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("test1");
        System.out.println("流程定义id：" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例id：" + processInstance.getId());
        System.out.println("当前活动Id：" + processInstance.getActivityId());
    }

    /**
     * 查询流程定义信息
     */
    @Test
    public void test3() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().processDefinitionKey("test1").list();
        if (list != null && list.size() > 0) {
            for (ProcessDefinition processDefinition : list) {
                System.out.println(processDefinition.getId());
                System.out.println(processDefinition.getKey());
                System.out.println(processDefinition.getName());
            }
        }

    }

    /*** 创建流程定义及部署*/
    @Test
    public void generateProcess() {
        System.out.println("--------- start ---------");
        BpmnModel bpmnModel = new BpmnModel();
        Process process = new Process();
        bpmnModel.addProcess(process);
        process.setId("test1");
        process.setName("test1");
        //添加开始节点
        process.addFlowElement(generateStartEvent());
        //添加用户节点
        process.addFlowElement(generateUserTask("task1", "填写申请单", "", "", "activitiTeam"));
        process.addFlowElement(generateUserTask("task2", "技术经理", "zhangsan", "", ""));
        process.addFlowElement(generateUserTask("task3", "人事经理", "", "renshi1,renshi2", ""));
        process.addFlowElement(generateUserTask("task4", "项目经理", "lisi", "", ""));
        process.addFlowElement(generateUserTask("task5", "总经理", "wangwu", "", ""));
        //添加包含网关
        process.addFlowElement(generateInclusiveGateway("inclusiveGateway1"));
        process.addFlowElement(generateInclusiveGateway("inclusiveGateway2"));
        //添加排他网关
        process.addFlowElement(generateExclusiveGateway("exclusiveGateway1"));
        //添加结束节点
        process.addFlowElement(generateEndEvent());
        //设置连接线
        process.addFlowElement(generateSequenceFlow("startEvent", "task1", "", ""));
        process.addFlowElement(generateSequenceFlow("task1", "inclusiveGateway1", "", ""));
        process.addFlowElement(generateSequenceFlow("inclusiveGateway1", "task2", "大于等于3天", "${evection.num>=3}"));
        process.addFlowElement(generateSequenceFlow("inclusiveGateway1", "task3", "", ""));
        process.addFlowElement(generateSequenceFlow("inclusiveGateway1", "task4", "小于3天", "${evection.num<3}"));
        process.addFlowElement(generateSequenceFlow("task2", "inclusiveGateway2", "", ""));
        process.addFlowElement(generateSequenceFlow("task3", "inclusiveGateway2", "", ""));
        process.addFlowElement(generateSequenceFlow("task4", "inclusiveGateway2", "", ""));
        process.addFlowElement(generateSequenceFlow("inclusiveGateway2", "exclusiveGateway1", "", ""));
        process.addFlowElement(generateSequenceFlow("exclusiveGateway1", "task5", "大于等于3天", "${evection.num>=3}"));
        process.addFlowElement(generateSequenceFlow("exclusiveGateway1", "endEvent", "小于3天", "${evection.num<3}"));
        process.addFlowElement(generateSequenceFlow("task5", "endEvent", "", ""));
        new BpmnAutoLayout(bpmnModel).execute();
        //部署流程
        Deployment deploy = repositoryService.createDeployment().addBpmnModel("test1.bpmn", bpmnModel).name("test1").deploy();
        System.out.println("流程名称：" + deploy.getName());
        System.out.println("流程定义ID：" + deploy.getId());
    }

    /*** 生成开始节点* @return*/
    private StartEvent generateStartEvent() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId("startEvent");
        return startEvent;
    }

    /*** 生成任务节点* 不填的项传 ""* @return*/
    private UserTask generateUserTask(String id, String name, String assignee, String candidateUsers, String candidateGroups) {
        List<String> candidateUserList = new ArrayList<>();
        String[] users = candidateUsers.split(",");
        for (String user : users) {
            candidateUserList.add(user);
        }
        List<String> candidateGroupList = new ArrayList<>();
        String[] groups = candidateGroups.split(",");
        for (String group : groups) {
            candidateGroupList.add(group);
        }
        UserTask userTask = new UserTask();
        userTask.setId(id);
        userTask.setName(name);
        userTask.setAssignee(assignee);
        userTask.setCandidateUsers(candidateUserList);
        userTask.setCandidateGroups(candidateGroupList);
        return userTask;
    }

    /*** 创建包含网关* @param id* @return*/
    private InclusiveGateway generateInclusiveGateway(String id) {
        InclusiveGateway inclusiveGateway = new InclusiveGateway();
        inclusiveGateway.setId(id);
        return inclusiveGateway;
    }

    /*** 创建排他网关* @param id* @return*/
    private ExclusiveGateway generateExclusiveGateway(String id) {
        ExclusiveGateway exclusiveGateway = new ExclusiveGateway();
        exclusiveGateway.setId(id);
        return exclusiveGateway;
    }

    /*** 创建连接线* @param from* @param to* @param name* @param conditionExpression* @return*/
    private SequenceFlow generateSequenceFlow(String from, String to, String name, String conditionExpression) {
        SequenceFlow sequenceFlow = new SequenceFlow();
        sequenceFlow.setSourceRef(from);
        sequenceFlow.setTargetRef(to);
        sequenceFlow.setName(name);
        if (StringUtils.isNotEmpty(conditionExpression)) {
            sequenceFlow.setConditionExpression(conditionExpression);
        }
        return sequenceFlow;
    }

    /*** 创建结束节点* @return*/
    private EndEvent generateEndEvent() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId("endEvent");
        return endEvent;
    }
}
