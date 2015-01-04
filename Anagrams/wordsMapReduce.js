var MongoClient = require('mongodb').MongoClient
, format = require('util').format;

MongoClient.connect('mongodb://127.0.0.1:27017/Words', {db: {native_parser: true}}, function(err, db) {
if(err) throw err;

	db.collection('words', function(err, col){

		var map = function(){
			emit(this.word.split('').sort().toString(), this.word);
		};

		var reduce = function(key, value){
			return value.toString();
		};

		var finalize = function(key, value){
			return (value.length/key.length)>1?value:"No anagram";
		};

		col.mapReduce(map, reduce, {
			out: "anagrams",
			finalize: finalize
		});
						
	});
})