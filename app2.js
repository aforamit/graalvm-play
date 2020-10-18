const http = require("http");

http.createServer(function (request, response) {
    response.writeHead(200, {"Content-Type": "text/html"});
    response.end("Hello Graal.js!");
}).listen(8000, function()
    {
        console.log("Graal.js server running at http://127.0.0.1:8000/");
    }
   );

//setTimeout(function() { console.log("DONE!"); process.exit(); }, 20000);