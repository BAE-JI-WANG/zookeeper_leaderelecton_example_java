# zookeeper_leaderelecton_example_java

## Description
This project is an example of testing zookeeper's leaderelection

## Requirement
- java(zookeeper) : 1.8
- java(run jar) : up to 17
- zookeeper : 3.7.2

## Configuring your environment

### Install SDKMAN (Java version management tool)

Install SDKMAN
```
curl -s "https://get.sdkman.io" | bash
```

Set Environment
```
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

Verifying Version & Installation
```
sdk version
```

### Install Zookeeper

Download & unzip
```
wget https://dlcdn.apache.org/zookeeper/zookeeper-3.7.2/apache-zookeeper-3.7.2-bin.tar.gz
tar xvzf apache-zookeeper-3.7.2-bin.tar.gz
mv apache-zookeeper-3.7.2-bin zookeeper
cd zookeeper
```

Set ZK_HOME
```
echo "export ZK_HOME=$(pwd)" >> ~/.bashrc && source ~/.bashrc
```

Verifying Settings
```
echo $ZK_HOME
```

Install Java 1.8 & 17
```
sdk list java

## Choose the version 1.8 and 17 or more, respectively
sdk install java 17.x.xx xxxx
sdk install java 1.8.xx xxxx
```


### Configuration zookeeper for single mode

Edit zoo.cfg
```
cd cd $ZK_HOME/conf
cp zoo_sample.cfg zoo.cfg
vim zoo.cfg

## line 12 Edit Path
...
dataDir = ${Set your Data directory path}
...

## line 33 ~ 35 Remove comments
...
metricsProvider.className=org.apache.zookeeper.metrics.prometheus.PrometheusMetricsProvider
metricsProvider.httpPort=7000
metricsProvider.exportJvmInfo=true
...

```

### Start zookeeper
```
cd $ZK_HOME
sdk use java 1.8.xx xxxx
./bin/zkServer.sh start conf/zoo.cfg
```

### Project build
```
cd ${clone directory}/leaderelection
./gradlew build
./gradlew shadowJar
```

### Start build project
```
sdk use java java 17.x.xx xxxx
java -jar build/libs/leaderelection-0.0.1-SNAPSHOT-all.jar
```
