## 서로소 집합 (Disjoint Set, Union-Find)

- **서로소 집합 (Disjoint Set)** : 교집합이 없는, 즉 공통되는 원소가 없는 집합을 말한다. 
- **Union-Find** : 서로소 집합을 표현할 때 사용하는 알고리즘이다.
  서로소 집합의 정보를 확인(Find)하고 조작(Union)한다.

### Union-Find 연산

#### Union 연산

- 두 원소 a, b에 대해서 union(a, b)는 각 원소가 속한 집합을 하나로 합친다.
- <img src="https://render.githubusercontent.com/render/math?math=a \in A, b \in B"> 일 때, union(a, b)는 <img src="https://render.githubusercontent.com/render/math?math=A \cup B"> 이다.

#### Find 연산

- 어떤 원소 a에 대해서 find(a)는 a가 속한 집합의 대표 번호(루트 노드)를 반환한다.
- <img src="https://render.githubusercontent.com/render/math?math=a \in A"> 에 대해서, find(a)는 집합 A의 대표 번호(루트 노드) 이다.

### 서로소 집합의 표현

![스캔한 페이지 (2)-4](https://user-images.githubusercontent.com/22045163/90507278-9df76d80-e190-11ea-8b20-58feb465dee9.jpg)

### 서로소 집합의 구현

### 초기화 _initialize

parent 배열에 i 원소의 부모 노드 번호를 저장한다. 
i 원소가 루트 노드라면, 자기 자신의 번호를 저장한다.

```
function initialize()
  for i : 1 ~ N
    parent[i] = i
```

### Union _union(a, b)

a의 루트 노드가 b의 루트 노드를 부모로 삼게끔 한다.

```
function union(a, b)
  aRoot = find(a)
  bRoot = find(b)
  parent[aRoot] = bRoot
```

### Find _find(a)

a 원소의 루트 노드 번호를 반환한다.

```
function find(a)
  if (parent[a] == a) return a
  else return find(parent(a))
```

이 때, parent 가 N개일 경우 일렬로 쭉 따라가게 되기 때문에 O(N) 의 시간 복잡도가 나온다.

따라서 a 원소의 루트 노드를 찾을 때마다 그 부모 노드를 루트 노드 값으로 치환해주면 훨씬 효율적이다. O(logN)

```
function find(a)
  if (parent[a] == a) return a
  else return parent[a] = find(parent[a])
```

![스캔한 페이지 (2)-5](https://user-images.githubusercontent.com/22045163/90507891-9f756580-e191-11ea-9dd2-df5bc7147f4a.jpg)

## 관련 문제 풀어보기

- [[baekjoon-1717] 집합의 표현](https://github.com/Seogeurim/Algorithm-practice/blob/master/src/Graph/P1717)