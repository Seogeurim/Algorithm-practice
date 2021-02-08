## [baekjoon-11931] 수 정렬하기 4

![image](https://user-images.githubusercontent.com/22045163/107252564-d2c9ea80-6a78-11eb-9e38-d339bbe5d6c8.png)

처음에 퀵소트로 풀어보려 했는데, 시간 제한과 숫자 범위를 생각했을 때 퀵소트의 Worst Case 시간복잡도가 O(N^2)이기 때문에 
옳지 않다. 그래서 내림차순으로 merge sort를 구현해 풀었다.

![image](https://user-images.githubusercontent.com/22045163/107252610-df4e4300-6a78-11eb-88ae-2bf7d5d720fa.png)
