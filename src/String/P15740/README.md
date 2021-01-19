## [baekjoon-15740] A+B - 9

![image](https://user-images.githubusercontent.com/22045163/105036656-219aea80-5aa0-11eb-8cb0-f31e36960415.png)

### 문자열 풀이로 구현한 덧셈, 뺄셈

좀 특이한 문제였다. 
해당 문제는 입력 숫자의 길이가 매우 크기 때문에 그냥 `+` operator를 사용해 돌리면 
`Integer.parseInt` 메서드를 쓸 때 **java.lang.NumberFormatException**이 발생한다. 
따라서 문자열을 사용해 풀었고, 그 때문에 문자열 문제로 분류해보았다.

![image](https://user-images.githubusercontent.com/22045163/105037027-b4d42000-5aa0-11eb-9d43-3fd3cf0265ed.png)

### BigInteger

허무하게도 다른 풀이를 찾아봤을 때, java.math.BigInteger 클래스를 사용하면 간단하게 풀 수 있었다. ㅠㅠ 
그래도 시간은 내 풀이가 진짜 빠르다 !!! ㅠㅠ

```java
import java.math.BigInteger;

// ...

BigInteger a = new BigInteger(st.nextToken());
BigInteger b = new BigInteger(st.nextToken());
System.out.println(a.add(b));
```
