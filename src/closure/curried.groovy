#!/usr/bin/env groovy


// Closures with prebound parameters are called curried closures
// Currying is a transformation from a function that takes multiple parameters to a function 
// that takes fewer (typically one).

def tellFortunes(closure) {

	Date date = new Date("09/20/2012")
	
	postFortune = closure.curry(date)
	// so funny concept
	// we can curry that parameter using a call to the curry() with date as an argument.
	// postFortune holds a reference to the curried closure
	postFortune "Your day is filled with ceremony"
	postFortune "They're features, not bugs"
}


tellFortunes() { date, fortune ->
	println "Fortune for ${date} is '${fortune}'"
}


