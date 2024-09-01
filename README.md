# Task-Tracker-CLI
Java solution for the [task-tracker](https://roadmap.sh/projects/task-tracker) challenge from [roadmap.sh](https://roadmap.sh/).

## How to run

Open your terminal of choice and run the following commands:

```bash
git clone https://github.com/dylancrter/Task-Tracker-CLI.git
cd Task-Tracker-CLI
```

If your machine isn't running Java 22, replace 22 with your version in the following pom.xml lines:

```xml
<maven.compiler.source>22</maven.compiler.source>
<maven.compiler.target>22</maven.compiler.target>
```

Run the following command to build the project:

```bash
mvn clean package
```

Lastly, run this command to run the application:

```bash
java -jar target/Task-Tracker-CLI-1.0-SNAPSHOT.jar <arguments>
```
