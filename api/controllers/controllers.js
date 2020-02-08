const repository = require('../repository/repository');

module.exports.getByLocationAndSentiment = (location, sentiment) => {
    repository.getByLocationAndSentiment();
}

module.exports.getByLocation = (location) => {
    repository.getByLocation(location);
}