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

# 구현

## **1. Saga (Pub-Sub)**

- 고객이 예약 Post 후 상태
![B6EE69C2-F1BB-4BEE-9EBD-10B5A91C7546](https://user-images.githubusercontent.com/110404800/217155674-56bf206d-2b75-47f0-9e91-e761c7968241.png)

- 예약 확인

![6C1D5B8C-CF3E-419C-8AAE-7570D60AB469](https://user-images.githubusercontent.com/110404800/217157122-42712965-f3ea-4934-8cd5-9dc83f013286.png)

- 고객이 예약 취소 후 상태

- 


## 2**. CQRS**

## 3. **Compensation & Correlation**

4. **Request-Response (Not implemented)**

5. **Circuit Breaker (Not implemented)**

# 운영

## 6. **Gateway / Ingress**

## 7. **Deploy / Pipeline**

## 8. **Autoscale (HPA)**

## 9. **Zero-downtime deploy (Readiness probe)**

## 10. **Persistence Volume/ConfigMap/Secret**

## 11. **Self-healing (liveness probe)**

## 12. **Apply Service Messh**

## 13. **Loggregation / Monitoring**
