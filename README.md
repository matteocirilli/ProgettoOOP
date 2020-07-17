ProjectOOP – Cirilli, Barbarella
Il nostro progetto è un application programming interface che permette di analizzare i dati delle foto di un album di Facebook scaricati tramite l’API di Facebook. I dati relativi a una foto sono: altezza, larghezza, data di creazione, dimensione in KiloByte e risoluzione in Pixel. Una volta acquisiti i suddetti dati è possibile filtrarli secondo dei parametri, andando quindi a visualizzare gli album filtrati, e ottenere statistiche di tipo dimensionale e temporale, le quali sono poi inserite in delle LinkedHashMap.
In dettaglio l’applicazione permette di:
o	Restituire tutti i dati in formato JSON;
o	Restituire i dati filtrati per larghezza, altezza, larghezza e dimensione, altezza e dimensione, restituendoli in formato JSON;
o	Restituire le statistiche sia di tipo dimensionale che temporale;
o	Restituire i metadati di un album di foto, in formato JSON.


Richieste GET e POST:
Tramite un API testing come Postman è possibile eseguire una richiesta GET o POST all’ indirizzo (locale) http://localhost:8080.

 TIPO	ROTTA	DESCRIZIONE
  POST	 /fb	Richiesta dei dati tramite un link passato nel body
  GET	 /fb	Restituisce i dati richiesti
  POST	 /fb/stats	Restituisce le statistiche sui dati
  POST	 /fb/filters	Restituisce i dati filtrati
  GET	 /metadata	Restituisce i metadata di un album


Nota: Per quanto riguarda le statistiche ed i filtri abbiamo optato per delle richieste POST e non una GET perché dovevamo passare un JSON nel body per poter scegliere il tipo di filtro o statistica.






Diagrammi UML

o	Use Case Diagram

 






o	Class Diagram

Nota: Abbiamo preferito dividere il diagramma delle classi nelle rappresentazioni dei vari package. Inoltre in it.univpm.projectOOP sono rappresentati esclusivamente i sotto-package e non le classi all’interno per rendere il tutto più chiaro e leggibile.
 
 

    



o	Sequence Diagram

 








Filtri:
Per ottenere i dati filtrati è necessario fare una richiesta POST a “/fb/filters” passando nel body i parametri sotto forma di JSON
{
    "filter": “     “,
    "filterType": “   “,
    "parameters": “   “
}

Tabella con i filterType applicabili
  Campo	  Descrizione
filterWidth	Filtro in base alla larghezza
filterHeight	Filtro in base all’altezza
filterWidthDim	Filtro in base alla larghezza e alla dimensione
filterHeightDim	Filtro in base all’altezza e alla dimensione

Tabella con i filter applicabili
 Tipo	 Descrizione
“$gt”	Maggiore di 
“$gte”	Maggiore o uguale di 
“$lt”	Minore di
“$lte”	Minore o uguale di
“$bt”	Compreso tra


Statistiche:
Per ottenere le statistiche (dimensionali o temporali) è necessario fare una richiesta POST a “/fb/stats” passando nel body il tipo di statistica sotto forma di JSON
{
    "typeStat": “     “,
}

Tabella con i tipi di statistiche applicabili
  Tipo	  Descrizione
temp	Statistiche temporali
dim	Statistiche dimensionali
Eccezioni:

EmptyAlbumListException(): è un’eccezione che si verifica nel momento in cui non è presente nessun album nella lista. Quando si verifica compare il messaggio di errore: 
“La lista di Album di Facebook è vuota”

WrongFilterStatsException(): è un’eccezione che si verifica se il tipo di filtro o di statistica inserito dall’utente è errato. Quando si verifica compare il messaggio di errore:
"Il filtro inserito non è corretto" o "Puoi solo cercare statistiche temporali o dimensionali!"

Software utilizzati
•	Eclipse - IDE per lo sviluppo del codice
•	SpringBoot -  framework per sviluppo applicazioni Java
•	Maven - strumento di gestione di progetti
•	Postman – API testing

Suddivisione del lavoro e Autori
L’implementazione di tutto il codice è avvenuta in collaborazione a distanza tramite videochiamate con l’applicativo Microsoft Teams fornitoci dall’università. Mentre la creazione del JavaDoc, dell’ UML e della ReadMe è avvenuta separatamente in modo da ottimizzare il lavoro complessivo.
•	Matteo Cirilli (S1089562)
•	Marco Barbarella (S1089564)


