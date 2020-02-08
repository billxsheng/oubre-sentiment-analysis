module.exports.sentiments = ['POSITIVE', 'NEGATIVE', 'NEUTRAL'];

module.exports.errors = {
    invalidSentiment: 'Invalid sentiment. Permitted sentiments are POSITIVE, NEGATIVE, and NEUTRAL.'
}

module.exports.dbConfig = {
    contactPoints:["127.0.0.1"],
    localDataCenter: 'datacenter1',
    keyspace: 'oubre'
}