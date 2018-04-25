# zadanie_kalkulator_s

Aplikacja ma za zadanie wyliczać miesięczny zarobek netto w
wybranych krajach w przeliczeniu na PLN. W wyliczeniach uwzględniony
jest podatatek dochodowy, koszty stałe oraz aktualny kurs waluty.

Do obsługi aplikacji służy strona index.html w src/main/resources/view/index.html.
Na stronie w polu formularzu podawany jest dzienny zarobek brutto.
Po wysłaniu formularza, po stronie serwera obliczane są miesięczne zarobki netto i 
wyświetlana na stronie odpowiednia kwota przy poszczególnym symbolu
kraju.

Lista krajów oraz dane dotyczące ich kosztów, podatków i symbolu waluty, znajdują
się w pliku src/main/resources/file/countries.txt. W tym pliku można dopisywać kolejne kraje
w formacie: Symbol kraju, podatek dochodowy w %, koszty stałe, symbol waluty. 
Przykład danych: UK, 25%, 600, GBP

Uwaga: Wiersze rozpoczynające się od / traktowane są jako komentarz.

Aktualne kursy walut pobierane są z API nbp.pl


