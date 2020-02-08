const cassandra = require('cassandra-driver');

const client = new cassandra.Client({
    contactPoints:["127.0.0.1"],
    localDataCenter: 'datacenter1',
    keyspace: 'oubre'
})

module.exports.getByLocationAndSentiment = (location, sentiment) => {
    query =  `SELECT * from oubre.locations WHERE ls_name = \'${location} ${sentiment}\';`;
    client.execute(query).then((res) => {
        return res.rows;
    }).catch((e) => {
        console.log(e);
    })
}

module.exports.getByLocation = (location) => {
    `SELECT * from oubre.locations WHERE ls_name = \'${location} ${sentiment}\';`
}
