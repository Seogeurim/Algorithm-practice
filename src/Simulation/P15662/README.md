## [baekjoon-15662] 톱니바퀴 (2)

![image](https://user-images.githubusercontent.com/22045163/103664215-5c3b5800-4fb5-11eb-94cd-6a50a3afc93c.png)

> [톱니바퀴](../P14891) 문제와 동일한 설명이라 중략

![image](https://user-images.githubusercontent.com/22045163/103664269-6e1cfb00-4fb5-11eb-81cd-fbdb69c8707a.png)

### 메모리 & 시간 줄이기

나는 처음에 회전 시킬 톱니바퀴에 대한 정보를 `T` 크기를 가지는 `dirs`라는 배열에 담고 
`dirs` 배열을 한 번 더 돌며 회전시켰다. 이 때 회전 정보가 0이면 회전하지 않게 된다.

하지만 `T`의 최대 크기가 `1000`임을 감안했을 때 이러한 연산은 매우 낭비이다. 그래서
`dirs` 배열을 없애고 Direction 클래스와 Queue를 선언하여 회전해야 할 톱니바퀴의 정보만 담도록 하였다. 
또한 처음에는 Direction 클래스에 `rotate()` 함수를 넣어보았는데, 이 경우보다
Main 클래스의 함수로 빼서 돌리는 것이 메모리, 시간 측면에서 미세하게 성능이 더 좋았다. 

이렇게 무심코 작성한 코드가 필요 없는 연산을 수행할 수 있으니 늘 생각하도록 하자.

![image](https://user-images.githubusercontent.com/22045163/103664421-9d336c80-4fb5-11eb-99ba-86d6526c9f03.png)
