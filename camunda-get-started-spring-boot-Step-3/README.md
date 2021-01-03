# camunda BPM - Getting Started with camunda BPM and Spring Boot

This Repository contains the example Spring Boot application for the guide at [camunda.org](http://camunda.org/get-started/spring-boot.html).

Every step of the tutorial was tagged in this repository. You can jump to the final state of each step
by the following command:

```
git checkout -f Step-X
```

If you want to follow the tutorial along please clone this repository and checkout the `Start` tag.

```
git clone https://github.com/camunda/camunda-get-started-spring-boot.git
git checkout -f Start
```

```
//Send message
POST http://localhost:8085/engine-rest/message
{"messageName" : "all_risks_processed",
"businessKey" : "3456",
"processVariables" : {
    "allTasksFinished" : {"value" : true, "type": "Boolean"}
}
}

//returns the process instance id
GET http://localhost:8085/engine-rest/history/process-instance?processInstanceBusinessKey=3456&processDefinitionKey=taskApproval&unfinished=true

//Signal to process the task
POST http://localhost:8085/engine-rest/signal
{
  "name": "call_two_step_process_592ea7b5-46fa-11eb-999d-e64bf7089c99",
  "variables": {
    "newTimePeriodInMonth": {
      "value": 24
    }
  }
}

```

License: The source files in this repository are made available under the [Apache License Version 2.0](./LICENSE).