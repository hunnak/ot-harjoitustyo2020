# Testausdokumentti

Ohjelmaa on testattu yksikkö-JUnitilla sekä manuaalisesti.

## Yksikktestaus

### sovelluslogiikka

Automatisoitujen testien ytimen moudostavat sovelluslogiikkaa, eli pakkauksen [snakegame.domain](https://github.com/hunnak/ot-harjoitustyo2020/tree/master/Snakegame/src/main/java/snakegame/domain) luokkien logiikkaa testaavat testit pääasiassa PointTest, SnakeTest ja ScreenTest junit testiluokat, testiluokat pääasiassa simuloivat toiminnallisuudesta käärmeen liikkumista ja törmäysmetodeja.

### Testauskattavuus

Käyttöliittymäpakkausta ja pääohjelmaluokkaa lukuunottamatta sovelluksen testauksen rivikattavuus on 63% ja haarautumakattavuus 52%

<img src="https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/testikattavuus.png" width="800">

Testaamatta jäivät tilanteet, joissa käytettiin satunnaisgenerointia, peli ohi metodi.


### Asennus ja konfigurointi

Sovellusta on testattu käyttöohjeiden mukaisesti ja komentorivi asennuksen mvn package komennon jälkeen, mvn test, mvn jacoco:report

## Sovellukseen jääneet laatuongelmat

Sovellus täytyy käynnittää uudelleen pelin päätyttyä
