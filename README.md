# JMicronaut

sample backend using Micronaut, Micronaut Data JDBC, and Flyway DB

## Pre-requisites
- java 25

## How to run
1. execute `./mvnw mn:run`
2. db migration is executed automatically including seed data (disable this on `application.yml` if not needed)
3. call the api endpoint `curl http://localhost:8080/persons`

## Tests
1. make sure main dependencies are installed
2. execute `./mvnw test`

## Data Model

```mermaid
---
config:
  layout: dagre
  look: handDrawn
title: ERD
---
erDiagram
	person {
		int id PK ""  
		String last_name  ""  
		String first_name  ""  
		String country_code FK ""  
		timestamp updated_at  ""  
		timestamp created_at  ""  
	}
	country {
		String code PK ""  
		String name  ""  
		int phone  ""  
		String symbol  ""  
		String capital  ""  
		String currency  ""  
		String continent_code FK ""  
		String alpha_3  ""  
		timestamp updated_at  ""  
		timestamp created_at  ""  
	}
	continent {
		String code PK ""  
		String name  ""  
	}
	person}|--||country:"residesIn"
	country}|--||continent:"belongsTo"
```

