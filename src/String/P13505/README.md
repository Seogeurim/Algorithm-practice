## [baekjoon-13505] 두 수 XOR

![image](https://user-images.githubusercontent.com/22045163/103462635-f1e2a780-4d69-11eb-81dc-046de3907843.png)

### 풀이 과정

XOR 연산은 0과 1, 1과 0처럼 두 수가 다를 때 1을 반환한다. 이러한 특성을 생각해봤을 때 
주어진 수에 대해 XOR한 값이 최대가 되려면 각 자리의 수가 서로 최대한 달라야 한다.
이를 효율적으로 해결하기 위해서는 트라이를 이용할 수 있다. 각 수를 이진수로 바꿔 트라이에 넣고, 
XOR한 값이 최대가 될 수 있는 수를 찾아나가는 것이다.

이진수와 XOR연산 문제인데, 트라이를 써서 풀 수 있는 신기하고 재밌는 문제였다 !!

![image](https://user-images.githubusercontent.com/22045163/103462660-163e8400-4d6a-11eb-8ca6-54962c87ca0b.png)
