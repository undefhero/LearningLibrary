const http = require('http');
const crypto = require("crypto");

const port = 3000;
const serverId = crypto.randomBytes(4).toString('hex');

const handler = (req, res) => {
  console.log(`Server ${serverId} received request!`)

  res.writeHead(200, {'Content-Type': 'application/json'});
  res.write(JSON.stringify({response: `Server ${serverId} responded!`}));
  res.end();
}

console.log(`Server ${serverId} started.`)

http.createServer(handler).listen(port);