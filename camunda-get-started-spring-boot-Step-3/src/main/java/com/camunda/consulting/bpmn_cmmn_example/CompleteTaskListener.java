package com.camunda.consulting.bpmn_cmmn_example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.util.logging.Logger;

/**
 * This is an empty service implementation illustrating how to use a plain Java
 * class as a BPMN 2.0 Service Task delegate.
 */
@Named("logger")
public class CompleteTaskListener implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(CompleteTaskListener.class.getName());

    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("\n\n  ... CompleteTaskListener invoked by "
                + "processDefinitionId=" + execution.getProcessDefinitionId()
                + ", activtyId=" + execution.getCurrentActivityId()
                + ", activtyName='" + execution.getCurrentActivityName() + "'"
                + ", processInstanceId=" + execution.getProcessInstanceId()
                + ", businessKey=" + execution.getProcessBusinessKey()
                + ", executionId=" + execution.getId()
                + " \n\n");

        execution.setVariable("letterSent", true);
    }

}
