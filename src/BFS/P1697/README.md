## [baekjoon-1697] 숨바꼭질

![image](https://user-images.githubusercontent.com/22045163/96842537-2099f300-1488-11eb-8984-a9dfdeed1610.png)

### 메모리 초과 이슈

처음에 `visited` 배열을 두지 않고 풀었을 때 메모리 초과가 났다.

`visited` 배열을 두지 않으면, 이미 갔던 좌표에 대해서도 계속 큐에 넣게 되기 때문에 메모리 초과 이슈가 발생할 수 있다. 기억해두기 !!

