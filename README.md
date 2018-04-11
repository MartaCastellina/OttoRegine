Data una scacchiera 8x8
Posizionare 8 regine degli scacchi in modo che non si possano mangiare tra di loro


------------
| |Q| | |		0:1
----------
| | | |Q|		1:3
----------
|Q| | | |		2:0
----------
| | |Q| |		3:2
----------





Soluzione parziale=lista di numeri (colonne) tra 0 e N-1
Soluzione totale=soluzione parziale con esattamente N elementi (righe)

La soluzione parziale viene costruita aggiungendo una nuova regina per volta, nella riga 
successiva. Metterò la regina nella riga==livello.
Le mosse possibili a un certo livello dipendono da quali caselle sono "libere" dall'attacco delle regine poste
nelle righe (livelli) precedenti.
TRovata la prima soluzione, la ricerca può terminare
