Luokkakaavio snakegame sovelluksesta

<img src = "https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/luokkakaavio2020.png" width="750">

Ohjelman rakenne noudattelee kutakuinkin kaksitasoista kerrosarkkitehtuuria, jossa pääohjelma kutsuu käyttöliittymää
käyttöliittymä rakentaa graaffisen ikkunan ja kutsuu graphicslogicia piirtämään graafiset elementit. Käyttöliittymä käynnistää myös pelilogiikan screen-olion pelilogiikkakerroksesta ja asettaa näppäimistökuuntelija olion keylistener ohjelmistolle.

Pelilogiikka sijaitsee snakegame.domain pakkauksessa, ui pakkauksessa on käyttöliittymäluokka Ui ja grafiikan piirtämisen toteuttava luokka GraphicsLogic ja main pakkaus sisältää pääohjelman.


## Sovellus logiikka
Sovelluksen logiikan toiminallisuudesta vastaavat domain pakkauksen luokat. Point luokka sisältää pääasiassa token ja snake olion osien koordinaatit x ja y ja voi tarkistaa osuuko point olio toiseen point olioon (onko samat koordinatit). Snake luokka tallentaa käärme olion point oliot listaan, sekä käärmeen perustoiminnallisuudet, liikkumisen ja itseensä törmäämistarkistuksen. Keylistenerillä voidaan asettaa snake olion suunta npääimistön nuolien mukaan,keylistener luokka tarkastaa myös ettei käärme käänny heti 180 astetta ja törmää itseensä. 

Screen luokka sisältää suurimman osan pelilogiikasta screen oliossa on näytön rajat, käärme ja token olion koordinatteineen näppäimistön kuuntelutapahtumametodin (actionPerformed). Screen-luokan actionPerformed sisältää myös yksittäisen pelisyklin mitan, jota pävitetään joka syklin päätteeksi. Syklissä logiikka tarkistaa onko peli päättynyt, onko käärme kerännyt uuden tokenin ja onko käärme törmännyt. Screenluokka sisältää myös pelin päättymis metodin johon se siirtyy jos gameContinue boolean muuuttuja on false, game over metodissa peli päättyy, kerätyt pisteet ilmoitetaan ja ikkuna voidaan sulkea cancel napista. Ok napin jälkeinen fresh game metodi ei toimi, koska keylistener luokka ei enää toimi kun swing timer on kerran pysäytetty.


Havainollistava sekvenssikaavio ohjelmiston toiminnallisuudesta ohjelmiston käynnistyessä ja liikuttaessa käärmettä kutsuen move() methodia (pelilogiikan luokissa Screen ja Snake).

<img src = "https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/sekvenssi_viikko5pt1.png" width="1000">
<img src = "https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/sekvenssi_viikko5pt2.png" width="1000">
<img src = "https://github.com/hunnak/ot-harjoitustyo2020/blob/master/dokumentaatio/sekvenssi_viikko5pt3.png" width="1000">

## Käyttöliittymä
Ui käyttöliittymä johon screen parametrit ja grafiikan parametrit asetetaan, liittää näppäimistönkuuntelija luokan käärme olioon. Asettaa grafiikka ruudun koon. Palauttaa grafiikka logiikan grafiikat ruudulle.
GraphicsLogics piirtää käärmeen ja tokenin grafiikat annettujen parametrien mukaan ja piirtää ne uudestaan joka peli syklissä update-inteface luokan update metodia kutsuttaessa.
