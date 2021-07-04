## [baekjoon-9252] LCS 2

![image](https://user-images.githubusercontent.com/22045163/124378582-1f92b400-dced-11eb-8802-3b34791be2d0.png)

### LCS 구하기

> 참고 : [[알고리즘/자바] 백준 9252번 - LCS 2](https://soojong.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-9252%EB%B2%88-LCS-2)

#### dp 2차원 배열 채우기

해당 인덱스의 문자끼리 비교했을 때

- 같으면 배열의 왼쪽 위 대각선의 값 + 1
- 다르면 배열의 왼쪽, 윗쪽 값 중 큰 값 선택

#### 부분 문자열 구하기

배열의 가장 마지막 인덱스부터 시작하여 0까지 반복

해당 인덱스의 문자끼리 비교했을 때

- 같으면 문자를 기록, 왼쪽 위 대각선 인덱스로 이동
- 다르면 배열의 왼쪽, 윗쪽 값 중 큰 값의 인덱스로 이동

![image](https://user-images.githubusercontent.com/22045163/124378594-30dbc080-dced-11eb-9f4f-6a13399f8b61.png)
