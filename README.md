
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

######Anagramy:
Przykładowe anagramy:

![anagramy](https://github.com/KLamkiewicz/WikiNoSQL/blob/master/Screenshots/Anagrams/anagrams.png)

###b) Wikipedia

Wyszukaj najczęściej występujące słowa z Wikipedia data PL. Plik jaki pobrałem to zrzut z [09-12-2014](http://dumps.wikimedia.org/plwiki/20141209/). Aby móc zaimportować artykuły do bazy MongoDB najpierw przerobiłem pobrany plik w formacie xml(skompresowany bzip2) do formatu CSV z polami "id" artykułu i "text" czyli treść artykułu. Dokonałem tego przy użyci SAX dla Javy, który nie wczytuje całego pliku xml, a jedynie sekwencyjnie go parsuje. Przed zapisaniem artykułu do pliku jest on ponownie parsowany, tym razem oczyszczam go ze wszelkich niezbędnych znaków.

[Kod programu](https://github.com/KLamkiewicz/WikiNoSQL/tree/master/WikiParsing/src/main/java/pl/krzysiek/nosql).


