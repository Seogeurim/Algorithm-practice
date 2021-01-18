## [baekjoon-11505] 구간 곱 구하기

![image](https://user-images.githubusercontent.com/22045163/104891386-35692280-59b4-11eb-9b28-6eb762238f62.png)

### MOD

MOD 연산 때문에 많은 시행착오가 있었다. 값을 저장할 때에는 MOD 연산 후 저장하지 않고, 
곱한 값을 구하거나 저장할 때에만 MOD 연산을 해주니 올바른 해답이 나왔다.

### makeTree vs update

MOD 연산 관련하여 여러 자료들을 찾아보다가 맨 처음에 받은 수열을 한 번에 tree에 저장하는 makeTree 메서드를 
선언하지 않고 update 메서드로 대체하는 코드를 보게 되었다. 
그렇게 코드를 작성하면 시간 효율이 떨어지지 않을까, 생각했는데 역시나였다.
하나의 수에 대하여 update를 일일이 하는 것보다, arr를 받아서 한 번에 넣는 것이 더 효율적이다. 
왜인지는 코드를 보면 유추할 수 있다.

![image](https://user-images.githubusercontent.com/22045163/104891915-dfe14580-59b4-11eb-9705-d10dd475bcd1.png)

_밑의 744ms가 makeTree 대신 update 메서드를 쓴 결과이다._