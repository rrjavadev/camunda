package org.camunda.bpm.getstarted.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LoggingDelegateApiCalls implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(LoggingDelegateApiCalls.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("\n\n  ... logging invoked by "
                + "processDefinitionId=" + execution.getProcessDefinitionId()
                + ", activtyId=" + execution.getCurrentActivityId()
                + ", activtyName='" + execution.getCurrentActivityName() + "'"
                + ", processInstanceId=" + execution.getProcessInstanceId()
                + ", businessKey=" + execution.getProcessBusinessKey()
                + ", executionId=" + execution.getId()
                + " \n\n");

    }
}
