# 그래프 (Graph)

> 💡 그래프 관련 **용어**와 **개념** 꼭 이해하고 기억하기 !!

## 그래프 정의

현실세계의 사물이나 개념 간의 **연결 관계**를 수학적 모델로 단순화하여 표현한 것

- <img src="https://render.githubusercontent.com/render/math?math=V = \{ v_{1}, v_{2}, v_{3}, ... , v_{n} \}"> : 정점 (Vertex / Node)
- <img src="https://render.githubusercontent.com/render/math?math=E = \{ (v_{i}, v_{j}) / v_{i} \in V, v_{j} \in V \}"> : 간선 (Edge / Link / Arc) _ 정점 간의 연결 관계를 나타낸다.
- 그래프 G = (V, E)

## 그래프 용어

>  별도로 표시된 것은 내가 기억하기 쉬울 것 같은 이름이다.

1. 정점 (Node) **`노드`**
2. 간선 (Edge) **`엣지`**
   1. 무향 간선 (Undirected Edge) **`무방향 엣지`** : 방향이 존재하지 않는 엣지, 양방향이라고 할 수 있다.
   2. 유향 간선 (Directed Edge) **`방향 엣지`** : 방향이 존재하는 엣지
3. 인접 (Adjacent) **`인접`** : (노드 관점) 두 노드 A, B 사이에 엣지가 존재한다면 A, B는 인접한다.
4. 부속 (Incident) **`부속`** : (엣지 관점) 두 노드 A, B 사이에 엣지 e가 존재한다면 엣지 e는 노드 A, B에 부속한다.
5. 차수 (Degree) **`차수`** : 한 노드에 연결된 엣지의 수
   1. (방향 그래프) in-degree : 노드에 들어오는 엣지의 수
   2. (방향 그래프) out-degree : 노드에서 나가는 엣지의 수
6. 자기 간선과 다중 간선
   1. 자기 간선 (Self-loop) : 노드 하나를 놓고 볼 때, 자신으로 다시 돌아오는 엣지
   2. 다중 간선 (Multiple / Parallel edges) : 두 개 이상의 엣지가 똑같은 두 노드에 부속할 때
7. 경로 (Path) **`경로`** : 노드 + 엣지가 교대로 구성된 sequence 
   1. 단순 경로 (Simple Path) : 같은 노드를 두 번 이상 가지 않는 경로, sequence에서 노드와 엣지가 중복되지 x
8. 회로 (Cycle) **`싸이클`** : A 노드에서 출발했을 때 다시 A 노드로 돌아오는 경로
   1. 단순 회로 (Simple Cycle) : 같은 노드를 두 번 이상 가지 않는 싸이클, sequence에서 노드와 엣지가 중복되지 x
9. 연결됨 (Connected) **`연결`** : 노드 A에서 노드 B로의 경로가 존재할 때, A와 B는 연결되어 있다.

## 그래프 종류

> 별도로 표시된 것은 내가 기억하기 쉬울 것 같은 이름이다.

1. 무향 그래프 (Undirected Graph) **`무방향 그래프`** : 무방향 엣지로 이루어진 그래프
2. 유향 그래프 (Directed Graph) **`방향 그래프`** : 방향 엣지로 이루어진 그래프
3. **가중치 그래프** (Weighted Graph) : 가중치(비용)를 갖는 엣지들로 이루어진 그래프
4. **정규 그래프** (Regular Graph) : 모든 노드가 동일한 차수를 가지는 그래프
5. **완전 그래프** (Complete Graph) : 모든 노드가 서로 인접해있는 그래프, 완전 그래프는 정규 그래프
   1. N개의 노드를 가지는 무방향 그래프일 때, 엣지의 개수 : 1부터 N까지 더한 값, $$\frac{1}{2}N(N-1)$$
   2. N개의 노드를 가지는 방향 그래프일 때, 엣지의 개수 : 무방향 그래프의 경우에 x2한 값, $$N(N-1)$$
6. **연결 그래프** (Connected Graph) : 모든 노드가 연결되어 있어서, 모든 노드끼리 경로가 존재하는 그래프
7. **부분 그래프** : 어떤 그래프의 부분 부분
8. **트리 그래프** : 싸이클을 가지지 않는 연결 그래프, 모든 노드에 대해서 경로가 정확히 1개 존재한다.

## 그래프 표현

**간선 리스트, 인접 행렬, 인접 리스트** 이렇게 3가지 방식이 있다.

노드 개수 : V개, 엣지 개수 : E개

### 간선 리스트 (Edge List)

- E x 2 (or E x 3) 이차원 배열 A에 정보를 저장한다.
- 두 노드 x, y 를 연결하는 엣지 e에 대해서 A\[k\]\[0\] = x, A\[k\]\[1\] = y
- 가중치 그래프의 경우 A\[k\]\[2\] 에 가중치 정보를 저장한다.

![간선리스트](https://user-images.githubusercontent.com/22045163/90503578-a056c900-e18a-11ea-9cd1-dde4bcc8ce0f.jpg)


 ### 인접 행렬 (Adjacency Matrix)

- V x V 이차원 배열 A에 정보를 저장한다.
- <img src="https://render.githubusercontent.com/render/math?math=v_{i}, v_{j}"> 를 연결하는 엣지가 존재한다면(인접한다면) A\[i\]\[j\] = 1, 존재하지 않는다면 A\[i\]\[j\] = 0
- 가중치 그래프의 경우 엣지가 존재할 때 1 대신 가중치 정보를 저장한다.

> 메모리 복잡도가 <img src="https://render.githubusercontent.com/render/math?math=V^2"> 이기 때문에, V의 값이 클 경우 쓰지 않는 것이 좋다.
> 100 이하의 값일 때 사용하는 것이 좋다.

![인접행렬](https://user-images.githubusercontent.com/22045163/90503584-a351b980-e18a-11ea-9157-f09633b7ebb6.jpg)

### 인접 리스트 (Adjacent List)

- V 개의 Linked List로 그래프 정보를 저장한다.
- 가중치 그래프의 경우 (노드 정보, 가중치 정보)를 함께 저장한다.
  > C++로 푼다면 pair, Java로 푼다면 class를 사용한다.

![인접리스트](https://user-images.githubusercontent.com/22045163/90503607-af3d7b80-e18a-11ea-9574-4841f4af0653.jpg)

### 그래프 표현 방식 비교

노드 개수 : V개, 엣지 개수 : E개

|                                    | 간선 리스트 | 인접 행렬 |                인접 리스트                |
| :--------------------------------: | :---------: | :-------: | :---------------------------------------: |
|                공간                |      E      |  <img src="https://render.githubusercontent.com/render/math?math=V^2">  |                   V + E                   |
|    노드 <img src="https://render.githubusercontent.com/render/math?math=v_{a}"> 의 부속 간선     |      E      |     V     |             <img src="https://render.githubusercontent.com/render/math?math=v_{a}"> 의 차수             |
| 노드 <img src="https://render.githubusercontent.com/render/math?math=v_{a}, v_{b}"> 의 인접 여부 |      E      |     1     | min(<img src="https://render.githubusercontent.com/render/math?math=v_{a}"> 의 차수, <img src="https://render.githubusercontent.com/render/math?math=v_{b}"> 의 차수) |
|             노드 삽입              |      1      |  <img src="https://render.githubusercontent.com/render/math?math=V^2">  |                     1                     |
|             엣지 삽입              |      1      |     1     |                     1                     |



