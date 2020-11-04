## [baekjoon-2579] 계단 오르기

![image](https://user-images.githubusercontent.com/22045163/98138014-02aba400-1f06-11eb-96da-fb16f6fbe374.png)
![image](https://user-images.githubusercontent.com/22045163/98138054-0d663900-1f06-11eb-8eb6-2f69fbc7e019.png)

### 점화식

```
/* 한 계단 오를 때 (연속 3번 방지) */
dp[n] = dp[n-3] + stair[n-1] + stair[n]
/* 두 계단 오를 때 */
dp[n] = dp[n-2] + stair[n]
```
