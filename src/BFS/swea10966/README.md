## [SW Expert Academy - 10966] 물놀이를 가자

![image](https://user-images.githubusercontent.com/22045163/111078581-87a06d00-8539-11eb-9580-d79a2f898fed.png)

### BFS에 대하여 한 가지를 더 기억해두자 !!!

어떤 점에서의 최단 경로를 찾을 때 많이 쓰이는 BFS가 DFS와 달리 가지고 있는 좋은 점은, **여러 점에서 동시에 출발할 수 있다**는 점이다. 위 문제는 이러한 BFS의 특징을 기억하지 않으면 시간 초과를 겪을 수 있는 문제이다. 특히 방문 체크 대신, **지금까지 지나온 거리를 배열에 저장**하여 답을 구할 수 있는 문제이다. 꼭 기억해두자.

![image](https://user-images.githubusercontent.com/22045163/111078663-009fc480-853a-11eb-984f-1aecf99b58a1.png)
