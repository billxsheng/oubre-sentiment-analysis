const express = require('express');
const controllers = require('../controllers/controllers');

const app = express.Router();

/** GET all sentiment counts for a specific location */
app.get('/:location', (req, res) => {
    controllers.getByLocation(req.params.location);
});

/** GET sentiment count for a specific location and sentiment */
app.get('/location/:sentiment', (req, res) => {
    controllers.getByLocationAndSentiment(req.params.sentiment)
});

module.exports = app;

