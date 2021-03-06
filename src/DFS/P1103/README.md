## [baekjoon-1103] 게임

DP는 정말 연습을 많이 해봐야겠다. 풀면서 정말 너무 헷갈렸다.  
\* DP를 적용할 수 있는 경우 : 어떤 함수에서 입력값이 같으면 항상 결과값도 같아야 한다.

이 문제에서 DP 배열에 넣는 값 : 만일 더 이상 움직일 수 없는 좌표에 도달했을 때, 
그 좌표로 가기 직전의 DP 배열 좌표에 +1을 해준다. 즉, DP 배열에 담긴 값은 **그 지점에서
출발했을 때 동전이 움직일 수 있는 횟수**를 뜻한다. 그런데 동전이 상하좌우로 움직이는 경우의 수가
있기 때문에, 그 경우마다 그 횟수가 다를 것이다. 그래서 max 값을 도출하여 넣어줘야 한다.

> DP\[2\]\[2\] = 3일 경우, 동전이 (2,2) 지점에서 출발했을 때 움직일 수 있는 최대 횟수는 총 3번이다.

![image](https://user-images.githubusercontent.com/22045163/91932838-4cb7b400-ed22-11ea-83e0-e78db237be70.png)

힘든 싸움이었다....

![image](https://user-images.githubusercontent.com/22045163/91932868-6527ce80-ed22-11ea-8f5f-be405d2d2ac1.png)
