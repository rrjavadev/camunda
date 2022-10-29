package com.camunda.onboarding;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class LoggingExecutionListener implements ExecutionListener {

  @Override
  public void notify(DelegateExecution execution) {

    System.out.println("Publisher onboarding process has completed! Final Status: " + execution.getProcessBusinessKey());

//    System.out.println("\nLOCAL VARIABLES:");
//    execution.getVariablesLocal().forEach((key, value) -> System.out.println(key + ": " + value));

    System.out.println("\nVARIABLES:");
    execution.getVariables().forEach((key, value) -> System.out.println(key + ": " + value));
  }
}
