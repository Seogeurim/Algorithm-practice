## [baekjoon-1600] 말이 되고픈 원숭이

![image](https://user-images.githubusercontent.com/22045163/110055143-c4cd6800-7d9f-11eb-9779-631b3df0511e.png)

### visited 배열

> 힌트 : https://www.acmicpc.net/board/view/50114

이번 문제는 방문 처리에 있어서 좀 특이한 점이 있었다. 일차원적으로 방문 처리를 하면, 평범하게 지나가도 말처럼 지나가도 똑같은 차원에서 방문 처리가 된다. 그런데 이렇게 처리하는 경우 다음의 테스트케이스에서 `-1` 의 답이 나온다.

```text
1
5 5
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 1 0
answer : 6
```

bfs를 거치면서 말이 한 번 밟고 지나간 곳을, 평범하게 지나갈 때 다시 한 번 더 방문하지 못해 오답이 출력되는 것이다. 따라서 말이 밟은 횟수에 따라 차원을 설정해서 방문 처리를 진행해야 한다.

![image](https://user-images.githubusercontent.com/22045163/110055166-ce56d000-7d9f-11eb-9866-f1e161db018f.png)

### 2021.03.24

- [210324.java](Main2.java)
