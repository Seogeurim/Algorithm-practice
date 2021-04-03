## [baekjoon-1328] 고층 빌딩

![image](https://user-images.githubusercontent.com/22045163/113480062-6514ca80-94cd-11eb-93fd-cb364c613b91.png)

### 점화식

전 단계에서의 빌딩이 (1, 2) 이렇게 세워져있을 때 L, R의 값 (L: 2, R: 1)은 (2, 3)으로 세워져있을 경우와 같다. 여기에 1을 추가하는 경우를 생각해보자.

- 왼쪽에 추가 : (1, 2, 3), L: 3, R: 1 → L이 1 증가함
- 오른쪽에 추가 : (2, 3, 1), L: 2, R: 2 → R이 1 증가함
- 중간에 추가 : (2, 1, 3), L: 2, R: 1 → 변동 없음

위의 규칙으로 미루어 보았을 때 점화식은 다음과 같다.

```java
dp[1][1][1] = 1;
dp[N][L][R] = (dp[N-1][L-1][R] + dp[N-1][L][R-1] + dp[N-1][L][R]*(N-2));
```

![image](https://user-images.githubusercontent.com/22045163/113480204-2af7f880-94ce-11eb-8aa9-5aa0a5bedfdd.png)

ㅋㅋㅋㅋㅋ 이 문제 점화식 다 ~ 세워놓고 MOD 연산, 계산 실수, 오타 등등으로 5번 틀려버리기 ~~~ 그래도 이 문제 풀면 플래티넘 승진이라서 신났으니까 다 용서 ~~~~~~~~~~ 🎉🎉🎉

![image](https://user-images.githubusercontent.com/22045163/113480073-7067f600-94cd-11eb-9f36-ebeade4d1ab0.png)
