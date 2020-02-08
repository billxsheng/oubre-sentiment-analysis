const express = require('express');
const app = express();
const PORT = 8080;
const locationRoutes = require('./routes/locationRoutes.js');

app.use('/api/locations/', locationRoutes);

app.listen(PORT);

