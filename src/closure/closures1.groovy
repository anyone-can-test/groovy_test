#!/usr/bin/env groovy


println("When to use cloures")


// We need to decide whether we want to implement a certain functionality or task
// as a regular function/method or whether we should use a closure.
// good area to use closure: resource cleanup, internal domain-specific languages
// Start with a function and use closure in refactoring
// Keep closures small and cohesive


def totalSelectValues(n, closure) {

	total = 0
	for(i in 1..n) {
		if(closure(i)) { total += i}
	}

	total

}


print "Total of even numbers from 1 to 10 is "
println totalSelectValues(10) { it % 2 == 0 }
// inline closure (just-in-time)


def isOdd = { it % 2 != 0}
print "Total of odd numbers from 1 to 10 is "
println totalSelectValues(10, isOdd)



class Equipment {

	def calculator
	Equipment(calc) { calculator = calc}
	def simulate() {
		println "Running simulation"
		calculator()		// We may send parameters as well

	}

}


def eq1 = new Equipment({println "Calculator 1"})
def aCalculator = {println "Calculator 2"}
def eq2 = new Equipment(aCalculator)
def eq3 = new Equipment(aCalculator)

eq1.simulate()
eq2.simulate()
eq3.simulate()



// Passing Parameters to Closure

def tellFortune(closure) {

	closure new Date("09/20/2012"), "Your day is filled with ceremony"
}

tellFortune() { date, fortune -> println "Fortune for ${date} is '${fortune}'" }
// The symbol -> separates parameter declaration from its body


