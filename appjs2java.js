/*
var HelloPolyglot = Java.type("HelloPolyglot");
console.log(" calling Java from Nodejs....");
HelloPolyglot.main(["no once", " alpha calling beta : Input from Node ==> Java"]);
console.log(" calling Java from Nodejs....done");
*/


const http = require("http");
var HelloPolyglot = Java.type("HelloPolyglot");

http.createServer(function (request, response) {
    response.writeHead(200, {"Content-Type": "text/html"});
    var now = Date.now();
    var currentNum = Math.floor((Math.random() * 100) + 1);

    log(" calling Java from Nodejs....");
    //HelloPolyglot.main(["once", "Input from Node ==> Java " + now]);
    var returnValFromJava = HelloPolyglot.callNode("Input from Node ==> Java " + now, currentNum);
    log(" calling Java from Nodejs....done ; Return value : " + returnValFromJava);

    response.end("Hello Graal.js! " + now + " ; Random : " + currentNum + " ; Java value : " + returnValFromJava);

}).listen(8000, function()
    {
        log("Graal.js server running at http://127.0.0.1:8000/");
    }
   );

//setTimeout(function() { log("DONE!"); process.exit(); }, 20000);

function log(message)
{
    console.log('NodeJs: ' + message);
}