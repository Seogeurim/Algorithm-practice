## [2020 카카오 인턴십] 동굴 탐험

![image](https://user-images.githubusercontent.com/22045163/116604124-b4350a80-a968-11eb-906c-5dab06c5d19f.png)

### Stack Overflow 이슈

처음에 문제 풀이가 떠오르지 않아 해설을 참고한 후 구현(**양방향 그래프 -> 단방향 그래프 변환 -> 사이클 체크**)하였고, 돌렸는데 효율성 점수에서 마지막 2개가 `런타임 에러`가 나는 것이다. 이 문제로 3시간을 헤맸다. 휴.......

입력값의 크기가 매우 크니 dfs 호출을 하는만큼 스택 오버플로우가 나는 것이라면, Stack을 활용해 iterative하게 구현하는 방법이 있다. 하지만 그 방법이 떠오르지 않아서 몇 번을 코드를 짜고 지웠다. (시간날 때 인터넷을 더 찾아봐야겠다.) 그리고 어이가 없던 것은 어쨌든 호출 횟수를 줄이니 풀렸던 것..

```java
void dfs(int node) {
    visited[node] = true;
    for (int next : graph[node]) {
        if (!visited[next]) {
            for (int nnext : graph[next]) {
                if (!visited[nnext]) dfs(nnext);
                else if (!finished[nnext]) {
                    hasCycle = true;
                    return;
                }
            }
        } else if (!finished[next]) {
            hasCycle = true;
            return;
        }
    }
    finished[node] = true;
}
```

내 코드에는 이렇게 올려놓지 않겠다 !!!
