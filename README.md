# **ProjectOOP – Cirilli, Barbarella**

Il nostro progetto è un application programming interface che permette di analizzare i dati delle foto di un album di Facebook scaricati tramite l&#39;API di Facebook. I dati relativi a una foto sono: altezza, larghezza, data di creazione, dimensione in KiloByte e risoluzione in Pixel. Una volta acquisiti i suddetti dati è possibile filtrarli secondo dei parametri, andando quindi a visualizzare gli album filtrati, e ottenere statistiche di tipo dimensionale e temporale, le quali sono poi inserite in delle LinkedHashMap.

In dettaglio l&#39;applicazione permette di:

- Restituire tutti i dati in formato JSON;
- Restituire i dati filtrati per larghezza, altezza, larghezza e dimensione, altezza e dimensione, restituendoli in formato JSON;
- Restituire le statistiche sia di tipo dimensionale che temporale;
- Restituire i metadati di un album di foto, in formato JSON.

##
# **Richieste GET e POST:** 

Tramite un API testing come Postman è possibile eseguire una richiesta GET o POST all&#39; indirizzo (locale) http://localhost:8080.

| **TIPO** | **ROTTA** | **DESCRIZIONE** |
| --- | --- | --- |
| POST | /fb | Richiesta dei dati tramite un link passato nel body |
| GET | /fb | Restituisce i dati richiesti |
| POST | /fb/stats | Restituisce le statistiche sui dati |
| POST | /fb/filters | Restituisce i dati filtrati |
| GET | /metadata | Restituisce i metadata di un album |

Nota: Per quanto riguarda le statistiche ed i filtri abbiamo optato per delle richieste POST e non una GET perché dovevamo passare un JSON nel body per poter scegliere il tipo di filtro o statistica.

##

##
# **Diagrammi UML**

- Use Case Diagram

![USeCase](https://github.com/matteocirilli/ProgettoOOP/blob/master/UmlDiagrams/UseCase.png)

- Class Diagram

Nota: Abbiamo preferito dividere il diagramma delle classi nelle rappresentazioni dei vari package. Inoltre in it.univpm.projectOOP sono rappresentati esclusivamente i sotto-package e non le classi all&#39;interno per rendere il tutto più chiaro e leggibile.

![projectOOP](https://github.com/matteocirilli/ProgettoOOP/blob/master/UmlDiagrams/ClassDiagrams/it.univpm.projectOOP.png)

![Exceptions](https://github.com/matteocirilli/ProgettoOOP/blob/master/UmlDiagrams/ClassDiagrams/it.univpm.projectOOP.exceptions.png)

![FiltersStats](https://github.com/matteocirilli/ProgettoOOP/blob/master/UmlDiagrams/ClassDiagrams/it.univpm.projectOOP.filters_statistics.png) ![model](https://github.com/matteocirilli/ProgettoOOP/blob/master/UmlDiagrams/ClassDiagrams/it.univpm.projectOOP.model.png) ![Service](https://github.com/matteocirilli/ProgettoOOP/blob/master/UmlDiagrams/ClassDiagrams/it.univpm.projectOOP.service.png) ![controller](https://github.com/matteocirilli/ProgettoOOP/blob/master/UmlDiagrams/ClassDiagrams/it.univpm.projectOOP.controller.png)

- Sequence Diagram

![SequenceDiagram](https://github.com/matteocirilli/ProgettoOOP/blob/master/UmlDiagrams/SequenceDiagram.png)

##
# **Filtri:**

Per ottenere i dati filtrati è necessario fare una richiesta POST a _&quot;/fb/filters&quot;_ passando nel body i parametri sotto forma di JSON

{

&quot;filter&quot;: &quot; &quot;,

&quot;filterType&quot;: &quot; &quot;,

&quot;parameters&quot;: &quot; &quot;

}

Tabella con i _filterType_ applicabili

| **Campo** | **Descrizione** |
| --- | --- |
| filterWidth | Filtro in base alla larghezza |
| filterHeight | Filtro in base all&#39;altezza |
| filterWidthDim | Filtro in base alla larghezza e alla dimensione |
| filterHeightDim | Filtro in base all&#39;altezza e alla dimensione |

Tabella con i _filter_ applicabili

| **Tipo** | **Descrizione** |
| --- | --- |
| &quot;$gt&quot; | Maggiore di |
| &quot;$gte&quot; | Maggiore o uguale di |
| &quot;$lt&quot; | Minore di |
| &quot;$lte&quot; | Minore o uguale di |
| &quot;$bt&quot; | Compreso tra |

##
# **Statistiche:**

Per ottenere le statistiche (dimensionali o temporali) è necessario fare una richiesta POST a _&quot;/fb/stats&quot;_ passando nel body il tipo di statistica sotto forma di JSON

{

&quot;typeStat&quot;: &quot; &quot;,

}

Tabella con i tipi di statistiche applicabili

| **Tipo** | **Descrizione** |
| --- | --- |
| temp | Statistiche temporali |
| dim | Statistiche dimensionali |

# **Eccezioni:** 

EmptyAlbumListException(): è un&#39;eccezione che si verifica nel momento in cui non è presente nessun album nella lista. Quando si verifica compare il messaggio di errore:

&quot;La lista di Album di Facebook è vuota&quot;

WrongFilterStatsException(): è un&#39;eccezione che si verifica se il tipo di filtro o di statistica inserito dall&#39;utente è errato. Quando si verifica compare il messaggio di errore:

&quot;Il filtro inserito non è corretto&quot; o &quot;Puoi solo cercare statistiche temporali o dimensionali!&quot;

##


## **Software utilizzati**

- Eclipse - IDE per lo sviluppo del codice
- SpringBoot - framework per sviluppo applicazioni Java
- Maven - strumento di gestione di progetti
- Postman – API testing

##


## **Suddivisione del lavoro e Autori**

L&#39;implementazione di tutto il codice è avvenuta in collaborazione a distanza tramite videochiamate con l&#39;applicativo Microsoft Teams fornitoci dall&#39;università. Mentre la creazione del JavaDoc, dell&#39; UML e della ReadMe è avvenuta separatamente in modo da ottimizzare il lavoro complessivo.

- **Matteo Cirilli (S1089562)**
- **Marco Barbarella (S1089564)**
