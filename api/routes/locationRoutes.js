const express = require('express');
const controllers = require('../controllers/locationController');

const app = express.Router();

/** Path params are used to specify a resource. Query params are used to filter the resource. */

/** GET all sentiment counts for a specific location */
app.get('/:location', (req, res, next) => {
    controllers.getByLocation(req.params.location, req.query.sentiment).then((data) => {
        res.send(data);
    }).catch((e) => {
        res.status(400).send({
            message: e
        })
    });
});

module.exports = app;


