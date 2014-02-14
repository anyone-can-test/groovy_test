#!/usr/bin/env groovy

value = 25
println 'The value is ${value}'
println "The value is ${value}"			// Should use double quotes to evaluate the expressions



// String is immutable, so changing it raises an exception
str = "hello"
println str[2]

try {
	str[2] = '!'
}catch(Exception ex) {
	println ex
}


// Lazy evaluation
what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text

// GString
def printClassInfo(obj) {

	println "class: ${obj.getClass().name}"
	println "superclass: ${obj.getClass().superclass.name}"

}

val = 125
printClassInfo ("The Stock closed at ${val}")
printClassInfo (/The Stock closed at ${val}/)
printClassInfo ("This is a simple string")


// GString lazy-evaluation problem
// Modifying the reference does not work as we expect.
// This is because of immutability.
price = 684.71
company = 'Google'
quote = "Today $company stock closed at $price"
println quote

stocks = [Apple : 663.01, Microsoft : 30.95]

stocks.each { key, value ->
	company = key
	price = value
	println quote
}


// Solution for lazy-evaluation
// use closure with no parameter
companyClosure = {it.write(company) }
priceClosure = {it.write("$price")}
quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each { key, value ->
	company = key
	price = value
	println quote
}

// Refactoring
// If closure has no parameters, then GString uses what we return.
companyClosure = { -> company }
priceClosure = { -> price }
quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each { key, value ->
	company = key
	price = value
	println quote
}

// more refactoring
quote = "Today ${-> company} stock closed at ${-> price}"
stocks.each { key, value ->
	company = key
	price = value
	println quote
}


