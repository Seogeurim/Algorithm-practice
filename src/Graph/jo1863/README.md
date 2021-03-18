## [JUNGOL-1863] 종교

![image](https://user-images.githubusercontent.com/22045163/111661412-59c96a00-8852-11eb-9c57-8700415db977.png)
![image](https://user-images.githubusercontent.com/22045163/111661481-6483ff00-8852-11eb-9efc-e3c0e0939e94.png)

### union-by-rank (union-by-height)

> 참고 자료 : [\[알고리즘\] Union-Find 알고리즘](https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html)

이 문제는 union 연산에 대한 최적화가 필요한 문제이다. union 연산의 최적화로는 union-by-rank를 사용한다. 

트리로 연결할 때 최악의 경우는 트리의 장점을 전혀 살리지 못하고 일렬로 자료가 계속 나열되는 경우가 있다. 이 경우 union, find 연산 모두 시간복잡도가 O(N)이 되어버린다. 이는 배열로 구현하는 것보다 비효율적이다. 따라서 find 연산과 union 연산을 최적화해주어야 하는데, 나는 그동안 find 연산 최적화(경로 압축)만 알고 있었다. union 연산의 최적화인 union-by-rank는 다음과 같이 구현한다.

- rank 배열에 트리의 높이를 저장한다.
- union 연산 시 항상 높이가 더 낮은 트리를 높은 트리 밑에 넣는다. 즉, 높이가 더 높은 쪽을 root로 삼는다.
- 두 트리의 rank가 동일하여 높이가 높아져야만 하는 경우에는 union 연산 후 결과 트리의 rank를 1 증가 시켜준다.

```java
void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b) return;
    if (rank[a] < rank[b]) root[a] = b;
    else {
        root[b] = a;
        if (rank[a] == rank[b]) rank[a] ++;
    }
}
```

![image](https://user-images.githubusercontent.com/22045163/111661537-706fc100-8852-11eb-9d59-1945a4401bf2.png)
