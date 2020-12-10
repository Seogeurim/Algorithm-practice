## [Codility - Lesson 2 Arrays] OddOccurrencesInArray

![image](https://user-images.githubusercontent.com/22045163/101767118-224a7380-3b27-11eb-9a99-4f33c176d075.png)

### 다른 풀이 - XOR

다른 풀이를 보니 XOR 연산을 통해 풀 수 있는 문제이기도 하다.

> XOR 연산은 입력값이 같지 않으면 1을 반환한다.
> 
> - 0 XOR 0 = 0
> - 0 XOR 1 = 1
> - 1 XOR 0 = 1
> - 1 XOR 1 = 0

따라서 다음과 같이 생각해 볼 수 있다.

- `A == B` : A ^ B = 0
- `A == B != C` : A ^ B ^ C = C

이를 코드로 옮기면 다음과 같다.

```java
int ans = A[0];
for (int i = 1; i < A.length; i++) {
    ans = ans ^ A[i];
}
```
