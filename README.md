1.	How to do this application?

	+	Apply Spring Boot to quickly build a web application that provided RESTful API services (requirement).
	
	+	Choose MongoDB for store data as it can support high volumes of reading and writing requests with small payloads and be highly available and performant and free. 		Besides that, this is a simple project at this moment but it will become a medium or big project later with a lot of Objects do not mention on this one so that we 		 can easy to expand in the future.
	
2.	How to build and run the application?

	There are 3 ways to build this application:
	
	+	Clone project from github, open a command line (or terminal) and navigate to the folder where you have the project files. We can build and run the application by 		issuing the following command:
	
			MacOS/Linux:		./mvnw spring-boot:run
			
			Windows:		mvnw spring-boot:run
			
	+	Build to .jar file and run by java –jar command.
	+	I have a plan to use Docker for deployment but it is new technology with me and ask for more time to research and implement. So that I will owe this one can will 		self-study it when I have free time.

3.	This project is simple for this moment so that I just applied MVC pattern:

	+	Help create a stand-alone application based on Spring that can run java – jar
	+	There is less configuration, capable of automatically reconfiguring Spring when needed, thereby helping members save time coding and increase productivity.
	+	Keep full features of Spring Framework
	+	Spring boot does not require XML configurations and does not generate configuration code
	+	No need to deploy WAR files, but directly embed server applications

4.	I have spent to develop this solution as:
	+	Preparation: 30 minutes 
	+	Coding: 3 hours (including tests)
	+	Documentation: 10 minutes 
	+	Building and testing: 30 minutes
	+	Grand total: 4 hours 10 minutes

5. 	References:

	1.	https://www.mongodb.com/compatibility/spring-boot
	2.	https://www.devglan.com/spring-boot/spring-boot-mongodb-crud
	3.	https://spring.io/guides/gs/testing-web/ 
