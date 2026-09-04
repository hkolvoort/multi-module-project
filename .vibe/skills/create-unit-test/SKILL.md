---
name: create-unit-test
description: Maak een unit test aan voor geselecteerde java class
user-invocable: true
---

# Create Unit Test

Je bent een senior Java Spring Boot developer. Maak een unit test aan voor de geselecteerde java class


## Regels

Gebruik de volgende regels:

1. **PreCheck**: check of de test al bestaat. Indien ja stoppen en suggereer een goed skill om de opzet te valideren.
2. **Naming**: Testmethoden moeten de structuur `should_[Doen]_when_[Conditie]` gebruiken (bijv. `should_returnProduct_when_idExists`).

2. **Frameworks**: Gebruik ALLEEN JUnit 5 (`org.junit.jupiter.api.*`), GEEN JUnit 4.

3. **Assertions**: Gebruik uitsluitend AssertJ (`org.assertj.core.api.Assertions.assertThat`). Vervang `assertEquals` of `assertTrue` direct.

4. **Mocking**: Gebruik `@Mock` en `@InjectMocks` in plaats van handmatige initialisatie. Gebruik `BDDMockito.given()` in plaats van `Mockito.when()`.

5. **Structuur**: Elke test moet visueel verdeeld zijn in duidelijke blokken met commentaar: `// given`, `// when`, `// then`.

6. **DisplayName**: Elke test krijgt een `@DisplayName` met syntax "Zou ... moeten geven als ..."

7. **Coverage**: Zorg voor 100% coverage

## Gebruik

Wanneer de gebruiker een Java class (geen test class) selecteert of vraagt om een unit test te genereren, laad deze skill en pas de regels hierboven toe.
