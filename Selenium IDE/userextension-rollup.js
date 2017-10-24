var manager = new RollupManager();
 
manager.addRollupRule({
 name: 'googleSearchCommands'
 , description: 'Google Search'
 , args: [
 ], commandMatchers: [
 ]
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({
 command: 'open'
 , target: 'https://www.google.co.in/'
 });
 commands.push({
 command: 'sendKeys'
 , target: 'id=lst-ib'
 , value: args.searchKey
 });
commands.push({
 command: 'click'
 , target: 'css=div.sbibtd'
 });
 commands.push({
 command: 'clickAndWait'
 , target: 'name=btnK'
 });
 return commands;
 }
});