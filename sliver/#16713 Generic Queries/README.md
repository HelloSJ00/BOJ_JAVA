# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/10.svg" class="solvedac-tier"> [Generic Queries](https://www.acmicpc.net/problem/16713) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|99061695| hellosj2000|맞았습니다!! 맞았습니다!!|307868KB|1344ms|Java 11|1017B|

## 문제
<p>관영이는 쿼리를 좋아하고, XOR도 좋아한다. 그래서 관영이는 XOR을 이용한 쿼리 문제를 좋아한다.</p>

<p>길이가 $N$인 수열 $a_1 , a_2 , \cdots a_N$이 있다. </p>

<p>이제 관영이는 $Q$개의 쿼리에 답하려 한다. 각 쿼리는 $s_i , e_i$ ($1 \le s_i \le e_i \le N$)의 형태로 들어오고, 그 쿼리의 답은 $a_{s_i}, a_{s_i+1}, \cdots a_{e_i}$을 모두 XOR한 값이다. </p>

<p>$Q$개의 쿼리가 들어올 때, 각 쿼리의 답을 모두 XOR한 결과를 구하시오. </p>

## 입력
<p>첫째 줄에는 $N, Q$가 공백을 사이에 두고 주어진다. ($1 \le N \le 10^6$, $1 \le Q \le 3 \cdot 10^6$)</p>

<p>둘째 줄에는 $a_1, a_2, \cdots a_N$이 공백을 사이에 두고 주어진다. ($0 \le a_i \le 10^9$)</p>

<p>그 후, $Q$개의 줄에 걸쳐서, 각 줄마다 하나의 쿼리 $s_i, e_i$가 공백을 사이에 두고 주어진다. ($1 \le s_i \le e_i \le N$) </p>

## 출력
<p>모든 쿼리의 답을 XOR한 값을 출력하시오. </p>

