# SpringExampleApp
Přehled projektu
Tento projekt je API pro správu uživatelů, které zahrnuje základní funkce, jako je vytvoření, aktualizace, mazání uživatelů a zabezpečený přístup pomocí Spring Security a Basic autentizace.

Pokyny pro spuštění aplikace
Předpoklady:
  Nainstalovaný Java 17 nebo novější.
  Nainstalovaný Maven 3.6+.
  Nainstalovaný a spuštěný PostgreSQL.

Naklonovat tento repozitář. 
vytvořit a napojit se na postgres db - upravit application.properties

vytvořit tabulku a ukázkové usery - skript dbsseed.sql

spustit aplikaci: 
mvn spring-boot:run
nebo:
mvn clean package
java -jar target/exampleApp-0.0.1-SNAPSHOT.jar


# Možná další vylepšení
Lepší autentizace, např JWT, napojení na autentizační server, např. keycloak.
Unit a integrační testing.
Strankování a filtrování, vyhledávání pro list.
Překlady pro chybové zprávy.
Přidání rolí - admin/běžný uživatel.
Validace a podmínky na heslo  - musí obsahovat dané znaky.
Encoding hesla, nepřechovávat v db plaintext hesla.


