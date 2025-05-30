package com.camunda.onboarding;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LoggingDelegateApiCalls implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(LoggingDelegateApiCalls.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
//        LOGGER.info("\n\n  ... logging invoked by "
//                + "processDefinitionId=" + execution.getProcessDefinitionId()
//                + ", activtyId=" + execution.getCurrentActivityId()
//                + ", activtyName='" + execution.getCurrentActivityName() + "'"
//                + ", processInstanceId=" + execution.getProcessInstanceId()
//                + ", businessKey=" + execution.getProcessBusinessKey()
//                + ", executionId=" + execution.getId()
//                + " \n\n");
        String businessKey = execution.getProcessBusinessKey();
        if ("success".equals(businessKey)) {
            LOGGER.info("Successfully completed " + execution.getCurrentActivityName());
//            LOGGER.info("Input Variables: " + execution.getVariables());
        } else if ("Handle Exception".equals(execution.getCurrentActivityName())) {
            LOGGER.info("Exception handled!");
        } else if ("fail".equals(businessKey)) {
            LOGGER.info(execution.getCurrentActivityName() + " failed!");
            throw new BpmnError(execution.getCurrentActivityId() + " failed", "An error has occurred while making the api call. Please retry.");
        }
    }
}
