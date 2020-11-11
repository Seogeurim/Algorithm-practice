## [baekjoon-1463] 1로 만들기

![image](https://user-images.githubusercontent.com/22045163/98788838-c5cf3800-2444-11eb-8624-3fb3f0b3ca6e.png)

### 점화식

```java
dp[1] = 0
dp[n] = Math.min(dp[n-1], dp[n/2], dp[n/3]) + 1
// n/2, n/3은 나누어 떨어지는지 확인
```
