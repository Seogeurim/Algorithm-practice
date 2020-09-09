## [2019 KAKAO BLIND RECRUITMENT - 3] 후보키

### 비트마스크로 부분 집합을 구할 수 있다

```java
for (int i = 1; i < (1 << cols); i++) {
    System.out.println(i);
}
```

### 중복 검사하기

처음에는 isUnique 함수를 만들어서 검사하였다.

```java
static boolean isUnique(LinkedList<String>[] list) {
    for (int i = 0; i < list.length - 1; i++) {
        for (int j = i+1; j < list.length; j++) {
            if (list[i].equals(list[j])) {
                return false;
            }
        }
    }

    return true;
}
```

하지만 이보다도 HashSet 자료구조를 활용하면 훨씬 빠른 속도와 간결한 코드로 중복 검사를 수행할 수 있다.

HashSet은 Set 인터페이스를 구현한 가장 대표적인 컬렉션이며, Set 인터페이스의 특징대로 HashSet은 중복된 요소를 저장하지 않는다. 만일 HashSet에 이미 저장되어 있는 요소와 중복된 요소를 추가하고자 한다면 이 메서드들은 false를 반환함으로써 중복된 요소이기 때문에 추가에 실패했다는 것을 알린다. 따라서 HashSet에 string 형태로 선택한 요소를 저장하고, 마지막에 그 set의 크기가 전체 튜플들의 크기와 맞지 않다면 중복된 요소가 있었음을 알 수 있다.

```java
for (int i = 1; i < (1 << cols); i++) {
    Set<String> set = new HashSet<>();

    for (String[] row : relation) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < cols; k++) {
            if ((i & (1 << k)) > 0)
                sb.append(row[k]);
        }
        set.add(sb.toString());
    }

    if (set.size() == rows) {
        boolean isExist = false;
        for (Integer c : cand) {
            if ((c & i) == c) {
                isExist = true;
                break;
            }
        }
        if (!isExist) cand.add(i);
    }
}
```

![image](https://user-images.githubusercontent.com/22045163/92583929-fe7c5500-f2cd-11ea-997b-4e4eeac94028.png)
