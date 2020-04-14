# Refrigerator-Service
"You better catch it :)"
## Design Overview

## Setup
### Prerequisites
- Java 14
- Docker
### Running Locally
- docker-compose -f docker-compose.local.yml up
### Running Tests
- docker-compose -f docker-compose.local.yml up

## Design Critique
Being a person with a lighter service background, I've never
been a big fan of Java EE related stuff (which in my mind includes
spring to an extent), but I decided to be a little more conservative
developing the following. Looking back, I probably would have been
better off using a noSQL database due to the hierarchical structure of 
the data model (and most likely the need for storage flexibility).