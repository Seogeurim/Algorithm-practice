## [baekjoon-13023] ABCDE

![image](https://user-images.githubusercontent.com/22045163/97014663-9a63d680-1585-11eb-8ffd-be4945e093c0.png)

### 시간 초과 이슈

처음에 시간 초과가 났었다. 이 문제는 다음과 같이 코드를 고치니 해결되었다.

```java
for (int i = 0; i < N; i++) {
    if (ans == 0) dfs(i, 1);
}
```

처음에는 `dfs`를 먼저 돌리고 count가 5가 되는 것을 찾았을 때 1을 출력하고 프로그램을 종료하도록 했었다. 
그런데 이렇게 하지 않고 `dfs`를 돌리기 전, count가 5가 되는 것을 찾았다면 돌리지 않는 방식으로 조건문을 설정하니 시간 초과 문제가 해결되었다.
