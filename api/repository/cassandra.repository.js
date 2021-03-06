const cassandra = require('cassandra-driver');
const constants = require('../constants/constants');

const client = new cassandra.Client(constants.dbConfig);

module.exports.getByLocationAndSentiment = async (location, sentiment) => {
    query =  `SELECT * from oubre.locations WHERE ls_name = \'${location} ${sentiment}\';`;
    return executeQuery(location, sentiment);
}

module.exports.getByLocation = async (location) => {
    response = [];
    for(i = 0; i < constants.sentiments.length; i++) {
        await executeQuery(location, constants.sentiments[i]).then((data) => {
            response.push(data);
        });
    }
    return response;
}

const executeQuery = (location, sentiment) => {
    query =  `SELECT * from oubre.locations WHERE ls_name = \'${location} ${sentiment}\';`;
    return client.execute(query).then((res) => {
        return res.rows[0];
    }).catch((e) => Promise.reject(`Unable to execute query for request of location: ${location} and sentiment: ${sentiment}.`, e));
}
