
/*
문자 <와>만으로 구성된 문자열을 생각해보십시오. 
각각의 <가 항상 해당> 문자의 앞 (즉, 왼쪽)에 나타날 경우 문자열이 균형을 이룬 것으로 간주합니다 (인접하지 않아도됩니다). 
또한 각 <및> 기호는 고유 한 기호 쌍으로 작동하며 기호는 다른 기호 쌍의 일부로 간주 될 수 없습니다.
문자열의 균형을 유지하기 위해> 문자를 <>로 대체 할 수 있습니다. 
표현식과 최대 교체 횟수가 주어지면 불균형 문자열을 균형 잡힌 문자열로 바꿀 수 있습니까?

예를 들어, 문자열 << >>, <> 및 <> <>은 모두 균형을 이루고 있지만 >>, <<> 및> <> <>> 문자열은 불균형합니다. 
문자열 >>은 각>을 <> <>로 바꿈으로써 두 가지 동작에서 균형을 이룰 수 있습니다.

함수 설명
아래 편집기에서 balancedOrNot 함수를 완성하십시오. 
이 함수는 expressions [i]가 균형 잡힌 경우 element [i]가 1을 포함하고,
균형이 맞지 않은 경우 0을 포함하는 정수 배열을 반환해야합니다.
*/

function isBalanced(expression, maxReplace) {
    for (var i = 0; i < expression.length; i++) {

    }
}

function balancedOrNot(expressions, maxReplacements) {
    
    for (var i = 0; i < expressions.length; i++) {

    }
}

console.log(balancedOrNot(
    ['<>>>', '<>>>>'], [2, 2]
));