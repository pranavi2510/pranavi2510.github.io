const http = require('http');
const server = http.createServer(
    (req,res) => {
        if(req.url == '/'){
            res.write("Hello World!");
            res.end();
        }
        if(req.url =='/api/departments'){
            res.write(JSON.stringify([{id: 1, name : 'Pranavi'},{id:2, name : 'Dhee'}]));
            res.end();
        }
    }
);
const PORT = 3000;
server.listen(PORT);

console.log(`Listening on port ${PORT}`);