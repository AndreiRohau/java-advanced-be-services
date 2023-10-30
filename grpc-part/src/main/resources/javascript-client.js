const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');

//const packageDefinition = protoLoader.loadSync('path/to/your/proto/file.proto');
const packageDefinition = protoLoader.loadSync('../proto/Ping.proto');
const protoDescriptor = grpc.loadPackageDefinition(packageDefinition);
const pingService = protoDescriptor.com.example.stubs.ping.PingService;

const SERVER_ADDRESS = 'localhost:50055'; // Replace with the actual server address

const channel = new grpc.Channel(SERVER_ADDRESS, grpc.credentials.createInsecure());
const client = new pingService(channel);

function sendMessage() {
  const request = { message: '!_!_!_PING_!_!_! SCRIPT' };

  client.ping(request, (error, response) => {
    if (error) {
      console.error('Error:', error.message);
      return;
    }

    console.log('Response received:', response.message);
  });
}

sendMessage();