// The "inDocument" is a document you are searching.
	PageBot.prototype.locateElementByUpperCase = function(text, inDocument) {
	    // Create the text to search for
	    var expectedValue = text.toUpperCase();
	
	    // Loop through all elements, looking for ones that have 
	    // a value === our expected value
	    var allElements = inDocument.getElementsByTagName  ("*");
	    for (var i = 0; i < allElements.length; i++) {
	        var testElement = allElements[i];
	        if (testElement.innerHTML && testElement.innerHTML === expectedValue) {
	            return testElement;
	        }
	    }
	    return null;
	}; 
