![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# 과제 - 음식배달

## 1. EventStorming Model : Design Level

![image](https://github.com/perker0120/example-food-delivery/assets/38679524/b846f6d6-1da8-4734-ba72-0d1532c2ae46)

## 2.Saga (Pub / Sub)
### 1) front의 OrderPlaced 이벤트 발생
![image](https://github.com/perker0120/food-delivery/assets/38679524/bffdbac2-6e4d-4d0f-abaa-dda97b2929c0)

### 2) store의 order copy policy UPDATE
![image](https://github.com/perker0120/food-delivery/assets/38679524/870bc11a-73a8-4f10-8677-29e19f439797)

## 3. CQRS
### 1) Read Model Attributes
![image](https://github.com/perker0120/example-food-delivery/assets/38679524/3b002cfb-7d8e-443b-a9ed-6a512039254d)
### 2) Read Model : CREATE
![image](https://github.com/perker0120/example-food-delivery/assets/38679524/496d13ee-2ce5-4db3-b1b1-b210e685ccc1)
### 3) Read Model : UPDATE
![image](https://github.com/perker0120/example-food-delivery/assets/38679524/46c0bed6-9e7e-4c0c-a583-d743baa24ff6)

## 4. Compensation / Correlation
![image](https://github.com/perker0120/food-delivery/assets/38679524/380bf980-ddf5-4578-a653-6c420c816644)

![image](https://github.com/perker0120/food-delivery/assets/38679524/9378df30-81d6-4e56-a872-f315b2f3373b)

![image](https://github.com/perker0120/food-delivery/assets/38679524/fabe836a-bd6e-4a25-943d-171082a476e4)

![image](https://github.com/perker0120/food-delivery/assets/38679524/547795a3-f905-4bc4-b2c2-f78e2ac150bf)




## Model
www.msaez.io/#/storming/sh-food-delivery

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- front
- store
- rider
- customer


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- front
```
 http :8088/orders id="id" foodId="foodId" options="options" address="address" customerId="customerId" storeId="storeId" 
 http :8088/payments id="id" orderId="orderId" status="status" 
```
- store
```
 http :8088/foodCookings id="id" status="status" foodId="foodId" orderId="orderId" options="options" storeId="storeId" customerId="customerId" 
```
- rider
```
 http :8088/deliveries id="id" status="status" orderId="orderId" address="address" 
```
- customer
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

