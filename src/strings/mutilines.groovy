#!/usr/bin/env groovy


// Use thress single quotes ('''..''') or three double quotes
memo = ''' multiple lines 1
To discuss this,
hello
'''

println memo


langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy' ]

content = ''
langs.each{ language, author ->
	fragment = """
		<language name = "${language}">
			<author>${author}</author>
		</language>
	"""

	content += fragment
}

xml = "<language>${content}</language>"
println xml



// String convenience methods

str = "It's rainy day in Seattle"
println str
str -= "rainy "
println str
