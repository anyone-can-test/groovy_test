#!/usr/bin/env groovy


// String convenience methods

str = "It's rainy day in Seattle"
println str
str -= "rainy "
println str


for(str in 'held'..'helm') {
	print "${str} "
}

println ""
