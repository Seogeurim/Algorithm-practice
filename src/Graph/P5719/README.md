## [baekjoon-5719] 거의 최단 경로

![image](https://user-images.githubusercontent.com/22045163/107655671-00a46e80-6cc7-11eb-83e9-e2834b9a87be.png)
![image](https://user-images.githubusercontent.com/22045163/107656046-19ad1f80-6cc7-11eb-80db-179aaa45aefc.png)

### 풀이 과정

다익스트라 응용 문제이다. 많이 어려웠다. ㅠㅠ

처음에는 [K번째 최단경로 찾기](../P1854) 문제와 같은 방식으로 2번째 최단 경로를 찾으면 되는줄 알았으나, 이 문제는 그렇게 푸는 것이 아니라 
**최적의 최단 경로를 찾은 후 그 최단 경로를 지우고, 다시 최단 경로를 찾아야** 올바른 정답을 도출할 수 있었다. 
즉 다익스트라 -> 최단 경로 지우기 -> 다익스트라 순서로 풀이해야 하는 것이다.

최단 경로를 지우는 방법은 마지막 노드에서 역순으로 거쳐온 노드를 찾아 해당 정보를 지우면 되고, bfs를 통해 해결할 수 있다. 
이 때 방문했던 노드에 대해서는 방문 처리를 해주어야 bfs 메모리 초과 이슈를 피할 수 있다.

![image](https://user-images.githubusercontent.com/22045163/107656230-4bbe8180-6cc7-11eb-910a-74af12747b03.png)

![image](https://user-images.githubusercontent.com/22045163/107656082-23cf1e00-6cc7-11eb-84fd-3cf205abc5a8.png)
