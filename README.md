# Prerequisite

* IDE with lombok installed (eg: IDEA)
* JDK 17

# Build and run

## From IDEA

1. New project from existing sources
2. Run Gradle Tasks > application > bootRun

## From Terminal

Execute the following command:

```bash
./gradlew bootRun
```

# Generate sample response

## Terminal

Execute the following command:

```bash
curl -X 'GET' \
  'http://localhost:8080/api/v1/report/trade?reportType=fxForward&brokerName=Broker_A&tradeDate=2020-04-08' \
  -H 'accept: text/csv'
```

## Swagger UI

Navigate to [swagger-ui](http://localhost:8080/api/swagger-ui/index.html#/trade-report-controller/getCsvTradeReport)

Click `Try it now` with the following data entered:

```
reportType: fxForward
brokerName: Broker_A
tradeDate: 2020-04-08
```

Click `Execute`

# Miscellaneous

## H2 Console

To view the db records, navigate to [h2-console](http://localhost:8080/api/h2-console/)

Default h2 db file was located at `~/h2/complus-am-assignment-v2`