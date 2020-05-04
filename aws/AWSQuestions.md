# AWS Questions

## What's AWS Lambda layer? 

A Lambda Layer is a ZIP archive / file that contains code and can be imported by Lambda functions. They are extracted to /opt folder in a Lambda function execution environment.

## What's an AWS lambda function? What is a handler in a lambda function?

## Why do we need task definition in Amazon ECS?

A task definition is required to run Docker containers in Amazon ECS. 

## How does one use task to run docker image in  Amazon ECS? 

1. Build you image
2. Push image to registry.
3. Create JSON file describing your task definition.
4. Register this task definition with ECS.
5. Make sure that your cluster has enough resources.
6 Start a new task from the task definition.