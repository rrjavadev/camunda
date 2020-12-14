package com.camunda.demo.underwriting.listener;

import org.camunda.bpm.engine.delegate.CaseExecutionListener;
import org.camunda.bpm.engine.delegate.DelegateCaseExecution;

import java.util.logging.Logger;

public class CloseCaseInstanceListener2 implements CaseExecutionListener {
  
  private Logger LOG = Logger.getLogger(CloseCaseInstanceListener2.class.getName());

  @Override
  public void notify(DelegateCaseExecution caseExecution) throws Exception {
//    LOG.info(" --- Close Case ---");
//
//    String caseInstanceId = caseExecution.getCaseInstanceId();
//    caseExecution.getProcessEngineServices().getCaseService().closeCaseInstance(caseInstanceId);
  }
}
