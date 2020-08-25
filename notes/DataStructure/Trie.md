# 트리(Tree)의 응용 - 트라이(Trie)

트라이(Trie)는 **문자열을 빠르게 검색할 수 있는 자료 구조**로, **단어 사전**과 같은 개념이라고 기억해두면 좋을 것 같다.  
특정 단어를 찾고 싶은데 그 검색 시간이 빨랐으면 할 때, 우리는 트라이(Trie) 구조를 떠올려보자.

> 검색어 자동 완성, 사전에서 찾기, 문자열 검사 등에서 사용할 수 있다.

## 트라이(Trie)

> Prefix Tree, Digital Search Tree, Retrieval Tree 라고도 부른다.

- 문자열을 저장하고 효율적으로 탐색하기 위한 트리 형태의 자료구조
- K진 트리 구조
- 단어 사전을 트라이로 생성, 그 후 찾을 단어를 트라이를 사용해 검색
- 트라이의 root 노드는 항상 빈 문자열

![Trie](https://user-images.githubusercontent.com/22045163/91132291-1c4f9480-e6e8-11ea-831b-e063f1a145e0.jpg)

위 그림을 살펴보면, 트리의 깊이에 따라 단어를 1글자, 2글자, 3글자씩 저장한 것을 볼 수 있다. (root 노드는 빈 문자열)

- 'tea' 찾기 : 트리를 따라 가서 t, e, a 를 찾는다.
- 'tee' 찾기 : 트리를 따라 갔을 때 t, e 다음 e가 없기 때문에 없는 글자이다.
- 'te' 찾기 : t, e까지는 있지만 e가 단어의 끝이 아니므로 없는 글자이다. (즉 트라이에는 단어의 끝을 알리는 flag가 필요하다.)

### 시간 복잡도

제일 긴 단어의 길이를 M, 총 단어들의 수를 N이라고 할 때, 

- 트라이 생성 시 시간 복잡도 : O(N \*M)
단어 하나를 삽입하는데 가장 긴 단어의 길이 M 만큼 걸리므로 O(M)이고, 이를 N개 넣으므로 O(N*M)이다.
- 단어 검색 시 시간 복잡도 : O(M)
가장 긴 문자열의 길이만큼 걸리므로 O(M)이다.

> 단어를 하나씩 비교하며 탐색하는 것보다 시간적으로 훨씬 효율적이지만,  
> 각 노드에서 그 자식 노드에 대한 정보를 배열로 가지고 있고, 그 노드들의 개수를 생각해봤을 때 **공간 복잡도 측면에서는 비효율적**이다.

## 트라이 구현하기

### 트라이 노드 설계

트라이 노드에 필요한 정보는 **자식 노드에 대한 정보** `children`, **현재 노드가 단어의 끝인지 여부** `isEnd` 이 두 가지이다.  
예제 코드는 알파벳 대문자만 저장하는 트라이라고 생각하고 구현해보겠다.  
구현의 편의를 위해 getChild, hasChild 메서드도 추가해준다.

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // 알파벳 대문자만
    boolean isEnd;

    TrieNode getChild(char c) {
        return children[c - 'A'];
    }

    boolean hasChild(char c) {
        return children[c - 'A'] != null;
    }
}
```

### 트라이 생성하기 (단어 사전 만들기)

단어 사전의 단어를 트라이에 하나씩 삽입한다고 생각해보자.

1. 루트 노드부터 시작하여 단어의 첫 글자부터 트라이를 탐색한다.
2. 현재 노드의 자식 노드 중 현재 탐색 중인 문자가 **있다면**, 그 자식 노드로 이동한다.
3. 현재 노드의 자식 노드 중 현재 탐색 중인 문자가 **없다면**, 새로운 자식 노드를 추가한다.
4. 단어의 마지막 글자까지 왔다면, isEnd를 true로 해주면 단어에 대한 정보가 트라이에 저장된다.

### 트라이를 이용하여 검색하기

1. 루트 노드부터 시작하여 단어의 첫 글자부터 트라이를 탐색한다.
2. 현재 노드의 자식 노드 중 현재 탐색 중인 문자가 **있다면**, 그 자식 노드로 이동한다.
3. 현재 노드의 자식 노드 중 현재 탐색 중인 문자가 **없다면**, `return false`
4. 단어의 마지막 글자까지 왔는데, isEnd가 false라면 `return false`
5. 단어의 마지막 글자까지 왔고, isEnd가 true라면 `return true`

트라이 생성, 검색에 관한 Trie 클래스를 구현해보면 다음과 같다.

```java
class Trie {
    TrieNode root = new TrieNode(); // 루트 노드 생성

    void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) { // 단어의 첫 글자 ~ 끝 글자까지 탐색
            char c = word.charAt(i);
            if (!current.hasChild(c)) { // 해당 문자에 대한 자식 노드 있는지 검색 후 그 자식 노드로 이동
                current.children[c - 'A'] = new TrieNode();
            }
            current = current.getChild(c);
        }
        current.isEnd = true; // 끝 글자임을 알리는 플래그 적용
    }

    boolean checkWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) { // 단어의 첫 글자 ~ 끝 글자까지 탐색
            char c = word.charAt(i);
            if (current.hasChild(c)) { // 해당 문자에 대한 자식 노드 있다면 그 자식 노드로 이동
                current = current.getChild(c);
            } else { // 해당 문자에 대한 자식 노드 없으면 return false
                return false;
            }
        }
        return current.isEnd; // 끝까지 왔는데 isEnd라면 true, 아니면 false
    }
}
```

예제 코드 바로 가기 ▶️ [TrieTest.java](https://github.com/Seogeurim/Algorithm-practice/blob/master/src/Trie/TrieTest.java)

## 관련 문제 풀어보기

[Baekjoon-9202 Boggle](https://github.com/Seogeurim/Algorithm-practice/tree/master/src/Trie/P9202)
[가사 검색](https://github.com/Seogeurim/Algorithm-practice/blob/master/src/_2020_KAKAO_BLIND_RECRUITMENT/P4)