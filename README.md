
#Egzamin

Specyfikacja komputera:

	 Dysk twardy: WD5000 500GB 7200RPM
	 Procesor: Pentium Dual-Core E5400 @ 2.70Ghz
	 Ram: 2GB DDR2
	 System: Lubuntu 14.04
  

____

###a) Anagramy

Wyszukanie wszystkich anagramów w pliku z [anagramami](http://wbzyl.inf.ug.edu.pl/nosql/doc/data/word_list.txt).


#####Import:

![importanagram](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Screenshots/Anagrams/import.png)

######MapReduce:
[Kod](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Anagrams/wordsMapReduce.js) napisany w nodejs.

![mapreduceanagram](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Screenshots/Anagrams/mapreduce.png)

Liczba anagramów: 914

######Anagramy:
Przykładowe anagramy:

![anagramy](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Screenshots/Anagrams/anagrams.png)

###b) Wikipedia

Wyszukaj najczęściej występujące słowa z Wikipedia data PL. 

Plik jaki pobrałem to zrzut z [09-12-2014](http://dumps.wikimedia.org/plwiki/20141209/). Aby móc zaimportować artykuły do bazy MongoDB najpierw przerobiłem pobrany plik w formacie xml(skompresowany bzip2) do formatu CSV z polami "id" artykułu i "text" czyli treść artykułu. Dokonałem tego przy użyci SAX dla Javy, który nie wczytuje całego pliku xml, a jedynie sekwencyjnie go parsuje. Przed zapisaniem artykułu do pliku jest on ponownie parsowany, tym razem oczyszczam go ze wszelkich zbędnych znaków.

[Kod programu](https://github.com/KLamkiewicz/WikiNoSQL/tree/master/WikiParsing/src/main/java/pl/krzysiek/nosql).

#####Parsowanie:

![wikiParse](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Screenshots/Wikipedia/parsewiki.png)

#####Import:

![importing](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Screenshots/Wikipedia/importwiki.png)

![imported](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Screenshots/Wikipedia/imported.png)

#####MapReduce:
[Kod](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Anagrams/wikipediaMapReduce.js)

	Czas wykonania mapReduce: 34h 15m 43s.
	
#####Najczęściej występujące słowa

| słowo      | wystąpienia |
|------------|-------------|
| urodził    | 5382        |
| sześć      | 5352        |
| Urodził    | 5342        |
| ukończeniu | 5307        |
| Dwa        | 5261        |
| rodzinie   | 5261        |
| przebywał  | 5254        |
| założył    | 5246        |
| pozostał   | 5234        |
| powrocie   | 5229        |
