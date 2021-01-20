## [programmers - 정렬] 가장 큰 수

![image](https://user-images.githubusercontent.com/22045163/105149923-704f8f80-5b47-11eb-8118-4c802877bd0f.png)

### Arrays.sort - Comparator

Arrays 클래스의 **`sort​(T[] a, Comparator<? super T> c)`** 메서드를 이용하면 
**Interface Comparator**를 통해 기본 정렬 기준과 다르게 정렬할 수 있다.

이 때 compare 메서드를 오버라이드하여 작성하면 된다. compare 메서드의 return 값이 음수 또는 0이면 
객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 변경된다.

```java
Arrays.sort(result, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        // code 
    }
});
```

### 문제 풀이

String 클래스에서는 문자열 간 크기를  비교해주는 `compareTo` 메서드가 있다. 
**A.compareTo(B)** 일 때, `A - B` 순서로 해당 문자의 아스키 코드 값을 뺀 결과를 int형으로 리턴한다. 
따라서 다음과 같은 결과를 볼 수 있다.

- A < B : return 음수
- A == B : return 0
- A > B : return 양수

이 문제에서는 숫자들을 붙여 더 큰 숫자를 만들어내야 한다. 
숫자들을 각각 String형으로 변환하여 각 문자열들을 붙였을 때의 결과를 비교하고, 내림차순으로 정렬하면 
문제를 해결할 수 있다. 그럼 `((o2 + o1).compareTo(o1 + o2))` 이라는 식이 완성된다.

코드는 다음과 같다.

```java
Arrays.sort(result, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return ((o2 + o1).compareTo(o1 + o2));
    }
});
```

이는 람다식으로 훨씬 간단하게 표현할 수 있다.

```java
Arrays.sort(str, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));
```
