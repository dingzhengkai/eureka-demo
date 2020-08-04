# eureka demo

## single

```bash
$ cd eureka-single

$ mvn dependency:resolve
$ mvn dependency:get
$ mvn clean compile

$ cd eureka-server
$ mvn exec:java -Dexec.mainClass="com.example.server.EurekaServer"

$ cd eureka-service-provider
$ mvn exec:java -Dexec.mainClass="com.example.service.provider.SingleProviderApplication"

$ cd eureka-service-consumer
$ mvn exec:java -Dexec.mainClass="com.example.service.consumer.SingleConsumerApplication"
```

## ha

```bash
$ cd eureka-ha

$ mvn dependency:resolve
$ mvn dependency:get
$ mvn clean compile

$ cd eureka-ha-server
$ mvn exec:java -Dexec.mainClass="com.example.eureka.ha.server.EurekaServer" -Dspring.profiles.active=eureka-center1
$ mvn exec:java -Dexec.mainClass="com.example.eureka.ha.server.EurekaServer" -Dspring.profiles.active=eureka-center2

$ cd eureka-ha-provider
$ mvn exec:java -Dexec.mainClass="com.example.eureka.ha.provider.Application" -Dspring.profiles.active=ha-provider1
$ mvn exec:java -Dexec.mainClass="com.example.eureka.ha.provider.Application" -Dspring.profiles.active=ha-provider2

$ cd eureka-ha-consumer
$ mvn exec:java -Dexec.mainClass="com.example.eureak.ha.consumer.Application"
```
