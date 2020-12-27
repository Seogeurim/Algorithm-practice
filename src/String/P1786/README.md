## [baekjoon-1786] 찾기

![image](https://user-images.githubusercontent.com/22045163/103164130-9df83000-484a-11eb-8bc5-fc126523863c.png)
![image](https://user-images.githubusercontent.com/22045163/103164138-ae100f80-484a-11eb-835a-ecff93761a4d.png)

### KMP 문자열 검색 알고리즘

> [KMP : 문자열 검색 알고리즘](https://bowbowbow.tistory.com/6)

위 링크에 매우 잘 설명되어 있다. 스스로 몇 번 더 구현해보면서 연습해야 할 것 같다.

### 시간 초과 이슈 - makePk 함수 

```java
static int[] makePk(String P) {
    int[] Pk = new int[P.length()];
    for (int i = 1; i < P.length(); i++) {
        int k = (i+1) / 2;
        while (k > 0 && !P.substring(0, k).equals(P.substring(i+1 - k, i+1)))
            k--;
        Pk[i] = k;
    }
    return Pk;
}
```

처음에는 이렇게 짰었다. `substring`을 통해 일일이 비교하는 것이다. 
짜면서도 시간 걱정을 많이 했었는데, 역시 시간 초과 이슈가 났다.
위 블로그를 참고해보니 이 함수도 kmp 알고리즘 원리를 이용해야 하는 것이었다.
그랬을 때 O(`P의 길이`)로 시간 복잡도를 줄일 수 있다.

### 메모리와 시간 줄이기

![image](https://user-images.githubusercontent.com/22045163/103164190-5aea8c80-484b-11eb-828e-d7f197f7ce0e.png)

처음에는 ArrayList에 결과를 저장하는 방식으로 구현하였다. 
하지만 그랬을 때 실행 시간과 메모리가 너무 많이 필요하다는 것을 확인하고 다른 코드들을 참고해보았다.
ArrayList 대신, StringBuilder에 값을 저장하여 그대로 출력하는 방식으로 구현하니
메모리와 시간을 크게 줄일 수 있었다.

ArrayList는 대량의 자료를 추가할 시 복사가 일어나게 되어 성능 저하를 일으킨다고 한다.

> Java.util.ArrayList 에서 add()나 ensureCapicity() 를 호출하였을 때  
> 만약 지금 할당된 영역이 작다면, `(현재크기*3/2+1)`만큼으로 새로 영역을 할당하고 전체 복사를 하게 됩니다.  
> Size가 커지면 Arrays.copyOf() 내부에서 복사할 부분이 커집니다.  
> 다르게 말하면 크기가 커지면 사이즈 증가에 부담이 된다는 말이지요.
>
> 출처 : [Java ArrayList, Vector, LinkedList 자료형 비교 (시간 복잡도 중심으로...) - 삶, 금융, IT, 잡동사니](https://pickykang.tistory.com/6)
