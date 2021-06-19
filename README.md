# taco
The source code is referenced from the book &lt;Spring In Action, 5th Edition>

I've customized some components and added some features including distribution, modularization, containerization and so forth. 

If you want to start it, make sure that the configurations in application.yml files or application.properties files are fit for your environment. You can simply test it in VSCode with the related plugins like "Java Extension Pack", "Spring Boot Extension Pack", "Lombok Annotations Support for VSCode" and so forth. In spring dashboard, you need first to start the "config" module and the "registry" module before others. With these in place, you are able to access the eureka server at localhost:8761. Now you can start the "ingredients" module and "service" module step by step. But if the kafka node is unaccessable, the config server will not be able to send configuration messages to all of those components so that the "ingredients" module will be exposed at default port 8080 not 8086 defined in "/properties/ingredient-api.yml". You will observe that the logs in console of these components will be full of noises like this "Connection to node -1 (localhost/127.0.0.1:9092) could not be established. Broker may not be available."

For security, I've been keeping it private before. Because the unencoded password in the application.yml files maybe remains in the commit history. But now I need to show it for finding a job.

~~ However, I've never eat tacos yet ~~
