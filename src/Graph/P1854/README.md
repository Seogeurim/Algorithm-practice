## [baekjoon-1854] K번째 최단경로 찾기

![image](https://user-images.githubusercontent.com/22045163/106920032-068dd300-674e-11eb-81d0-e3f362577bcc.png)

### 풀이 로직

다익스트라 알고리즘은 현재 계산된 최단 거리보다 큰 값이 들어오면 무시해버린다. 
이 문제는 그 값을 무시하지 않고 top `K` 를 뽑는 것이다. 어떻게 이런 생각을 했을까. 
참 재밌는 다익스트라 🧘🏼‍♂️

![image](https://user-images.githubusercontent.com/22045163/106920894-d266e200-674e-11eb-9e49-c85bd39be790.png)
