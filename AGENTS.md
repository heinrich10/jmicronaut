# JMicronaut

A sample RESTful backend API built with the Micronaut framework. It demonstrates a typical CRUD application using Micronaut Data JDBC, Flyway database migrations, and an embedded H2 database.

## Technology Stack

- **Language**: Java 25
- **Framework**: Micronaut 4.10.6
- **Build Tool**: Maven (wrapper included)
- **Runtime**: Netty (micronaut-http-server-netty)
- **Database**: H2 in-memory database
- **Data Access**: Micronaut Data JDBC with Hikari connection pool
- **Migrations**: Flyway
- **Serialization**: Micronaut Serde (Jackson)
- **Validation**: Jakarta Bean Validation (micronaut-validation)
- **Testing**: JUnit 5 with Micronaut Test
- **Logging**: Logback
- **Code Coverage**: JaCoCo
- **API Documentation**: OpenAPI (micronaut-openapi)

## Project Structure

```
src/main/java/org/heinrich10/
├── Application.java              # Entry point; also starts H2 web console
├── controllers/                  # REST API controllers
│   ├── ContinentController.java
│   ├── CountryController.java
│   └── PersonController.java
├── models/                       # Entity / domain models
│   ├── Continent.java
│   ├── Country.java
│   └── Person.java
├── repositories/                 # Micronaut Data JDBC repositories
│   ├── ContinentRepository.java
│   ├── CountryRepository.java
│   └── PersonRepository.java
└── requests/                     # Request DTOs for validation & binding
    ├── BasePersonRequest.java
    ├── CreatePersonRequest.java
    └── UpdatePersonRequest.java

src/main/resources/
├── application.properties        # Datasource & Flyway config
├── logback.xml                   # Logging configuration
└── db/migration/
    ├── V1__schema.sql            # DDL: continent, country, person tables
    └── V2__seed.sql              # Seed data: continents, countries, sample persons

src/test/java/org/heinrich10/
├── ApplicationTest.java
├── controllers/                  # HTTP client integration tests
│   ├── ContinentControllerTest.java
│   ├── CountryControllerTest.java
│   └── PersonControllerTest.java
└── repositories/
    └── PersonRepositoryTest.java # Direct repository CRUD test

src/test/resources/
└── application-test.properties   # Test-specific datasource & Flyway overrides

http/                             # IntelliJ HTTP Client request files
├── person.http
├── country.http
├── continent.http
└── http-client.env.json
```

## Build and Run Commands

```bash
# Run the application (development)
./mvnw mn:run

# Build the project and create the JAR
./mvnw clean package

# Run all tests
./mvnw test

# Generate code coverage report (JaCoCo)
# Executed automatically during the prepare-package phase of `mvnw package`
```

The application starts on port `8080` by default. The H2 web console is also started programmatically in `Application.java` (`Server.createWebServer().start()`).

## API Overview

| Resource   | Endpoint         | Description                  |
|------------|------------------|------------------------------|
| Persons    | `GET /persons`   | Paginated list of persons    |
| Persons    | `GET /persons/{id}` | Get a single person       |
| Persons    | `POST /persons`  | Create a new person          |
| Persons    | `PUT /persons/{id}` | Update an existing person |
| Countries  | `GET /countries` | Paginated list of countries  |
| Countries  | `GET /countries/{code}` | Get a single country   |
| Continents | `GET /continents`| List all continents          |
| Continents | `GET /continents/{code}` | Get a single continent  |

## Data Model

Three main entities with simple foreign-key relationships:

- **Continent** (`code` PK, `name`)
- **Country** (`code` PK, `name`, `phone`, `symbol`, `capital`, `currency`, `continent_code` FK, `alpha_3`, timestamps)
- **Person** (`id` auto-increment PK, `first_name`, `last_name`, `country_code` FK, timestamps)

## Code Style and Conventions

- **Base package**: `org.heinrich10` (note: `micronaut-cli.yml` still lists `com.example` as the default package from project generation, but all source code lives under `org.heinrich10`).
- **Constructor injection** is used throughout; no `@Autowired` on fields.
- Controllers are annotated with `@ExecuteOn(TaskExecutors.BLOCKING)` because they perform blocking JDBC operations.
- Entity classes use standard JavaBean getters/setters with Micronaut Data annotations (`@MappedEntity`, `@Id`, `@GeneratedValue`, `@DateCreated`, `@DateUpdated`).
- Request DTOs extend a shared base class (`BasePersonRequest`) and use Jakarta Validation annotations (`@NotNull`, `@NotBlank`).
- Repositories are interfaces extending `PageableRepository` (or `CrudRepository` for `Continent`) and annotated with `@JdbcRepository(dialect = Dialect.H2)`.
- The project uses **properties** format for configuration (`application.properties`), not YAML.

## Testing Strategy

- **Framework**: JUnit 5 via `micronaut-test-junit5`.
- **Integration tests** use `@MicronautTest` to spin up the full application context.
- **Controller tests** inject an HTTP client (`@Client("/") HttpClient`) and exercise endpoints end-to-end.
- **Repository tests** inject the repository directly and test CRUD operations against the real database.
- **Test isolation**: `PersonControllerTest` resets the database before each test by calling `flyway.clean()` and `flyway.migrate()` in a `@BeforeEach` method.
- **Focused tests**: `PersonControllerTest` uses a `@Nested` class (`WhenPersonExists`) with shared setup to keep lifecycle tests small and single-purpose.
- **Test config** (`application-test.properties`) enables `flyway.datasources.default.clean-schema=true` so Flyway can clean the schema during tests.
- **Manual testing**: The `http/` directory contains IntelliJ HTTP Client files for ad-hoc API exploration and smoke testing.

## Continuous Integration

A GitHub Actions workflow (`.github/workflows/maven.yml`) runs on pushes and pull requests to `main`:

- OS: `ubuntu-24.04`
- JDK: Temurin 25
- Command: `mvn -B clean package`

## Security Considerations

- The application uses an **in-memory H2 database** with default credentials (`sa` / empty password). This is fine for a sample/demo project but must be replaced with a persistent, properly secured database for production.
- The H2 web console is started on a random port by default. In production, exposing the H2 console is a security risk.
- No authentication or authorization layer is implemented.
- OpenAPI annotations are present; generated spec is available at runtime.

## License

MIT License (see `LICENSE`).
