## [SW Expert Academy - 1263] 사람 네트워크2

![image](https://user-images.githubusercontent.com/22045163/112565702-e363d380-8e20-11eb-9c73-2f08cc88f792.png)
![image](https://user-images.githubusercontent.com/22045163/112565716-ee1e6880-8e20-11eb-8b7b-ac2beeda5599.png)
![image](https://user-images.githubusercontent.com/22045163/112565741-f9719400-8e20-11eb-9518-9c08337511ce.png)

### 플로이드 워셜에서 `if (i == j) continue` ??

```java
for (int k = 0; k < N; k++) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            // if (i == j || i == k) continue;
            D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
        }
    }
}
```

조건 처리의 로직 때문인지 위의 `if (i == j || i == k) continue;` 문을 넣고 안 넣고의 시간 차이가 너무 많이 난다. 사실 생각해보면 필요 없는 로직이긴 한데... 그래도 항상 넣고 싶다는 생각이었어.... 

- static 변수, 조건문 다 뺐을 때
  ![image](https://user-images.githubusercontent.com/22045163/112565280-207b9600-8e20-11eb-9b8b-49d97230fd16.png)
- (포기할 수 없는) (코드 예쁜게 좋아) 첫번째 내 코드
  ![image](https://user-images.githubusercontent.com/22045163/112565585-a7c90980-8e20-11eb-9e08-e767486db4fa.png)
