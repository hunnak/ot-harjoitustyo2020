# Vaatimusmäärittely

## Sovelluksen tarkoitus

Käyttäjä voi pelata käärmepeliä ajankuluksi.

## Käyttäjät

Sovellus ei tallenna ennätypisteitä. 

## Käyttöliittymäluonnos

Sovellus koostuu graafisesta käyttöliittymästä, sekä pelin toteuttavista toiminnallisista luokista.

## Perusversion tarjoama toiminnallisuus

### Toiminnallisuus

Käärmepelissä liikutaan ruudulle ilmestyneellä 2D-tasolla nuolinäppäimillä, käärmeellä on tarkoitus poimia pistepikseleitä (token-olioita) ja vältetään törmämästä seiniin tai itse käärmeeseen. (tehty)
Käärme liikkuu nuolinäppäimillä. (tehty)
Käärme kasvaa kun se osuu token olioon. (tehty)
Kun käärme törmää ja plei päättyy, tulee peli ohi ilmoitusikkuna, joka myös ilmoittaa kerätyt pisteet. (tehty)

## Jatkokehitysideoita

Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla

- muuttaa ohjelmistologiikan rakennetta keylistener luokasta keybinding luokkaan/muuttujaan
  Keylistener ei ole optimaalinen näppäimistötapahtumien tarkastelussa swing pohjaisella java-ohjelmalla.
- nimimerkki ennätyspisteitä varten, joka tallennetaan ylös.
- vaikeusasteen lisääminen (käärmeen nopeutta voidaan säädellä ja lisätä näytölle törmäysesteitä)
- sovelluksen käynnistäessä voisi tarkistaa ennätyspisteet, lisätä vaikeutta ym.
- äänitehosteet
