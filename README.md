# Snake game

Käyttäjä voi pelata käärmepeliä ajankulukseen. Pelissä liikutaan nuolinäppäimillä ja kerätään ruudulle ilmestyviä pisteitä.
Peli päättyy kun pelaaja osuu käärmeen omaan runkoon käärmeen päällä.




**Dokumentointi**

[Vaatimusmäärittely](https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/arkkitehtuuri.md)

[Release linkki](https://github.com/hunnak/ot-harjoitustyo2020/releases/tag/viikko5)

**Komentorivi käskyt**

Ladatun jar tiedoston ajaminen komennolla: java -jar Snakegame.jar

Checkstyle raportin ajaminen komennolla: mvn jxr:jxr checkstyle:checkstyle

Testien ajo komento: mvn test
Testikattavuuden ajokomento: mvn jacoco:report

Ohjelman ajaminen komennolla: mvn compile exec:java -Dexec.mainClass=snakegame.main.Main 

JavaDocin generointi komennolla: mvn javadoc:javadoc

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html




