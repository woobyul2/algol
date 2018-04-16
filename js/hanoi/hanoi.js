// 풀이 
// 조건 2^n-1번 루프를 돌았을 때 column 0,1이 비어있어야함.
// 홀수층은 오른쪽으로 2번 짝수층은 오른쪽으로 1번 이동.
// 기둥 0부터 탑 이동이 불가할때 까지 이동시킴. 
// 0 ~ 2순으로 기둥이 이동 가능한지 판단. 1 루프당 모든 기둥에 대해 판단 후 다시 처음 기둥으로 돌아가야함.
// 이동할 기둥이 3일 경우 0번 기둥으로 변환.
// 탑은 자기보다 층이 낮은 (값이 작은) 탑으로만 이동 가능.
// 연속해서 같은 층은 움직일 수 없음.

var MAX_COLUMN_SIZE = 3;
var columns;

var columnPosition;
var loopCount;

/**
 * 기둥 초기화 함수.
 * 첫번째 기둥에 n개의 층을 쌓는다.
 * 
 * @param {*} n 총 층수
 */
function initHanoi(n) {
    columns = [];

    columnPosition = 0;
	loopCount = 0;
	for (var i = 0; i < MAX_COLUMN_SIZE; i++) {
		var column = new Array();
		if (i == 0) {
			for (var k = 0; k < n; k++) {
				column.push(k + 1);
			}
		}
		columns[i] = column;
	}
}

function moveNextColumn() {
    columnPosition++;
    if (columnPosition >= MAX_COLUMN_SIZE) {
        columnPosition = 0;
    }
}

function hanoi(n) {
	initHanoi(n);
    
    console.log('start::' + columns);

    var answer = [];
	var beforeMovedFloor = -1;

	// 2^n-1번 루프 돌림
	while (loopCount < Math.pow(2, n) - 1) {
		var curColumn = columns[columnPosition];
        var floorValue = curColumn[curColumn.length - 1];
        if (floorValue > 0) {
            // 짝수층은 1 홀수층은 2
            var moveCount = floorValue % 2 == 0 ? 1 : 2;
            var movedColumnPosition = columnPosition + moveCount;
            
            // 이동할 기둥이 갯수보다 클 경우 
            if (movedColumnPosition >= MAX_COLUMN_SIZE) {
                movedColumnPosition -= MAX_COLUMN_SIZE;
            }

            var movedColumn = columns[movedColumnPosition];

            if ((movedColumn.length == 0 || floorValue > movedColumn[movedColumn.length - 1]) && beforeMovedFloor != floorValue) {
                movedColumn.push(curColumn.pop());
                answer.push([columnPosition + 1, movedColumnPosition + 1]);
				loopCount++;
                beforeMovedFloor = floorValue;
                //$('#honoiDiv').append('[' + columnPosition + ', ' + movedColumnPosition + '], ');
            } else {
                moveNextColumn();
            }
        } else {
            moveNextColumn();   
        }
	}
    
    console.log('end::' + columns);

	return answer;
	// 2차원 배열을 반환해 주어야 합니다.
}

// 아래는 테스트로 출력해 보기 위한 코드입니다.
console.log(hanoi(10));


// N이 2라면
// 리턴값은 [ [1,2], [1,3], [2,3] ]입니다.
// 롯데타워 123층