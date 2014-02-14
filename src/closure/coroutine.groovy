#!/usr/bin/env groovy

// We can enter a function, execute part of it, suspend,
// and go back to execute some code in the context or scope of the caller.
// We can then resume execution of the function from where we suspended.
// "In contrast to the unsymmetric relationship between a main routine and a subroutine,
// there is complete symmetry between coroutines, which call on each other."


// In Java, wait() and notify() help implement coroutines when combined with multithreading.
// Closures -> in a single thread

def iterate(n, closure) {

	1.upto(n) {
		println "In iterate with value ${it}"
		closure(it)

	}
}

println "Calling iterate"
total = 0
iterate(4) {
	total += it
	println "In closure total so far is ${total}"
}

println "done"


