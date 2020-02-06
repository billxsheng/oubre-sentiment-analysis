const express = require('express');
const app = express();
const PORT = 8080;
const routes = require('./routes/routes.js');

app.use('/', routes);

app.listen(PORT);

