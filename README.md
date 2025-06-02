"# bingoClientServer" 

# 🎰 Bingo Klijent-Server Aplikacija

Ova Java aplikacija predstavlja igru Bingo razvijenu u klijent-server arhitekturi. Klijent pokušava da pogodi nasumično generisanu kombinaciju od 4 broja koju server čuva. Nakon svakog pokušaja, server vraća broj pogodaka na tačnim pozicijama i broj pogodaka van mesta.

---

## 🛠️ Tehnologije

- Java (Swing GUI)
- Socket programiranje (klijent-server)
- Višenitno programiranje (generisanje kombinacije)
- Čuvanje i prikaz rezultata

---

## 🎮 Pravila igre

- Server na početku igre generiše kombinaciju 4 nasumična broja putem niti.
- Klijent bira 4 broja i šalje ih serveru.
- Server vraća informaciju:
  - Broj pogodaka na tačnoj poziciji.
  - Broj pogodaka koji se nalaze u kombinaciji ali nisu na pravom mestu.
- Klijent ima **maksimalno 6 pokušaja** da pogodi celu kombinaciju.
- Ako pogodi sve brojeve na tačnom mestu – pobedio je.
- Ako potroši svih 6 pokušaja – izgubio je.

---

## 🔁 Tok igre (ukratko)

1. Server pokreće nit za generisanje kombinacije.
2. Klijent bira i šalje brojeve.
3. Server odgovara rezultatima.
4. Klijent nastavlja igru dok ne pogodi ili ne potroši pokušaje.
5. Po završetku igre, server ima opciju da:
   - Sačuva rezultat.
   - Prikazuje listu svih igara i njihovih poteza kroz dodatnu formu.

---

## 💾 Upravljanje igrama

- Server može da sačuva svaku završenu igru.
- Postoji posebna forma za prikaz:
  - Rezultata svih odigranih igara.
  - Pojedinačnih poteza u okviru jedne igre.


