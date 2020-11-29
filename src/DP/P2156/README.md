## [baekjoon-2156] 포도주 시식

![image](https://user-images.githubusercontent.com/22045163/100535918-62287580-3260-11eb-8998-2e3bc2e5d86d.png)

![IMG_31725EF2855A-1](https://user-images.githubusercontent.com/22045163/100535944-a4ea4d80-3260-11eb-85ce-14491fecb3f4.jpeg)

### 점화식

`dp` 배열 : 지금껏 선택한 것들 중 최대의 값 (연속 3개 선택 x)

```java 
dp[1] = drink[1]
dp[2] = drink[1] + drink[2]
...
dp[n] = Math.max(dp[n-2] + drink[n], drink[n-3] + drink[n-1] + drink[n])
dp[n] = Math.max(dp[n-1], dp[n]) /* 연속 2개 선택 x */
```
