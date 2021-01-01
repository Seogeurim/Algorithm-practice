# Sort - QuickSort

## QuickSort란

QuickSort는 pivot을 설정하여 그 값을 기준으로 정렬한다. 
추가 메모리 공간을 최대한 활용하지 않은 것이 특징이다. 
재귀 함수를 활용하기에 엄밀하게 이야기하면 In-place sort 라고 할 수 없지만, 그에 가깝다고 할 수 있다.
Worst-case Time Complexity는 O(n^2)이지만, Worst-case가 매우 극단적인 경우임을 감안한다면 
Average-case Time Complexity를 계산하는 것이 훨씬 유의미할 것이고, 이는 O(nlgn)이다.
Merge sort와 같은 수준의 Time Complexity를 가지며 Space Complexity 측면에서도 좋은 성능을 가지니 
QuickSort는 참 좋은 알고리즘 !!

## pivot 선택 방법

QuickSort에서 pivot을 설정하는 방법은 다음과 같은 3가지가 있다.

1. 첫 번째 element(`low`)가 pivot이다.
2. `low`, `high` 값 중 무작위로 선택한 값이 pivot이다.
3. `low`, `high`, `mid` 값 중 중간값(median value)이 pivot이다. (Robert Sedgewick에 의해 제안됨)

3가지 방법 각각에 대하여 `QuickSort`, `QuickSort2`, `QuickSort3` class로 구현해보았다.
그리고 Comparison, Exchange 연산 횟수와 실행 시간을 비교해 본 결과 다음과 같은 그래프를 도출할 수 있었다.

<p float="left">
  <img src="https://user-images.githubusercontent.com/22045163/95844387-d5932800-0d83-11eb-9f90-cbe70f2f6e31.png" alt="comparison" width="33%" />
  <img src="https://user-images.githubusercontent.com/22045163/95844415-dcba3600-0d83-11eb-8372-04c6078a8b8e.png" alt="exchange" width="33%" />
  <img src="https://user-images.githubusercontent.com/22045163/95844441-e348ad80-0d83-11eb-92b7-3f3391413918.png" alt="time" width="33%" />
</p>

3번째 pivot 선택 방법이 가장 좋은 성능을 가짐을 알 수 있다. (Median of Three)
