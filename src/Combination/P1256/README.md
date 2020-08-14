
🚩 다음 코드 간결화 시키기 (계산한 숫자가 10억이 넘어가면 10억으로 치환해주는 코드)
10억 : `1e9`로 표현할 수 있다.

```java
long result = combis[i-1][j-1] + combis[i-1][j];
if (result > MAX)
    combis[i][j] = MAX;
else
    combis[i][j] = (int) result;
```

```java
combis[i][j] = Math.min(combis[i-1][j-1] + combis[i-1][j], (int) 1e9);
```
