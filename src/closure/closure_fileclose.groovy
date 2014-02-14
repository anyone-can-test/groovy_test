#!/usr/bin/env groovy

// On resource-intensive, close(), destroy()
// Users of class may forget to call these methods.


writer = new FileWriter('output.txt')
writer.write('!')

// If we run this code, the file output.txt will not have the data or characters we wrote


// Using closure
// withWriter(): Groovy-added method
// withWriter() flushes and closes the stream automatically when we return from the closure
new FileWriter('output.txt').withWriter { writer -> writer.write('a') }


// Example
// We expect users of class Resource to call open() before calling any other methods,
// and then call close() when done

class Resource {

	def open() { print "opened" }
	def close() { print "closed" }
	def read() { print "read..." }
	def write() { print "write..." }

		
	// Use a closure
	def static use(closure) {

		def r = new Resource()
		try {
			r.open()
			closure(r)
		}finally {
			r.close()
		}
	}
}

def normal_res = new Resource()
normal_res.open()
normal_res.read()
normal_res.write()
normal_res.close()


Resource.use { res -> 
	res.read()
	res.write()
}
