Analiza SOLID
1. SRP: este incalcat. Clasa OrderProcessor are prea multe responsabilitati: valideaza date, calculeaza pretul, proceseaza plata, salveaza in baza de date si trimite email. Ar trebui sa se ocupe doar de coordonarea acestor pasi.

2. OCP: incalcat. Logica pentru calculul reducerii si alegerea metodei de plata foloseste if/else. Daca vrem sa adaugam un nou tip de client sau de plata, suntem fortati sa modificam codul existent, in loc sa il extindem.

3. LSP: nu cred ca este incalcat direct in varianta initiala, deoarece nu exista ierarhii de mostenire care sa fie folosite gresit.

4. ISP: nu este incalcat, deoarece codul initial nu foloseste interfete care sa forteze implementarile sa suprascrie metode inutile.

5. DIP: incalcat. Clasa OrderProcessor depinde direct de clasele concrete FileDatabase si EmailSender prin instantierea lor cu new in interiorul metodei process.