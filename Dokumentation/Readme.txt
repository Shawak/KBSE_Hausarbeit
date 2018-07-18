Docker
    Requirements:
    docker
    docker-compose
    https://store.docker.com/search?type=edition&offering=community

    How-To
    Da der Container die .war File nicht selbst bauen kann, ist ein .war File mit abgegeben.
    Der Container kann mit dem Command: "docker-compose up --build" gestartet werden.
    Um auf den Container zuzugreifen, kann das Command "docker exec -it supercar_app_1 /bin/sh" verwendet werden.
    Die Webseite kann unter http://localhost/supercar abgerufen werden.


Links

Java SE JDK 1.8.0_171   http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
NetBeans IDE    https://netbeans.org/downloads/start.html?platform=windows&lang=en&option=javaee
GlassFish 5.0   https://javaee.github.io/glassfish/download
Java EE 8   http://www.oracle.com/technetwork/java/javaee/downloads/java-ee-sdk-downloads-3908423.html



Anmeldedaten:
Administrator Benutzer:
	Username: admin
	Passwort: admin
	
Mitarbeiter Benutzer:
	Username: employee
	Passwort: employee
	
Normaler Benutzer:
	Username: user
	Passwort: user



Benutzung der Weboberfläche:
Navbar:
    - Navigation zwischen allen Seiten
Login: 
    - Benutzer Logout, Profil, Rechnungen unter dem Benutzernamen
Cars (Index):
    - Autos mit dropdowns sortieren 
    - nach Stichworten suchen
    - Details durch anklicken eines Autos ansehen
Contact:
    - Kontaktinformation und Standort
Return:
    - Wenn Fahrzeuge ausgeliehen sind hier zurückgeben
User:
    - Benutzer bannen
    - Benutzer zur Ausleihe freischalten
    - über switch nur nicht Verifizierte Nutzer anzeigen
Garage:
    - Hinzufügen und ändern von Werkstätten

Car:
    - Hinzufügen und ändern von Autos
    - Auto zur Reperatur schicken
    - Auto deaktivieren
Model:
    - Hinzufügen und ändern von Modellen
Manufacturer:
    - Hinzufügen und ändern von Herstellern

Login:
    - Anmelden
    - Registrieren
Profil:
    - Einsehen und ändern der Benutzerdaten
Bills:
    - Alle Rechnungen von zurückgegebenen Autos
    - Herunterladen von Rechnungen

Authoren:
Lukas Bernhold, 740592, lukas.bernhold@hs-osnabrueck.de
Maximilian Nussbaum, 732386, maximilian.nussbaum@hs-osnabrueck.de
Patrick Wiethoff, 738195, patrick.wiethoff@hs-osnabrueck.de
