# DAG(Directed Acyclic Graph)와 위상정렬(Topological Sort)

위상정렬이란, **그래프를 정렬**하는 것이다.  
이 때 그래프는 **DAG 그래프**여야 하고, 정렬 기준은 **진입 차수의 비내림차순**이다.

> 비내림차순(nondecreasing order)이란, 말 그대로 내림차순이 아닌 것을 말한다.
> 오름차순이지만 특정 원소(값이 같은 원소들)에 대해서는 오름차순이 아닐 수도 있다는 것이다.

DAG 그래프, 진입 차수의 비내림차순 등 이게 무슨 말인지 좀 더 세세하게 알아보자.

## DAG(Directed Acyclic Graph) - 싸이클이 없는 방향 그래프

- 말 그대로 싸이클(순환)이 없는 방향 그래프이다. 
- 우선순위를 가진 작업들을 표현할 수 있다. (예 : 대학 과정의 선수과목)

> DAG 예시

![DAG예시](https://user-images.githubusercontent.com/22045163/90796313-19e8e580-e34a-11ea-99cb-9f3c4a8cbc55.jpg)


### 선행자(predecessor)와 후행자(successor)

DAG에서 노드 A에서 노드 B로의 경로가 존재할 때, 
- A는 B의 선행자(predecessor)이다.
- B는 A의 후행자(successor)이다.

### 즉각 선행자(immediate predecessor)와 즉각 후행자(immediate successor)

DAG에서 노드 A에서 노드 B로의 엣지 e가 존재할 때, 
- A는 B의 즉각 선행자(immediate predecessor)이다.
- B는 A의 즉각 후행자(immediate successor)이다.

## 위상정렬(Topological Sort)

- DAG에서 그래프의 방향에 따라 노드들을 나열하는 것을 말한다. 즉, 우선순위에 따라 배치한 것이라고 할 수 있다.
- 일반적으로 위상정렬의 결과는 유일하지 않다.

![위상정렬](https://user-images.githubusercontent.com/22045163/90590514-b496d680-e21b-11ea-9f23-29f3e571be24.jpg)

방향 그래프에서 어떤 노드에 들어오는 엣지의 수를 in-degree, 나가는 엣지의 수를 out-degree라고 한다고 했다. ([그래프 용어 정리 참고](https://github.com/Seogeurim/Algorithm-practice/blob/master/notes/Graph/Graph.md#%EA%B7%B8%EB%9E%98%ED%94%84-%EC%9A%A9%EC%96%B4))

위 그림을 살펴보면, 각 노드별로 진입 차수, 즉 in-degree 를 나열하고 있다. 
- 이 때 **in-degree가 0인 노드(시작점)** 가 반드시 존재해야 한다.  
  `이 노드가 존재하지 않는다는 말은 싸이클이 존재한다는 것이므로, DAG가 아니다.`
- 우리는 이 in-degree 값을 이용해서 그 값이 0 -> N 인 순으로 탐색할 것이다.  
  `왜냐하면 "그래프를 진입 차수의 비내림차순으로 정렬"할 것이니까 !!`
- 탐색 과정을 거치면서 in-degree 값이 0인 노드들은 제거해나갈 것이고, 그렇지 않은 노드들은 점점 0으로 수정한 뒤 제거해가며 정렬을 해나갈 것이다.

위 원리를 이해하고 그림을 더 자세히 살펴보면 다음의 과정을 거쳐서 결과를 도출해내고 있음을 알 수 있다.

1. in-degree가 0인 노드를 찾는다. 1이다.
2. 노드 1을 제거하고, 노드 1의 즉각 후행자(immediate successor)들인 노드 2, 3, 4의 in-degree를 1씩 감소한다.
3. in-degree가 0인 노드를 찾는다. 3이다.
4. 노드 3을 제거하고, 노드 3의 즉각 후행자인 노드 4의 in-degree를 1 감소한다.
5. in-degree가 0인 노드를 찾는다. 4이다.
6. 노드 4를 제거하고, 노드 4의 즉각 후행자들인 노드 2, 5의 in-degree를 1 감소한다.
7. in-degree가 0인 노드를 찾는다. 2이다.
8. 노드 2를 제거하고, 노드 2의 즉각 후행자인 노드 5의 in-degree를 1 감소한다.
9. in-degree가 0인 노드를 찾는다. 5이다.
10. 노드 5를 제거한다. 모든 노드가 제거되었다.
11. 제거한 노드들을 차례로 보면, 노드 1 > 3 > 4 > 2 > 5 이다.

이렇게 위상정렬 [1, 3, 4, 2, 5] 를 도출하였다. 과정을 살펴보면 다음의 로직을 발견할 수 있다.

```
반복 (노드가 모두 제거될 때까지) {
  1. in-degree가 0인 노드를 찾는다.
  2. 그 노드를 제거한다.
  3. 그 노드의 즉각 후행자들의 in-degree를 1씩 감소한다.
}
```

그럼 이제 이 로직을 어떻게 코드로 구현할 수 있을지 생각해보자.

## 위상정렬의 구현

### 그래프 생성

우선 그래프의 정보를 알고 있어야 한다. 우리에게 필요한 정보는 다음과 같다.

1. 그래프 노드의 정보
2. 각 노드 별 in-degree 값
3. 각 노드의 방향 엣지가 가리키는 노드들

위의 정보가 필요한 그래프를 구현하기에 적합한 그래프 표현 방식은 [인접 리스트](https://github.com/Seogeurim/Algorithm-practice/blob/master/notes/Graph/Graph.md#%EC%9D%B8%EC%A0%91-%EB%A6%AC%EC%8A%A4%ED%8A%B8-adjacent-list) 라고 할 수 있겠다. 

그래프의 정보는 다음과 같이 주어진다고 해보자.

- N : 노드의 개수 (노드는 1 ~ N)
- M : 엣지의 개수
- M개의 관계들 : 노드 A -> 노드 B

그리고 우리는 그래프, in-degree 값 이렇게 두 가지 데이터를 만들어낼 것이다.

- 그래프 만들기 : 인접 리스트 형식으로 각 노드 별 LinkedList를 생성한다.
- in-degree 배열 : 각 인덱스를 노드 값으로 두고, 노드 끼리의 관계 값을 받을 때마다 그 노드에 들어온 값을 올려준다.

아래의 예제 코드에서 편의를 위해 인덱스 0은 비워두었다.

```java
public class Main {

    static int N, M;
    static LinkedList<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }
        indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            indegree[to] ++;
        }

        System.out.println(Arrays.toString(graph));
        System.out.println(Arrays.toString(indegree));

        br.close();
    }
}

```

그러면 이런 식으로 값이 저장되는 것을 확인할 수 있다.

![image](https://user-images.githubusercontent.com/22045163/90595659-4ad0f980-e228-11ea-9df1-7ce1cd393caf.png)

### 위상정렬 구하기

자, 그래프가 생성되었으므로 이제 앞에서 정의한 로직을 구현할 차례이다. 다시 한 번 살펴보자.

```
반복 (노드가 모두 제거될 때까지) {
  1. in-degree가 0인 노드를 찾는다. (이 노드는 여러 개일 수 있다.)
  2. 그 노드를 제거한다.
  3. 그 노드의 즉각 후행자들의 in-degree를 1씩 감소한다.
}
```

위 로직을 코드로 구현하기 위해 다시 생각해보았을 때, 우선 in-degree가 0인 노드들을 저장할 공간이 필요하다는 것을 알 수 있다. 그 공간을 **zeros** 라고 칭해보겠다. 이 때 zeros는 어떤 자료구조를 사용하면 좋을까?

우리는 먼저 in-degree가 0인 노드들을 와르르 검사 하고 -> zeros에 차곡차곡 쌓은 다음 -> 맨 앞의 노드부터 꺼내와서 -> 각 노드가 가리키는 다음 노드들을 찾고 -> 그 노드들의 in-degree 값을 -1씩 업데이트 하고 -> 값이 0이 되었을 때는 또 그 아이들을 zeros에 넣고 ....

이 과정을 반복할 것이다. 즉 zeros는 노드 저장 후 처음에 들어갔던 것부터 제거하기 위해 **큐**를 사용하면 되겠다.

```java
Queue<Integer> zeros = new LinkedList<>();

for (int i = 1; i <= N; i++) {
    if (indegree[i] == 0) zeros.offer(i);
}

while (!zeros.isEmpty()) {
    int target = zeros.poll();
    System.out.print(target + " ");

    for (int node : graph[target]) {
        indegree[node] --;
        if (indegree[node] == 0) {
            zeros.offer(node);
        }
    }
}
System.out.println("");
```

## 관련 문제 풀어보기

[[baekjoon-2252] 줄 세우기](https://github.com/Seogeurim/Algorithm-practice/blob/master/src/Graph/P2252)

