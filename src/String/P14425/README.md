## [baekjoon-14425] 문자열 집합

![image](https://user-images.githubusercontent.com/22045163/102742413-2e8cc700-4398-11eb-8039-00a6f1aaa102.png)

### 더 효율적인 알고리즘 생각하기

본 문제는 대상 문자열이 문자열 집합 내에 있는지 일일이 검사해보는 수밖에 없다.

처음에는 다음과 같이 `O(N*M)` 으로 풀었다. 시간 제한이 2초이고, 
`N`과 `M`의 최댓값은 `10000`이기 때문에 문제 없었다.

```java
String S = new String[N];
for (int i = 0; i < N; i++) S[i] = br.readLine();

int ans = 0;
for (int i = 0; i < M; i++) {
    String s = br.readLine();
    for (int j = 0; j < N; j++) {
        if (s.equals(S[j])) ans ++;
    }
}
```

이 때 답은 맞았으나 시간 효율이 좋지 않은 것 같아 다른 코드를 참고하였고, 
Java Collections의 **HashSet**을 이용하면 시간 복잡도를 크게 줄일 수 있다는 것을 알게 되었다.

**HashSet**의 `Add`, `Contains` 연산의 시간 복잡도는 모두 **O(1)** 이다. 
따라서 다음과 같이 코드를 작성하면 더 좋은 코드가 될 수 있겠지 !!

```java
HashSet<String> hs = new HashSet<>();
while (N-- > 0) hs.add(br.readLine());

int ans = 0;
for (int i = 0; i < M; i++)
    if (hs.contains(br.readLine())) ans ++;
```

![image](https://user-images.githubusercontent.com/22045163/102742722-ec17ba00-4398-11eb-8bc9-479a07214da8.png)

시간 복잡도를 `2648ms` 에서 `424ms`로 줄일 수 있다.
