var myMap = new UIMap();

myMap.addPageset({
	name: 'allPages' 
	, description: 'Google Search Page' 
	, pathRegexp: '.*' 
});

myMap.addElement('allPages', { 
	name: 'searchField' 
	, description: 'Google Search field' 
	, locator: "id=lst-ib" 
});

myMap.addElement('allPages', { 
	name: 'page' 
	, description: 'page body' 
	, locator: "css=div.sbibtd" 
});

myMap.addElement('allPages', { 
	name: 'searchButton' 
	, description: 'Google Search button' 
	, locator: "name=btnK" 
}); 