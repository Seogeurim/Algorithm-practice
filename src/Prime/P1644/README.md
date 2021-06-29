## [baekjoon-1644] 소수의 연속합

![image](https://user-images.githubusercontent.com/22045163/123810129-21dfc180-d92d-11eb-881a-48f1d52a544a.png)

### 소수 리스트 만들기 - 시간 더 줄이기

```java
List<Integer> primes = new ArrayList<>();
boolean[] primeCheck = new boolean[N+1];

for (int i = 2; i <= N; i++) {
    if (!primeCheck[i]) {
        primes.add(i);
        for (int j = 2; i*j <= N; j++) {
            primeCheck[i*j] = true;
        }
    }
}
```

이전에는 다음과 같이 단순하게 이중포문을 돌려 소수를 구했다.

```java
for (int i = 2; i <= N; i++) {
    for (int j = 2; i*j <= N; j++) {
        primeCheck[i*j] = true;
    }
}
```

하지만 이렇게 하지 않고 앞선 코드와 같이 `if (!primeCheck[i])` 조건을 넣어주면 훨씬 더 시간복잡도를 줄일 수 있다.

![image](https://user-images.githubusercontent.com/22045163/123810175-2c01c000-d92d-11eb-9acb-6ce98393acd8.png)
