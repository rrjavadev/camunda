/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.CaseService;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.CaseExecution;
import org.camunda.bpm.engine.runtime.CaseInstance;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
@EnableProcessApplication
@ComponentScan("org.camunda.bpm.getstarted.controller")
public class WebappExampleProcessApplication {

  @Autowired
  private RuntimeService runtimeService;

  public static void main(String... args) {
    SpringApplication.run(WebappExampleProcessApplication.class, args);
  }

  @Autowired
  ProcessEngine processEngine;

  @EventListener
  private void processPostDeploy(PostDeployEvent event) {
//    runtimeService.startProcessInstanceByKey("loanApproval");
//    runtimeService.startProcessInstanceByKey("main_process");

    evaluateDecisionTable(processEngine);
  }

  @PostDeploy
  public void evaluateDecisionTable(ProcessEngine processEngine) {
//
//    DecisionService decisionService = processEngine.getDecisionService();
//
//    VariableMap variables = Variables.createVariables()
//            .putValue("season", "Spring")
//            .putValue("guestCount", 10);
//
//    DmnDecisionTableResult dishDecisionResult = decisionService.evaluateDecisionTableByKey("dish", variables);
//    String desiredDish = dishDecisionResult.getSingleEntry();
//
//    System.out.println("Desired dish: " + desiredDish);
//
//    CaseService caseService = processEngine.getCaseService();



//    caseService.createCaseInstanceByKey("underwriting",
//            Variables.createVariables()
//                    .putValue("applicationSufficient", Variables.booleanValue(null))
//                    .putValue("rating", Variables.integerValue(null)));

//    CaseInstance caseInstance = caseService
//            .withCaseDefinitionByKey("underwriting")
//            .setVariable("customerName", "customerName")
//            .setVariable("other", true)
//            .setVariable("score", 70)
//            .create();

//    CaseExecution stageExecution = caseService.createCaseExecutionQuery()
//            .caseInstanceId(caseInstance.getId())
//            .activityId("PI_humanTaskThereIsMore")
//            .singleResult();
//
//    caseService.withCaseExecution(stageExecution.getId())
//            .manualStart();
// ***************
//    List<CaseExecution> stageExecution1 = caseService.createCaseExecutionQuery()
//            .caseInstanceId(caseInstance.getId())
//            .activityId("PI_humanTaskThereIsMore").list();
//
//    caseService.withCaseExecution(stageExecution1.get(0).getId())
//            .execute();
    //************


    /*
    // create a new case instance
    CaseInstance caseInstance = caseService
      .withCaseDefinitionByKey("loanApplication")
      .setVariable("applicantId", "some id ...")
      .create();
    // as a result, the stage and the tasks are enabled.

    // Query for the stage execution
    CaseExecution stageExecution = caseService.createCaseExecutionQuery()
      .caseInstanceId(caseInstance.getId())
      .activityId("PI_Stage_1")
      .singleResult();

    // start the stage
    caseService.withCaseExecution(stageExecution.getId())
      .manualStart();

    // now the "Review Documents" task is enabled:
    CaseExecution reviewDocumentsExecution = caseService.createCaseExecutionQuery()
      .activityId("PI_HumanTask_4")
      .enabled()
      .singleResult();

    // start the review documents task:
    caseService.withCaseExecution(reviewDocumentsExecution.getId())
      .manualStart();

    // complete the review documents task:
    caseService.withCaseExecution(reviewDocumentsExecution.getId())
      .setVariable("allDocumentsObtained", true)
      .complete();

     */
  }
}