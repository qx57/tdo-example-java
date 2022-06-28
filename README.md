# Example for TDO usage in TypeScript tests

## Requirements

* Java ^1.8
* Docker

## Description

TDO (Test entity Definition Object) is the class of objects which defines testing entities such as web pages, API endpoints, DB tablest and other. TDO usage makes your autotests more uniform, maintenanceable and readable.

See the TestDriven Conf presentation for more info.

**ATTENTION!** API and DB tests fail on 3rd step - it's ok because used lazy stub have no behavior changing order status.

## Before run tests

1. Before you run this example tests needed up all docker containers:

```bash
> docker run --name wiremock -p 4231:8080 -d rodolpheche/wiremock
> docker run --name postgres -e POSTGRES_PASSWORD=pwd123 -e POSTGRES_USER=postgres -e POSTGRES_DB=test -p 6543:5432 -d postgres
```

1. Set wiremock through API requests POST http://localhost:4231/__admin/mappings/, use body from **resource** directory. More info about Wiremock settings [here](https://wiremock.org/docs/request-matching/).

2. Set DB through any client, send next SQL queries:

```sql
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    status VARCHAR
);
```

and then

```sql
INSERT INTO orders (id, status) VALUES (123, 'new');
```

You are ready to check exanple tests! =)

## Test running

You can start tests in IDEA or use maven:

```bash
> mvn clean test
```

## Contributors

[qx57](https://github.com/qx57)