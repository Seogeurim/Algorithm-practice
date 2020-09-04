## [baekjoon-3190] 뱀

![image](https://user-images.githubusercontent.com/22045163/92230569-51c56080-eee6-11ea-9e66-2388b3e1dfcf.png)

### 내가 몰랐던 점 

1. Deque 자료구조

- 처음에 큐를 사용하려고 보니, 데이터를 뒤에서 빼야하는 경우가 필요해서 큐를 배제하고 head, tail을 만들어서 풀었다.
그런데 그 과정에서 tail 회전을 처리하면서 정확하지 않은, 알 수 없는 예외의 경우가 생겼고 **런타임 에러**, **틀렸습니다**의 결과를 볼 수 있었다.
- Deque(Double-ended queue) 자료구조는 양 끝에서만 자료를 넣고 양 끝에서 뺄 수 있는 자료구조로, queue의 확장판이다.  
    > 추후 note에 정리하겠다.
- Deque를 사용하면 훨씬 편하게 문제를 풀 수 있었다.

2. HashMap

- 처음에 괜히 클래스를 생성해서 time, direction 값을 저장했는데, 그럴 필요 없이 HashMap으로 저장하면 훨씬 간편했다.

