# Testausdokumentti

Ohjelmaa on testattu yksikkö-JUnitilla, sekä pelaten manuaalisesti.

## Yksikkötestaus

### sovelluslogiikka

Automatisoitujen testit moudostavat sovelluslogiikan testauksesta, eli pakkauksen [snakegame.domain](https://github.com/hunnak/ot-harjoitustyo2020/tree/master/Snakegame/src/main/java/snakegame/domain) testaamisesta. Luokkien logiikkaa testaavat testit ovat pääasiassa PointTest, SnakeTest ja ScreenTest junit testiluokat, testiluokat pääasiassa simuloivat toiminnallisuudesta käärmeen liikkumista ja törmäysmetodeja.

### Testauskattavuus

Käyttöliittymäpakkausta ja pääohjelmaluokkaa lukuunottamatta sovelluksen testauksen rivikattavuus on 63% ja haarautumakattavuus 52%

<img src="https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/testikattavuus.png" width="800">

Testaamatta jäivät tilanteet, joissa käytettiin satunnaisgenerointia ja screen luokassa peli ohi metodia.


### Asennus ja konfigurointi

Sovellusta on testattu käyttöohjeiden mukaisesti ja komentorivi (jar)-asennuksen mvn package komennon jälkeen, käyttäen komentoja mvn test ja mvn jacoco:report

## Sovellukseen jääneet laatuongelmat

Sovellus täytyy käynnisttää uudelleen pelin päätyttyä, jotta keyEvent listener kuuntelee käyttäjän komentoja. Keylistener ei ilmeisesti toimi Swting javalla, olisi pitänyt osata muuttaa logiikka hyödyntämään keyBinding keyEvent kuuntelua.
