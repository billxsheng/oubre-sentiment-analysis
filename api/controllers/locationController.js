const repository = require('../repository/cassandra');
const utils = require('../utils/stringUtils');
const constants = require('../constants/constants');

module.exports.getByLocation = async (location, sentiment) => {
    let locationFormatted = utils.toTitleCase(location);
    if(sentiment == null) {
        return repository.getByLocation(locationFormatted).then((data) => {
            return data;
        }).catch((e) => {
            return Promise.reject(e);
        });
    }
    let sentimentFormatted = sentiment.toUpperCase().replace(/\"/g, "");
    if(!constants.sentiments.includes(sentimentFormatted)) {
        return Promise.reject(constants.errors.invalidSentiment);
    }
    return repository.getByLocationAndSentiment(locationFormatted, sentimentFormatted).then((data) => {
        return data;
    }).catch((e) => {
        return Promise.reject(e);
    });
}