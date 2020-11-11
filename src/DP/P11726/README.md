## [baekjoon-11726] 2×n 타일링

![image](https://user-images.githubusercontent.com/22045163/98793167-dedae780-244a-11eb-908a-c105ebdaffd7.png)

### 점화식

```java
dp[1] = 1
dp[2] = 2
dp[n] = dp[n-1] + dp[n-2]
```

### 왜 이런 식이 성립하나?

![image](https://user-images.githubusercontent.com/22045163/98794521-7f7dd700-244c-11eb-994b-0364be020798.png)

2xn 크기의 직사각형은 2x(n-1) 크기의 직사각형을 채우고 2x1 타일을 채우는 방법의 수와, 
2x(n-2) 크기의 직사각형을 채우고 1x2 타일 두 개를 채우는 방법의 수를 합친 것과 같다.
그 이상으로 더 자르면 대칭이거나, 이미 이전 단계의 경우의 수를 다 세었기 때문에 더 생각할 필요가 없다.
