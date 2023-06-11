# Projektrapport: Kerim Solo

## Namn
Kerim kozo

### Beskrivning av projektet och arbetet
Projektet gick ut på att skapa en serie tester för WeatherService med hjälp av JUnit och mock-objekt samt skriva en detaljerad testrapport.
Jag arbetade ensam i detta projekt.

## Arbetet och dess genomförande
Arbetet genomfördes genom att först skapa alla klasser tillhörande samt en test klass 
WeatherServiceTest. Därefter påbörjade jag testningen. Efter hand som att jag började testa 
fick jag fler ideer och ändrade om i klassen WeatherService.

### Vad som varit svårt
Det svåraste med uppgiften var att veta hur lärarna vill ha klasserna kodade.
Hade vi fått en färdig mall på klasserna tror jag det hade varit mycket enklare att skriva testerna.

### Beskriv lite olika lösningar du gjort
Min första tanke var att skapa en JSON klass som tar emot responsen från apiet och filtrerar ut det som behövs.
Jag visste inte riktigt hur jag skulle göra ett test av detta så jag valde att ha en metod som filtrerar istället i
klassen WeatherService. Detta gjorde att jag kunde testa metoden och få ut det jag ville ha.
Jag visste heller inte hur jag skulle göra med mockningen så jag valde att ta all json text vi fick
och göra om det till en sträng för att sedan kunna testa mina metoder. När jag fick detta till att funka satte jag Json
strängen som setup i beforeEach för att slippa skriva samma kod flera gånger. 

### Beskriv något som var besvärligt att få till
Överlag var hela projektet besvärligt att få till. Jag hoppas att jag har förstått uppgiften och kodat WeatherService klassen
som det har önskats samt testklassen.


### Beskriv om du fått byta lösning och varför i sådana fall
Som tidigare nämnt var min första tanke att skapa en Json klass som hanterar responsen från apiet.
Detta kände jag skulle bli för omständligt och därför blev det en snabbare lösning att skapa en metod i WeatherService 
som hanterar detta. 



## Slutsatser

### Vad gick bra/dåligt
Det som jag upplever gick bra var att jag fick till några tester och att mockningen fungerade.
Det som gick sämre var att jag var osäker på hur klasserna skulle kodas. Jag upplever mitt sätt som en
lösning men det är svårt att veta om det är rätt. Jag har en känsla av att jag har tänkt fel vilket återstår att se
i feedbacken. En sak som är värt att tillägga är att jag inte upplever att jag har implementerat ett robust kodande.  
Detta är något jag skulle vilja arbeta mer med i framtiden.


### Vad har du lärt dig
Jag har lärt mig hur man arbetar med mock i kombination med TDD. Det har varit en lärorik
uppgift och jag hade velat göra flera sådana tillsammans med läraren. Det har även varit en väldigt lärorik 
process att få bolla ideer med chatGPT. Jag har även förstått meningen med TDD vilket är att säkerställa att koden uppfyller krav
och fungerar som förväntat. Jag märkte själv som exempel när jag kodade metoden som filtrerar json strängen att jag var tvungen att
ha lösningar ifall det är något fel på json strängen. Detta är något jag inte hade tänkt på om jag inte hade testat metoden.
Jag har även lärt mig nyttav av att använda mockobjekt vilket är till för att isolera koden som ska testas. Nu behövde jag inte vara uppkopplad mot ett API
för att koden skulle skrivas och testas vilket var väldigt smidigt.


### Vad hade du gjort annorlunda om du gjort om projektet
Jag är nöjd med hur projektet blev. Det som jag hade "önskat" vore isåfall att
få träna mer tillsammans med läraren och klassen. Jag har stundvis känt mig som ett frågetecken genom hela projektet.
Jag har förstått vad jag har gjort och varför jag har valt att skriva koden på detta sätt men ifall detta är vad som förväntades är jag väldigt osäker.
Det känns som att jag har tänkt fel vilket återstår att se i feedbacken. En sak jag hade kunnat göra annorlunda var att göra API klassen till ett interface
och skapa en metod som tar en input string och ger en return string. Denna hade jag sedan kunnat mocka i mitt test och lägga in json stringen. Jag hade också
kunnat skriva flera tester med olika fall för att mer detaljerat se hur jag kan krascha mina metoder. Det som jag är mest funderande över är 
ifall jag borde ha haft en metod där jag skriver som input vilken stad jag vill söka efter för att sedan få ett mockat resultat. Anledningen till att jag inte gjorde
det var att jag anser det tillhöra API klassen och inte WeatherService klassen då jag ser det som en "API request". WeatherService klassen ska endast hantera
responsen från apiet och inte själva anropet.

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
Dessa kunskaper kommer jag kunna använda för att skriva tester i framtiden. Jag har fått en bra grund att stå på och jag har förstått hur jag ska tänka när jag skriver tester.
Nu förstår jag att jag kan isolera delar av ett projekt för att kunna testa dem och säkerställa att de kommer fungera som de ska. Mock möjliggör
även att jag kan skriva och testa kod i ett projekt som inte är komplett. Det sparar tid och gör att jag kan arbeta mer effektivt.

