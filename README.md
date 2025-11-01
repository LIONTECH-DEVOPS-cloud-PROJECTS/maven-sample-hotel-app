# Hotel Management App (Servlet/JSP + H2)

A tiny learning project that mimics a hotel system:
- Manage **Rooms**, **Guests**, and **Bookings**
- Built with **Maven**, packaged as a **WAR**
- Deploy on **Tomcat 9**
- Code coverage via **JaCoCo**, analysis via **SonarQube**
- Publish artifacts to **Nexus**

## Quick start
```bash
# 1) Build & test
mvn clean verify

# 2) Run SonarQube analysis (example)
# Create a token in SonarQube, then:
mvn -Dsonar.host.url=http://localhost:9000     -Dsonar.login=$SONAR_TOKEN     sonar:sonar

# 3) Package WAR
mvn package

# 4) Deploy to Tomcat (option A: copy war)
# Copy target/hotel-app.war to TOMCAT_HOME/webapps and start Tomcat

# 4) Deploy to Tomcat (option B: maven plugin)
mvn org.apache.tomcat.maven:tomcat7-maven-plugin:2.2:deploy \
  -Dtomcat.url=http://localhost:8080/manager/text \
  -Dusername=manager \
  -Dpassword=secret
# App context will be /hotel (see pom.xml)
```

Open: http://localhost:8080/hotel/

## SonarQube tips
- JaCoCo is wired to generate coverage during `mvn test`
- For a multi-branch setup, add properties (key, projectName) via `-D` or `sonar-project.properties`

## Nexus deployment
Edit `pom.xml` `<distributionManagement>` to match your Nexus 3 repositories.

Create `~/.m2/settings.xml` with credentials (do **not** commit):
```xml
<settings>
  <servers>
    <server>
      <id>nexus-releases</id>
      <username>REPLACE_ME</username>
      <password>REPLACE_ME</password>
    </server>
    <server>
      <id>nexus-snapshots</id>
      <username>REPLACE_ME</username>
      <password>REPLACE_ME</password>
    </server>
    <server>
      <id>tomcat</id>
      <username>manager</username>
      <password>secret</password>
    </server>
  </servers>
</settings>
```

Publish to Nexus:
```bash
# Release
mvn -P release deploy

# Snapshot
mvn -DskipTests deploy
```

## What it does
- On startup, an **AppBootstrap** listener creates schema and inserts sample data in an **H2** in-memory DB.
- Three servlets render JSPs:
  - `/rooms` – list/add rooms
  - `/guests` – list/add guests
  - `/bookings` – list/create bookings

## Tech notes
- Targets **Tomcat 9** (Servlet API 4.x / javax.*). For Tomcat 10+, switch to the jakarta.* APIs.
- Keep it simple: JDBC + H2. In a real app, you’d use a connection pool, JPA/Hibernate, auth, validations, etc.

## Next steps (exercises)
- Add CRUD edit/delete actions
- Add validation and better error handling
- Add availability check to prevent overlapping bookings
- Add pagination & search
- Switch H2 to file mode for persistence
- Add integration tests with a test container Tomcat
```



**Note:** This project uses an in-memory H2 database only—no MySQL required.
