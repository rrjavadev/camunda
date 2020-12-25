package org.camunda.bpm.getstarted.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.model.cmmn.instance.UserEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UnderwritingController {

    private ProcessEngine processEngine;
    protected final RuntimeService runtimeService;
    protected final RepositoryService repositoryService;
    private TaskService taskService;

    public UnderwritingController(RuntimeService runtimeService, RepositoryService repositoryService,
                                  ProcessEngine processEngine,
                                  TaskService taskService) {
        this.runtimeService = runtimeService;
        this.repositoryService = repositoryService;
        this.processEngine = processEngine;
        this.taskService = taskService;
    }

    @PostMapping("/process")
    public void setScore(@RequestParam("instanceId") String processInstanceId) {

        List<Task> taskServices = taskService.createTaskQuery().caseInstanceId(processInstanceId).list();
//        processEngine.getCaseService().withCaseExecution(processInstanceId)
//                .setVariableLocal("score", 1)
//                .setVariable("score", 1).execute();

       //s processEngine.getTaskService().setVariable();

        runtimeService.setVariable(processInstanceId, "score", 49);
    }

    @GetMapping("/latest-definitions")
    public List<String> latestDefinitions() {


        return repositoryService.createProcessDefinitionQuery()
                .latestVersion()
                .list()
                .stream()
                .map(ProcessDefinition::getId)
                .collect(Collectors.toList());
    }

}
