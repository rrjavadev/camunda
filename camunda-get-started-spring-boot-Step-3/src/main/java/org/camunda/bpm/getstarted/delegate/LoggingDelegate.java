package org.camunda.bpm.getstarted.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

public class LoggingDelegate implements ExecutionListener {
  @Override
  public void notify(DelegateExecution execution) {
    System.out.println("\nLOCAL VARIABLES:");
    execution.getVariablesLocal().forEach((key, value) -> System.out.println(key + ": " + value));

    System.out.println("\nVARIABLES:");
    execution.getVariables().forEach((key, value) -> System.out.println(key + ": " + value));
  }
}
