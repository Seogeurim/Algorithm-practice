## [baekjoon-3860] 할로윈 묘지

![image](https://user-images.githubusercontent.com/22045163/107381586-55fb4700-6b32-11eb-8c82-20c6b253656a.png)
![image](https://user-images.githubusercontent.com/22045163/107381632-64496300-6b32-11eb-81bd-1c336046635b.png)
![image](https://user-images.githubusercontent.com/22045163/107381670-70352500-6b32-11eb-9f44-808535cdbb02.png)

### 벨만-포드 알고리즘

본 문제는 출발 지점과 도착 지점이 있으며 음의 사이클을 체크하는 문제로, 벨만-포드 알고리즘을 사용해 풀 수 있다. 
특이한 점은 2차원 배열이라는 점이다.

![image](https://user-images.githubusercontent.com/22045163/107382044-cace8100-6b32-11eb-8080-866ccaa3b550.png)
![image](https://user-images.githubusercontent.com/22045163/107382117-e174d800-6b32-11eb-9bbc-c2e71c14be05.png)

처음에는 위 그림과 같이 BFS 풀이법처럼 생각해봤는데, 음의 사이클을 체크해야 하고 최단 거리를 찾아야 하므로 벨만-포드 알고리즘이 필요하다는 것을 
알게 되었다. 동서남북으로 갈 수 있는 출발-도착 노드와 그 거리, 귀신 구멍을 통해 순간이동할 수 있는 출발-도착 노드와 그 거리를 
edges 배열에 넣고 순회하면서 풀어나가면 된다.

![image](https://user-images.githubusercontent.com/22045163/107381710-7925f680-6b32-11eb-9222-daab4d10d142.png)
