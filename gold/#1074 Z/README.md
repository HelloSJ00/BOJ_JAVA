# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" class="solvedac-tier"> [Z](https://www.acmicpc.net/problem/1074) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|86357565| hellosj2000|맞았습니다!! 맞았습니다!!|14380KB|104ms|Java 11|1150B|

## 문제
<p>한수는 크기가 2<sup>N</sup> × 2<sup>N</sup>인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.</p>

<p style="text-align:center"><img alt="" src="https://u.acmicpc.net/21c73b56-5a91-43aa-b71f-9b74925c0adc/Screen%20Shot%202020-12-02%20at%208.09.46%20AM.png" style="width: 100px; height: 99px;"></p>

<p>N > 1인 경우, 배열을 크기가 2<sup>N-1</sup> × 2<sup>N-1</sup>로 4등분 한 후에 재귀적으로 순서대로 방문한다.</p>

<p>다음 예는 2<sup>2</sup> × 2<sup>2</sup> 크기의 배열을 방문한 순서이다.</p>

<p style="text-align:center"><img alt="" src="https://u.acmicpc.net/adc7cfae-e84d-4d5c-af8e-ee011f8fff8f/Screen%20Shot%202020-12-02%20at%208.11.17%20AM.png" style="width: 250px; height: 252px;"></p>

<p>N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.</p>

<p>다음은 N=3일 때의 예이다.</p>

<p style="text-align:center"><img alt="" src="https://u.acmicpc.net/d3e84bb7-9424-4764-ad3a-811e7fcbd53f/Screen%20Shot%202020-12-30%20at%2010.50.47%20PM.png" style="width: 533px; height: 535px;"></p>

## 입력
<p>첫째 줄에 정수 N, r, c가 주어진다.</p>

## 출력
<p>r행 c열을 몇 번째로 방문했는지 출력한다.</p>

