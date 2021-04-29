# oubre-sentiment-analysis
A complete data platform that performs sentiment analysis on filtered tweets ingested from the Twitter API. Data is sent to a Kafka topic where it is consumed by a Spark job. From there, tweets are analyzed and sent to a Time Series Cassandra database. Afterwards, a periodic Spark job (run every 24 hours) aggregates and writes the data into another Cassandra database. Finally, the data can be consumed by clients through a Node API.

![](https://github.com/billxsheng/oubre-sentiment-analysis/blob/master/flowchart.png?raw=true)

