#!/usr/bin/env groovy


// Using Object extenstions

// dump(), inspect()

// with() == identify()
lst = [1, 2]
lst.add(3)
lst.add(4)
println lst.size()
println lst.contains(2)


lst = [1, 2]
lst.with {
	add(3)
	add(4)
	println size()
	println contains(2)
}

// How does the with() method know to route calls within the closure 
// to the context object?



