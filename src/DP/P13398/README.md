## [baekjoon-13398] 연속합 2

![image](https://user-images.githubusercontent.com/22045163/100982308-3cb2a900-358b-11eb-9cf0-37de27655ed8.png)

### 점화식

```java
dp[0][0] = dp[0][1] = arr[0];
dp[n][0] = Math.max(dp[n-1][0], 0) + arr[n];
dp[n][1] = Math.max(dp[n-1][0], dp[n-1][1] + arr[n]);
```

![IMG_BEB4BBF853D3-1](https://user-images.githubusercontent.com/22045163/100983690-00804800-358d-11eb-81a9-2f0c46161d57.jpeg)

후아.. 한참을 헤맨 문제다. 성장하자 !!!
