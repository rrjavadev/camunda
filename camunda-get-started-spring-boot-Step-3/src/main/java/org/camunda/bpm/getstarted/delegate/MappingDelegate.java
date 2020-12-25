package org.camunda.bpm.getstarted.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;

public class MappingDelegate implements DelegateVariableMapping {
  @Override
  public void mapInputVariables(DelegateExecution superExecution, VariableMap subVariables) {
    subVariables.putValue("element", superExecution.getVariable("element"));
  }

  @Override
  public void mapOutputVariables(DelegateExecution superExecution, VariableScope subInstance) {
    System.out.println("**************  result added");
    superExecution.setVariableLocal("result", subInstance.getVariable("result"));
  }
}
