## [baekjoon-1863] 스카이라인 쉬운거

![image](https://user-images.githubusercontent.com/22045163/121661846-9a4a2400-cadf-11eb-8763-086ecd9977af.png)

### 풀이 과정

1. 스택의 위에 있는 값보다 작은 값이 들어왔을 때는 더 높은 값들을 다 빼줘야 한다. 그리고 그 때마다 건물 한 개씩을 카운트한다.
   ![IMG_0AA5FBB55DE4-1](https://user-images.githubusercontent.com/22045163/121663109-09744800-cae1-11eb-9f3d-2b724405aeac.jpeg)
2. 높이가 0인 경우는 계산하지 않아도 되므로 스택에 넣지 않는다.
3. 스택이 비었거나 스택의 위에 있는 값보다 더 큰 값이 들어오면 스택에 넣는다.
4. 마지막으로 계산한 카운트와 스택에 남아 있는 값들의 개수를 더하면 총 최소 건물 수를 구할 수 있다.

![image](https://user-images.githubusercontent.com/22045163/121661894-a6ce7c80-cadf-11eb-8b09-49b8bb8d787f.png)
