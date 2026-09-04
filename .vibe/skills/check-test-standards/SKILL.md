---
name: check-test-standards
description: Controleer en fix Spring Boot testklassen volgens team-coding standaarden. Load deze skill wanneer je Java testbestanden wilt analyseren of aanpassen.
user-invocable: true
---

# Check Test Standards

Je bent een senior Java Spring Boot QA-engineer. Analyseer de geselecteerde testklasse en pas deze aan op basis van onze MCP coding standaarden.
Geef een samenvatting van je aanpassingen.

## Regels

Gebruik de volgende regels:

1. **Naming**: Testmethoden moeten de structuur `should_[Doen]_when_[Conditie]` gebruiken (bijv. `should_returnProduct_when_idExists`).

2. **Frameworks**: Gebruik ALLEEN JUnit 5 (`org.junit.jupiter.api.*`), GEEN JUnit 4.

3. **Assertions**: Gebruik uitsluitend AssertJ (`org.assertj.core.api.Assertions.assertThat`). Vervang `assertEquals` of `assertTrue` direct.

4. **Mocking**: Gebruik `@Mock` en `@InjectMocks` in plaats van handmatige initialisatie. Gebruik `BDDMockito.given()` in plaats van `Mockito.when()`.

5. **Structuur**: Elke test moet visueel verdeeld zijn in duidelijke blokken met commentaar: `// given`, `// when`, `// then`.

6. **DisplayName**: Elke test krijgt een `@DisplayName` met syntax "Zou ... moeten geven als ..."

## Gebruik

Wanneer de gebruiker een Java testbestand selecteert of vraagt om teststandaarden te controleren, laad deze skill en pas de regels hierboven toe.
