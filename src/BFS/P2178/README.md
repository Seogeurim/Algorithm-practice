## [baekjoon-2178] 미로 탐색

### 처음에 메모리 초과가 났다.

BFS 방문 표시는 큐에서 뺄 때가 아닌 넣을 때 해야 중복 방문이 일어나지 않습니다. 
BFS에서 많은 사람들이 하는 실수입니다. 
BFS 문제에서 메모리 초과가 나면 대부분은 이것 때문이라고 볼 수 있습니다.

![image](https://user-images.githubusercontent.com/22045163/93305485-8a93fc80-f839-11ea-83ea-6d62f870a772.png)
