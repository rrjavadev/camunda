package org.camunda.bpm.getstarted.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

public class CalculateResultDelegate implements JavaDelegate {

  public void execute(DelegateExecution execution) {
    Integer i = (Integer) execution.getVariable("element");
    Integer result = i * i;
    execution.setVariable("result", i * i);
    System.out.println("result" + result);

  }
}
