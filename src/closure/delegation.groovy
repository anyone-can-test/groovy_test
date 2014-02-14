#!/usr/bin/env groovy


// powerful capabilities
// Three properties of a closure: this, owner, and delegate


def examiningClosure(closure) {

	closure()

}

examiningClosure() {
	println "In first closure:"
	println "class is " + getClass().name
	println "this is " + this + ", super: " + this.getClass().superclass.name
	println "owner is " + owner + ", super: " + owner.getClass().superclass.name
	println "delegate is " + delegate + ", super: " + delegate.getClass().superclass.name

	examiningClosure() {
	    println "In closure within the first closure:"
		println "class is " + getClass().name
		println "this is " + this + ", super: " + this.getClass().superclass.name
		println "owner is " + owner + ", super: " + owner.getClass().superclass.name
		println "delegate is " + delegate + ", super: " + delegate.getClass().superclass.name

	}
}
