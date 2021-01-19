## [baekjoon-13537] 수열과 쿼리 1

![image](https://user-images.githubusercontent.com/22045163/105052449-3df45280-5ab3-11eb-9ea6-fa3195722721.png)

### 시간 초과 이슈

처음에 각 배열을 ArrayList로 저장하도록 풀었다. 그랬을 때 시간 초과 이슈를 볼 수 있었다.
문제를 찾던 중 start와 end 값을 이용하면 배열을 선언할 수 있다는 것을 깨닫고 고쳐서 풀었더니 
시간 초과 문제를 해결할 수 있었다.

![image](https://user-images.githubusercontent.com/22045163/105052491-4b114180-5ab3-11eb-9498-e51d5638a17d.png)

### Reference

- [머지 소트 트리 (Merge Sort Tree)](https://yeoulcoding.tistory.com/130)
- [13537번 : 수열과 쿼리 1](https://blog.naver.com/PostView.nhn?blogId=adamdoha&logNo=222085092367&categoryNo=67&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView)  
  배열을 사용하면 시간과 메모리를 줄일 수 있음이 나와있다.