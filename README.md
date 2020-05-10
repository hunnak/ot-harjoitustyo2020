# Snake game

Käyttäjä voi pelata käärmepeliä ajankulukseen. Pelissä liikutaan nuolinäppäimillä ja kerätään ruudulle ilmestyviä pisteitä.
Peli päättyy kun pelaaja osuu käärmeen omaan runkoon käärmeen päällä.




**Dokumentointi**

[Vaatimusmäärittely](https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/tuntikirjanpito.md)

[Käyttöohje](https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/kayttoohje.md)

[Arkkitehtuuri](https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/arkkitehtuuri.md)

[Release linkki](https://github.com/hunnak/ot-harjoitustyo2020/releases/download/Loppupalautus/Snakegame-1.0-SNAPSHOT.jar)

[Testausdokumentti](https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/testaus.md)

**Komentorivi käskyt**

Ladattuasi tiedostot aja ohjelmisto koneellesi kansiossa Snakegame komennolla mvn pakcage

Ladatun jar tiedoston ajaminen komennolla: java -jar Snakegame-1.0-SNAPSHOT.jar

Checkstyle raportin ajaminen komennolla: mvn jxr:jxr checkstyle:checkstyle

Testien ajo komento: mvn test
Testikattavuuden ajokomento: mvn jacoco:report

Ohjelman ajaminen komennolla: mvn compile exec:java -Dexec.mainClass=snakegame.main.Main 

JavaDocin generointi komennolla: mvn javadoc:javadoc

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html




