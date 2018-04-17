// 3진수로 변환해서 한번 더 매핑

var answer = "";

function get124(n) {
	if (n == 0) {
		return;
	}
	if (n < 3) {
		answer += "" + n;
	} else if (n % 3 == 0) {
		get124(parseInt(n / 3) - 1);
		answer += "" + 4;
	} else {
		get124(parseInt(n / 3));
		answer += "" + (n % 3);
	}
}
 
function change124(n) {
	answer = "";
	get124(n);
	return answer;
}

// 아래는 테스트로 출력해 보기 위한 코드입니다.
for (var i = 0; i < 22; i++) {
	console.log(change124(i) + '\n');
}

