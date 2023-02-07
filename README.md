# 공유오피스

본 예제는 MSA/DDD/Event Storming/EDA 를 포괄하는 분석/설계/구현/운영 전단계를 커버하도록 구성한 예제입니다. 이는 클라우드 네이티브 애플리케이션의 개발에 요구되는 체크포인트들을 통과하기 위한 예시 답안을 포함합니다.

# 서비스 시나리오

## 기능적 요구사항

1. 운영자가 대여할 회의실을 등록/수정/삭제한다.

2. 고객이 회의실을 선택하여 예약한다.

3. 예약과 동시에 결제가 진행된다.

4. 예약이 되면 예약 내역(Message)이 전달된다.

5. 고객이 예약을 취소할 수 있다.

6. 예약 사항이 취소될 경우 취소 내역(Message)이 전달된다.

7. 회의실에 후기(review)를 남길 수 있다.

8. 전체적인 회의실에 대한 정보 및 예약 상태 등을 한 화면에서 확인 할 수 있다.(viewpage)

## 비기능적 요구사항

### 1. 트랜잭션

결제가 되지 않은 예약 건은 성립되지 않아야 한다. (Sync 호출)

### 2. 장애격리

회의실 등록 및 메시지 전송 기능이 수행되지 않더라도 예약은 365일 24시간 받을 수 있어야 한다 Async (event-driven), Eventual Consistency

예약 시스템이 과중되면 사용자를 잠시동안 받지 않고 잠시 후에 하도록 유도한다 Circuit breaker, fallback

### 3. 성능

모든 회의실에 대한 정보 및 예약 상태 등을 한번에 확인할 수 있어야 한다 (CQRS)

예약의 상태가 바뀔 때마다 메시지로 알림을 줄 수 있어야 한다 (Event driven)

## Event Storming 결과
https://labs.msaez.io/#/storming/be71767ff41d7451dc536032cebe2b0b
![image](https://user-images.githubusercontent.com/110404800/217167811-8b93f630-db6e-455c-81cc-e66fd1de6c4a.png)


# 구현

## **1. Saga (Pub-Sub)**
- reservation 예약 신청(POST)   
  ![image](https://user-images.githubusercontent.com/110404800/217293251-6c8f76f0-abad-4bc1-afab-e452c220ab0e.png)  
  
- reservation 예약 확인  
  ![image](https://user-images.githubusercontent.com/110404800/217293405-1cdd503f-e79b-4df3-b31c-fb989a14d3d7.png)  
  
- 예약신청 후 payment확인  
  ![image](https://user-images.githubusercontent.com/110404800/217293812-045b3c6e-8b4a-44c6-a5ec-31a23581052e.png)  

- 예약신청 후 kafka client확인
  ![image](https://user-images.githubusercontent.com/110404800/217183342-00a6f199-7896-4ad1-a41a-076d1fa1fb1b.png)

- 예약취소  
  ![image](https://user-images.githubusercontent.com/110404800/217183878-9030dfab-1f4c-4dbd-9af4-5212e170a83d.png)
  ![image](https://user-images.githubusercontent.com/110404800/217183913-39a7323c-d762-49bc-b738-dbf3289a348e.png)

- 예약취소 후 kafka client 확인
  ![image](https://user-images.githubusercontent.com/110404800/217183960-05e8cef5-4d05-4e60-82b7-53f3b60a63d1.png)


## 2**. CQRS**

## 3. **Compensation & Correlation**

4. **Request-Response (Not implemented)**

5. **Circuit Breaker (Not implemented)**


- 마이크로서비스 docker image 빌드 및 push  
  ![image](https://user-images.githubusercontent.com/110404800/217187118-1d2ca7c5-2e12-4740-b3f4-8defac86f7a7.png)  
  ![image](https://user-images.githubusercontent.com/110404800/217189910-56deef09-d9d1-4868-9efa-5033963e4f07.png)
  
  
# 운영


## 6. **Gateway / Ingress**
- gateway 스프링부트 App을 추가 후 application.yaml내에 각 마이크로 서비스의 routes를 추가하고 gateway 서버의 포트를 8080으로 설정함  
  ![image](https://user-images.githubusercontent.com/110404800/217177210-e416b6e4-d290-41bf-9adc-479cbeaf4e3f.png)
- Kubernetes용 Deployment.yaml 을 작성하고 Kubernetes에 Deploy를 생성  
  ![image](https://user-images.githubusercontent.com/110404800/217177485-396da718-ab7c-40c6-8533-975126ee9122.png)
- 생성된 Deploy 확인  
  ![image](https://user-images.githubusercontent.com/110404800/217284310-e31be71b-b8ee-4961-83c7-b397086ff466.png)
- Kubernetes용 Service.yaml에서 Gateway 엔드포인트 확인 및 서비스 생성  
  ![image](https://user-images.githubusercontent.com/110404800/217284942-36a5db28-47b5-482e-bb88-2e0ffe2f49ad.png)
  
  
  

## 7. **Deploy / Pipeline**

## 8. **Autoscale (HPA)**

## 9. **Zero-downtime deploy (Readiness probe)**

## 10. **Persistence Volume/ConfigMap/Secret**

## 11. **Self-healing (liveness probe)**

## 12. **Apply Service Messh**

## 13. **Loggregation / Monitoring**
