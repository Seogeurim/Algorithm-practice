## [baekjoon-2615] 오목

![image](https://user-images.githubusercontent.com/22045163/117129244-693c4c80-add9-11eb-8ad9-21daac7099d1.png)
![image](https://user-images.githubusercontent.com/22045163/117129282-748f7800-add9-11eb-8387-a1d274a991a2.png)

### 세심하게 풀어야 한다

이 문제는 주의할 점이 많다 ! 이런 문제는 세심하게, 정확하게 ㅠㅠㅠ 풀자 ㅠㅠ !!

- 바둑판을 순차적으로 순회하며 이미 6개라고 세고 지나온 후, 다시 세면 5개일 수 있다. 그러면 바로 버그 ~
- 만일 ↙ 이 방향으로 오목이라면 제일 왼쪽 인덱스를 계산해서 출력해줘야 한다.

![image](https://user-images.githubusercontent.com/22045163/117129369-8d982900-add9-11eb-9435-80b3bb13137c.png)
