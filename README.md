Available metrics:

```
http://localhost:8080/actuator/metrics
```

```
http://localhost:8080/actuator/metrics/http.server.requests
```

```
http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:/customers
```

`/customers` and was with http `200`

```
http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:/customers&tag=status:200
```

#### Create network

```
docker network create monitoring
```

#### Start prometheus:

TODO: store data!

```bash
docker container run -d -p 9090:9090 \
    -v $(pwd)/prometheus/:/etc/prometheus/ \
    --name prometheus \
    --net monitoring \
    prom/prometheus:v2.11.1
```

Access in the browser:

`http://localhost:9090`

Verify that we have the target `prometheus-grafana-demo`

Query in prometheus:

```
http_server_requests_seconds_count{uri="/customers"}
```

#### Start grafana

docker container run -d -p 3000:3000 \
    -v $(pwd)/grafana/provisioning/:/etc/grafana/provisioning/ \
    -e "GF_SECURITY_ADMIN_PASSWORD=Welcome1_" \
    -e "GF_USERS_ALLOW_SIGN_UP=false" \
    --name grafana \
    --net monitoring \
    grafana/grafana:5.4.3


Login to grafana with:

`admin/Welcome1_`

Populare dashboards:

https://grafana.com/grafana/dashboards/4701
