# Citizen Intelligence Agency

Tracking politicians like bugs. Citizen Intelligence Agency is independent and non-partisan voluntary project.


[![license](https://img.shields.io/github/license/Hack23/cia.svg)](https://raw.githubusercontent.com/Hack23/cia/master/citizen-intelligence-agency/LICENSE.txt)
[![Maven Central](https://img.shields.io/maven-central/v/com.hack23.cia/cia-dist-deb.svg)](http://mvnrepository.com/artifact/com.hack23.cia/cia-dist-deb)
[![Jenkins](https://img.shields.io/jenkins/s/https/www.hack23.com/jenkins/view/SystemQualityAssesment/job/Citizen-Intelligence-Agency-Complete-site-sonar-report.svg)](https://www.hack23.com/jenkins/)
[![Jenkins tests](https://img.shields.io/jenkins/t/https/www.hack23.com/jenkins/view/SystemQualityAssesment/job/Citizen-Intelligence-Agency-Complete-site-sonar-report.svg)](https://www.hack23.com/jenkins/job/Citizen-Intelligence-Agency-Complete-site-sonar-report/lastCompletedBuild/testReport/)
[![SonarQube Coverage](https://www.hack23.com/sonar/api/badges/measure?key=com.hack23.cia%3Acia-all&metric=coverage)](https://www.hack23.com/sonar/component_measures/domain/Coverage?id=com.hack23.cia%3Acia-all)
[![SonarQube Tech Debt](https://www.hack23.com/sonar/api/badges/measure?key=com.hack23.cia%3Acia-all&metric=sqale_debt_ratio)](https://www.hack23.com/sonar/component_measures?id=com.hack23.cia%3Acia-all)
[![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/770/badge)](https://bestpractices.coreinfrastructure.org/projects/770)
[![CodeFactor](https://www.codefactor.io/repository/github/hack23/cia/badge)](https://www.codefactor.io/repository/github/hack23/cia)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c4eb92f487d34c19887c8acec110fb6f)](https://www.codacy.com/app/pethers/cia?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Hack23/cia&amp;utm_campaign=Badge_Grade)
[![Maintainability](https://api.codeclimate.com/v1/badges/14cc2db98322e8338ef1/maintainability)](https://codeclimate.com/github/Hack23/cia/maintainability)
[![BCH compliance](https://bettercodehub.com/edge/badge/Hack23/cia?branch=master)](https://bettercodehub.com/results/Hack23/cia)
[![codebeat badge](https://codebeat.co/badges/5a7cf18f-68cb-4535-b197-8b541bf9bb7c)](https://codebeat.co/projects/github-com-hack23-cia-master)
[![Black Duck Security Risk](https://copilot.blackducksoftware.com/github/repos/Hack23/cia/branches/master/badge-risk.svg)](https://copilot.blackducksoftware.com/github/repos/Hack23/cia/branches/master)

# Goal

Visualize political activity in Sweden, present key performance indicators and metadata for the actors on national level.


# Demo https://www.hack23.com/cia/

Still prototype, live demo running at [https:/www.hack23.com/cia/](https:/www.hack23.com/cia/).

Using open data from  [http://data.riksdagen.se/](http://data.riksdagen.se/) , [http://www.val.se/](http://www.val.se/) and [http://data.worldbank.org/](http://data.worldbank.org/) .

Currently the application displays data, metadata and charts for data related to Swedish parliament and government. Covering parliament members, committees, documents, ballots, decisions, ministries, government members and political parties.

Limited functionality proper navigation, descriptions,content, ui and styling are still not in place.



# Roadmap

Plan to make it public some time after 2018.04, running Ubuntu 18.04, Postgresql 10.x, JDK10, Spring framework 5.x , Hibernate 6.x, Vaadin 8.x


#Resources

Project documentation [http://hack23.github.io/cia/](http://hack23.github.io/cia//)

Project Architecture [http://hack23.github.io/cia/architecture.html](http://hack23.github.io/cia/architecture.html)

Project Architecture(old) [https://structurizr.com/share/37264#Enterprise](https://structurizr.com/share/37264#Enterprise)

Github source code location [https://github.com/Hack23/cia](https://github.com/Hack23/cia)

Build server, jenkins [https://www.hack23.com/jenkins/](https://www.hack23.com/jenkins/)

QA report, sonarqube [https://www.hack23.com/sonar/](https://www.hack23.com/sonar/)

Repository manager, nexus [https://www.hack23.com/nexus/](https://www.hack23.com/nexus/)

# Parlimentary informatics

[https://en.wikipedia.org/wiki/Parliamentary_informatics](https://en.wikipedia.org/wiki/Parliamentary_informatics) list many good examples of other projects in the domain around the world.

USA
[https://www.govtrack.us/](https://www.govtrack.us/)

Canada
[http://OpenParliament.ca](http://OpenParliament.ca)

European Union
[http://www.votewatch.eu/](http://www.votewatch.eu/)

Sweden
[http://govdata.se/api](http://govdata.se/api)

[http://riksdagsskolket.se/](http://riksdagsskolket.se/)

[http://www.demokratikollen.se](http://www.demokratikollen.se)


Denmark
[http://www.hvemstemmerhvad.dk/](http://www.hvemstemmerhvad.dk/)

Finland
[http://kansanmuisti.fi/](http://kansanmuisti.fi/)

Norway
[https://www.holderdeord.no/](https://www.holderdeord.no/)

UK
[https://www.theyworkforyou.com/](https://www.theyworkforyou.com/)
[http://www.publicwhip.org.uk/](http://www.publicwhip.org.uk/)

Germany
[http://offenesparlament.de](http://offenesparlament.de)

Italy
[http://parlamento17.openpolis.it/](http://parlamento17.openpolis.it/)

France
[https://www.nosdeputes.fr/](https://www.nosdeputes.fr/)

Colombia
[http://www.congresovisible.org/](http://www.congresovisible.org/)

Jordanian
[http://www.jpm.jo/](http://www.jpm.jo/)

South Korea
[http://pokr.kr/](http://pokr.kr/)

Israel
[https://oknesset.org/](https://oknesset.org/)



# Installing Debian/Ubuntu package

 Currently only build a debian package, works with debian and ubuntu 14.04,16.04,16.10


1. Installing database(postgres) and openjdk

```
$ sudo apt-get install openjdk-8-jdk postgresql pgadmin3
```


2. Installing Oracle JDK 8 on Ubuntu

First you need to add webupd8team Java PPA repository in your system and install Oracle Java 8 using following set of commands.

```
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java9-installer oracle-java8-installer oracle-java8-unlimited-jce-policy
```

3. Create empty database

Below description set the default username/password and database name used for development, recommend using custom credentials and update the configuration at /opt/cia/webapps/cia/WEB-INF/database.properties to define your own username/password and database name.

```
$ sudo su - postgres
$ psql
postgres=# CREATE USER eris WITH password 'discord';
postgres=# CREATE DATABASE cia_dev;
postgres=# GRANT ALL PRIVILEGES ON DATABASE cia_dev to eris;
```

4. Modify postgres setting, enable prepared transactions

Edit file "/etc/postgresql/9.6/main/postgresql.conf" set

```
max_prepared_transactions = 100
```


5. Modify postgres setting
Edit file "/etc/postgresql/9.6/main/pg_hba.conf" add line

```
host all all ::1/128 md5
```


6. Restart postgres

```
$ service postgresql restart
```

7. Get cia debian package and


```
$ wget https://oss.sonatype.org/content/repositories/releases/com/hack23/cia/cia-dist-deb/2018.2.25/cia-dist-deb-2018.2.25.deb
```


8. Install debian package

```
$ sudo dpkg -i cia-dist-deb-2018.2.25.deb
```


9. Access the server at [https://localhost:28443/cia/](https://localhost:28443/cia/) .


# Application package diagram overview

![Package overview diagram](https://www.hack23.com/jenkins/job/Citizen-Intelligence-Agency-Complete-Javadoc/lastSuccessfulBuild/artifact/citizen-intelligence-agency/target/apidocs/overview-summary.png)
[Api docs](https://www.hack23.com/jenkins/job/Citizen-Intelligence-Agency-Complete-Javadoc/lastSuccessfulBuild/artifact/citizen-intelligence-agency/target/apidocs/index.html)


# Cloudformation template diagram

[![Cloudformation](https://www.hack23.com/jenkins/job/Citizen-Intelligence-Agency-dist-cloudformation/lastSuccessfulBuild/artifact/cia-dist-cloudformation/target/cia-dist-cloudformation.svg)](https://www.hack23.com/jenkins/job/Citizen-Intelligence-Agency-dist-cloudformation/lastSuccessfulBuild/artifact/cia-dist-cloudformation/target/cia-dist-cloudformation.svg)
