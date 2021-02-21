## [baekjoon-15961] 회전 초밥

![image](https://user-images.githubusercontent.com/22045163/108622160-3b9e6300-747a-11eb-9432-c4f73acb043b.png)
![image](https://user-images.githubusercontent.com/22045163/108622169-46f18e80-747a-11eb-8860-d326c703788a.png)

### HashMap vs Array

처음에 선택한 초밥에 대한 정보를 HashMap에 저장해가면서 풀었는데, 이보다 `d`의 크기만큼 Array를 선언하여 
구현하는 것이 메모리/시간복잡도 측면에서 훨씬 좋다.

![image](https://user-images.githubusercontent.com/22045163/108622175-5375e700-747a-11eb-95b0-a28e53317d05.png)
