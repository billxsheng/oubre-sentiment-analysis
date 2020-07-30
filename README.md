# oubre-sentiment-analysis
A complete data platform that performs sentiment analysis on filtered tweets ingested from the Twitter API. Data is sent to a Kafka topic where it is consumed by a Spark job where tweets are analyzed and sent to a Cassandra database. From there, a periodic Spark job (run every 24 hours) aggregates and writes the data into another Cassandra database. Finally, the data can be read by consumers through a Node API.

![](https://github.com/billxsheng/oubre-sentiment-analysis/blob/master/flowchart.png?raw=true)

