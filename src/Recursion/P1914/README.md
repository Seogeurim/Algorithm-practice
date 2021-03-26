## [baekjoon-1914] 하노이 탑

![image](https://user-images.githubusercontent.com/22045163/112584513-537f5300-8e3b-11eb-89d3-b26dffb75170.png)

### 풀이 과정

하노이 탑은 대표적인 재귀 문제이다. 아래의 그림을 보면 재귀라는 것을 단번에 알 수 있다.

![image](https://user-images.githubusercontent.com/22045163/112510475-cc978f80-8dd4-11eb-8d30-9b6424f23339.png)

이 문제는 재귀 뿐만 아니라 큰 수에 대한 연산 처리가 필요한 문제이다. N의 크기는 100이며, 하노이 탑의 실행 횟수는 2^N-1이다. 그럼 최대 2^100까지 연산이 필요한데, 2^100은 `long`으로도 처리할 수 없는 큰 수이다. (`long`은 64비트) 따라서 `java.math.BigInteger`를 사용해 풀었다.

```java
new BigInteger("2").pow(N).subtract(new BigInteger("1"))
```

![image](https://user-images.githubusercontent.com/22045163/112584545-61cd6f00-8e3b-11eb-9c19-35b310bfa309.png)
