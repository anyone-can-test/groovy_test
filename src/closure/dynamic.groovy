#!/usr/bin/env groovy


def doSomeThing(closure) {

	if(closure) {
		closure()
	}else {
		println "Using default implementation"

	}

}

doSomeThing() { println "Use specialized implementation" }
doSomeThing()


def completeOrder(amount, taxComputer) {

	tax = 0
	if (taxComputer.maximumNumberOfParameters == 2) {
		tax = taxComputer(amount, 6.05)

	}else {
		tax = taxComputer(amount)

	}

	println "Sales tax is ${tax}"

}

completeOrder(100) { it * 0.0825}
completeOrder(100) { amount, rate -> amount * (rate/100) }

println ""
println "ClosuresParameterTypes"
def examine(closure) {

	println "${closure.maximumNumberOfParameters} parameters(s) given:"
	for(aParameter in closure.parameterTypes) { println aParameter.name }

	println "--"
}

examine() {}
examine() {it}
examine() {->}



