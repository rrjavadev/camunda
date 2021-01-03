package com.camunda.consulting.bpmn_cmmn_example;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.SignalEventReceivedBuilder;

import java.util.logging.Logger;


public class SignalEventListener implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(SignalEventListener.class.getName());

    protected SignalEventReceivedBuilder createSignalEventReceivedBuilder(String name, DelegateExecution delegateExecution) {

//        Map<String, VariableValueDto> variablesDto = dto.getVariables();
//        if (variablesDto != null) {
//            Map<String, Object> variables = VariableValueDto.toMap(variablesDto, processEngine, objectMapper);
//            signalEvent.setVariables(variables);
//        }
        return null;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        RuntimeService runtimeService = delegateExecution.getProcessEngine().getRuntimeService();
        String processInstanceId = delegateExecution.getProcessInstance().getProcessInstanceId();

        String twoStepProcess = "call_two_step_process_" + processInstanceId;
        LOGGER.info("process instance id" + twoStepProcess);

        String sendCorrespondence = "sendCorrespondence_" + processInstanceId;
        LOGGER.info("process instance id" + sendCorrespondence);

        SignalEventReceivedBuilder signalEvent1 = runtimeService.createSignalEvent(twoStepProcess);
        SignalEventReceivedBuilder signalEvent2 = runtimeService.createSignalEvent(sendCorrespondence);
        signalEvent1.send();
        signalEvent2.send();
    }
}
