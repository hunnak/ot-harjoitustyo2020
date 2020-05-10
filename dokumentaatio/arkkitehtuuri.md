Luokkakaavio snakegame sovelluksesta

<img src = "https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/luokkakaavio2020.png" width="750">

Ohjelman rakenne noudattelee kutakuinkin kaksitasoista kerrosarkkitehtuuria, jossa pääohjelma kutsuu käyttöliittymää
käyttöliittymä rakentaa graaffisen ikkunan ja kutsuu graphicslogicia piirtämään graafiset elementit. Käyttöliittymä käynnistää myös pelilogiikan screen-olion pelilogiikkakerroksesta ja asettaa näppäimistökuuntelija olion keylistener ohjelmistolle.

Pelilogiikka sijaitsee snakegame.domain pakkauksessa, ui pakkauksessa on käyttöliittymäluokka Ui ja grafiikan piirtämisen toteuttava luokka GraphicsLogic ja main pakkaus sisältää pääohjelman.



Sekvenssikaavio ohjelmiston toiminnallisuudesta ohjelmiston käynnistyessä ja liikuttaessa käärmettä kutsuen move() methodia (pelilogiikan luokissa Screen ja Snake).

<img src = "https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/sekvenssi_viikko5pt1.png" width="1000">
<img src = "https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/sekvenssi_viikko5pt2.png" width="1000">
<img src = "https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/sekvenssi_viikko5pt3.png" width="1000">

## Sovellus logiikka
