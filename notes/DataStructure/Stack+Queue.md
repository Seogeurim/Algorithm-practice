# 스택(Stack)과 큐(Queue) 그리고 덱(Deque)

스택과 큐는 LIFO, FIFO 구조로 알려진 중요하고 매력적인 선형 자료구조이다. 
스택으로 큐를 구현할 수도, 큐로 스택을 구현할 수도 있다. 
또한 스택과 큐의 LIFO, FIFO 기능을 모두 활용할 수 있는 덱이라는 자료구조도 있다.

## Stack (스택) - LIFO

- 선형 자료구조
- 삽입, 삭제 연산이 한 방향에서 이루어진다.
- **LIFO(Last In First Out)** : 나중에 들어간 원소가 먼저 나오는 구조이다.

### Stack 용어

- `Top` : 스택에 데이터가 삽입될 위치

### Stack 활용

- 시스템 스택(System Stack) / 실행시간 스택(Runtime stack) : 프로그램의 함수 호출과 복귀에 따른 실행 순서 관리
- 인터럽트 루틴 처리
- 수식의 후위 표기법(Postfix Notation)
- 수식의 괄호식 검사
- 웹 브라우저 방문 기록 (뒤로가기)
- 실행 취소 (undo)

## Queue (큐) - FIFO

- 선형 자료구조
- 한 방향에서는 삽입 연산이, 반대 방향에서는 삭제 연산이 이루어진다.
- **FIFO(First In First Out)** : 먼저 들어간 원소가 먼저 나오는 구조이다.

### Queue 용어

- `Front` / `Head` : 큐에서 데이터가 삭제될 위치
- `Rear` / `Tail` : 큐에서 마지막 데이터가 삽입된 위치

### Queue 활용

- 프로세스 레디 큐
- 스케쥴링
- 네트워크 패킷 전송시 필요한 버퍼 대기 큐
- 캐시(Cache) 구현
- javascript의 Event Loop 관리 (비동기 처리)
- 너비 우선 탐색(BFS, Breadth-First Search)
- 프린터의 출력 처리

## Deque (덱)

- 선형 자료구조
- Double-ended Queue
- 양방향에서 삽입, 삭제 연산이 모두 이루어지는 큐를 말한다.
- Stack(LIFO), Queue(FIFO)처럼 활용이 가능하기 때문에 대신해서 사용할 수 있다.
