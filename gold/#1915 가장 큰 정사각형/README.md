# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" class="solvedac-tier"> [가장 큰 정사각형](https://www.acmicpc.net/problem/1915) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|97002881| hellosj2000|맞았습니다!! 맞았습니다!!|101728KB|1756ms|Java 11|1562B|

## 문제
<p>n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.</p>

<table class="table table-bordered" style="width: 16%">
	<tbody>
		<tr>
			<td style="width: 4%; text-align: center;">0</td>
			<td style="width: 4%; text-align: center;">1</td>
			<td style="width: 4%; text-align: center;">0</td>
			<td style="width: 4%; text-align: center;">0</td>
		</tr>
		<tr>
			<td style="text-align: center;">0</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
		</tr>
		<tr>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">0</td>
		</tr>
		<tr>
			<td style="text-align: center;">0</td>
			<td style="text-align: center;">0</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">0</td>
		</tr>
	</tbody>
</table>

<p>위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다.</p>

## 입력
<p>첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.</p>

## 출력
<p>첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.</p>

