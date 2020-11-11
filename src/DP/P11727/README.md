## [baekjoon-11727] 2×n 타일링 2

![image](https://user-images.githubusercontent.com/22045163/98795831-08494280-244e-11eb-80ad-d70bd56e08fa.png)

### 점화식

```java
dp[1] = 1
dp[2] = 2
dp[n] = dp[n-1] + (dp[n-2] * 2)
```

[2xn 타일링](../P11726) 문제에 2x2 타일이 생겼으므로, 2x(n-2) 크기의 직사각형으로 잘랐을 때
경우의 수가 하나 더 생긴다. 그래서 2를 곱해준다.
