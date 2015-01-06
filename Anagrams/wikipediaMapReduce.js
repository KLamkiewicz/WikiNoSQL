var MongoClient = require('mongodb').MongoClient
, format = require('util').format;

MongoClient.connect('mongodb://127.0.0.1:27017/CleanWiki', {db: {native_parser: true}}, function(err, db) {
if(err) throw err;

	db.collection('Articles', function(err, col){
		
		var map = function(){
			var words = this.text.split(/\s+/);
			words.forEach(function(key){
				emit(key, key);
			});
		};

		var reduce = function(key, value){
			return value.toString();
		};

		var finalize = function(key, value){
			return value.length;
		}

		col.mapReduce(map, reduce, {
			out: "words",
			finalize: finalize
		});	

	});
})