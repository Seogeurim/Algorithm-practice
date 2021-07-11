## [baekjoon-1062] 가르침

![image](https://user-images.githubusercontent.com/22045163/125199919-67907880-e2a3-11eb-86fc-710fee3f65c5.png)

### 비트연산자 AND 와 OR 의 차이? [Main2.java](./Main2.java)

이 문제를 풀면서 여러가지 풀이법을 시도해보았다. 마지막에는 비트연산자 풀이법을 시도하였는데, 그러던 중 특이한 점을 발견하게 되었다.

`bit`에 있는 알파벳을 만족하는 단어를 카운트하는 코드에서

- 이 풀이는 388ms
    ```java
    int cnt = 0;
    for (int w : words) cnt += (bit & w) == w ? 1 : 0;
    ```
- 이 풀이는 176ms
    ```java
    int cnt = 0;
    for (int w : words) cnt += (bit | w) == bit ? 1 : 0;
    ```
  
무슨 차이일까? 검색해봐도 잘 안 나오긴 하던데, 내 생각에는 TRUE 판정 시 OR은 두 비트 중 하나만 TRUE여도 되고 AND는 둘 다 TRUE여야 하는 것에서 오는 차이가 아닐까 싶다. 앞으로 OR이 사용 가능한 부분에서는 OR을 쓰는 것이 더 좋을 것 같다는 생각이다.

![image](https://user-images.githubusercontent.com/22045163/125199930-71b27700-e2a3-11eb-902a-1fb15c692efa.png)
