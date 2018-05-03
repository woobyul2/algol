/*
N명의 사람이 있을 때, N명의 사람을 서로 다른 방법으로 줄을 세우는 방법은 N!개가 존재합니다.

이 때 각각의 사람들에게 번호를 매겨서 줄을 서는 방법을 표시합니다. 
예를들어 [1,2,3,4]는 1번 사람이 제일 앞에, 2번 사람이 2두번째에... 서 있는 상태를 나타냅니다.

이러한 각각의 방법을 사전순으로 정렬했을때 K번째 방법으로 줄을 세우는 방법을 찾아 보려고 합니다.

예를 들어 3명의 사람이 있다면 총 6개의 방법은 다음과 같이 정렬할 수 있습니다.

1번째 방법은 [1,2,3]
2번째 방법은 [1,3,2]
3번째 방법은 [2,1,3]
4번째 방법은 [2,3,1]
5번째 방법은 [3,1,2]
6번째 방법은 [3,2,1]
이 때 K가 5이면 [3,1,2]가 그 방법입니다.

사람의 수 N과 순서 K를 입력받아 K번째 방법으로 줄을 세우는 setAlign 함수를 완성해 보세요. 
예를 들어 setAlign(3,5)를 입력받는다면 [3,1,2]를 리턴해주면 됩니다.
*/

function factorial(n) {
    if (n > 1) {
        return n * factorial(n - 1);
    } else {
        return n;
    }
}

function getPositionIndex(n) {
    if (n < 4) {
        return 1;
    } else {
        return (n - 1) * getPositionIndex(n - 1);
    }
}

var answer;
var loopCount;

function getArray(sortArray) {
    var sortArrayLength = sortArray.length;
    var tempArray;
    if (sortArrayLength > 2) {
        for (var i = 0; i < sortArrayLength; i++) {
            var cloneArray = sortArray.slice();
            var num = cloneArray[i];
            cloneArray.splice(i, 1);
            getArray(cloneArray);
            
            var index = factorial(sortArrayLength - 1);
            var positionIndex = (loopCount / getPositionIndex(sortArrayLength)) - 1;

            for (var j = positionIndex * index; j < (positionIndex + 1) * index; j++) {
                answer[j].splice(0, 0, num);
            }
        }
    } else {
        answer.push([sortArray[0], sortArray[1]]);
        answer.push([sortArray[1], sortArray[0]]);
        loopCount++;
    }
}

function setAlign(n, k) {
    answer = [];
    loopCount = 0;

    if (n < 2) {
        return [1];
    }

    var initArray = [];

    for (var i = 0; i < n; i++) {
        initArray.push(i + 1);
    }
    getArray(initArray);
    console.log(factorial(n));

    // return answer[k - 1];
    return answer;
}

// 아래는 테스트로 출력해 보기 위한 코드입니다.
console.log(setAlign(4, 5));
// setAlign(3, 5);

