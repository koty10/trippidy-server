# Trippidy Server
This is a server for the Trippidy mobile and web app.

# Full Instalation Prerequisities
- Docker
- Docker Compose
- Maven
- Public IP address
- Registered domain with the A record set to your public IP address
- Allow port forwarding of the port 9680 to the port 9680, optionaly also the port 80 to the port 80

# Full Instalation
- Go to the trippidy folder
- Change values in init-letsencrypt.sh to yours. Namely, domain and email values
- Run `init-letsencrypt.sh` to get a certificate from Let's Encrypt
- Copy config.properties.example to config.properties and fill your secret key for OpenAI API. If needed, I can provide mine by email.
- Run `mvn clean package` to build a project
- Run `docker-compose up` to start all containers
- To setup CI/CD using Jenkins, it would be needed to manually configure the Jenkins server and add a Webhook to GitHub. The Jenkins server is running on https://your.domain:9680/jenkins/

# Localhost Instalation
- Go to the trippidy folder
- Comment the Nginx container from docker-compose.yml and also uncomment "9680:8080" port binding for trippidy-payara container
- Comment cz.cvut.fel.trippidy.service.SuggestionService and cz.cvut.fel.trippidy.resource.SuggestionResource files if you do not want to use OpenAI API
