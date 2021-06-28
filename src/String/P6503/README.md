## [baekjoon-6503] 망가진 키보드

![image](https://user-images.githubusercontent.com/22045163/123613388-5759b180-d83e-11eb-89c4-c8a6bf347333.png)

### 풀이 과정

서로 다른 문자의 개수를 구하는 과정에서 처음에 해시맵을 사용했는데, 실행 시간이 너무 높게 나와서 알고 보니 `m` 범위를 `128`까지 준 이유가 있었다. 아스키코드가 `0~127` 범위라는 것. 그래서 `128` 사이즈의 배열을 선언해서 카운트하는 식으로 바꿔줬더니 실행 시간이 개선되었다.

![image](https://user-images.githubusercontent.com/22045163/123613441-62144680-d83e-11eb-8aeb-a4bef1fa2191.png)
