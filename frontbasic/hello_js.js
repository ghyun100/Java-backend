console.log('Hello Javascript!');

// 한 줄 주석
/* 부부 주석 */

// 변수 선언 방법 //
// 1. 변수의 타입이 존재하지 않음
var variable_name;
var variable_name = '변수  값';
console.log(variable_name.trim());
variable_name = 10;
// console.log(variable_name.trim());

// 2. 변수 선언 키워드
//    var, let const
var variable_name;
if (10 == 10) {
    var variable_name2 = '변수';
}
console.log(variable_name2);

let let_variable_1;
// let let_variable_1;
if (10 == 10) {
    let let_variable_2 = '블럭 변수';
}
// console.log(let_variable_2);

const const_variable_1 = '상수';
// const_variable_1 = '변경 상수';

// 3. 데이터의 타입
//    문자열 string : '', ""
let stringVariable1 = '문자열';
let stringVariable2 = '문자열';
console.log(typeof(stringVariable1, stringVariable2));
// 숫자 number : 정수, 실수
let numberVariable1 = 10;
let numberVariable2 = 1.5;
console.log(typeof(numberVariable1, numberVariable2));
// 논리 boolean : true, flase
let booleanVariable = true;
console.log(typeof(booleanVariable));
// null
let nullVariable = null;
console.log(typeof(nullVariable));
// 배열 : []
let arrayVariable = [1, 'A', false];
arrayVariable[0];
// 객체 : {}
let objectVariable = {
    key: "value", 
    name: "John",
    age: 20,
    "object": {
        "key1": 1
    } 
};

// 연산자 //
// 1. 나눗셈 연산자
let number1 = 10 / 3;
console.log(number1); 
// 2. 제곱 연산자 (**)
let number2 = 10 ** 3;
console.log(number2);
// 3. 비교연산 ==, ===
let numberValue10 = 10;
let stringValue10 = '10';
console.log(numberValue10 == stringValue10);  // 일반적인 같다, 연산 타입은 비교하지 않고 문자열과 숫자열만 비교할 때 숫자를 문자열로 바꿔서 비교 
console.log(numberValue10 === stringValue10); // 서로 타입까지 비교해서 false가 나옴

// if 조건 //
let tmpValue = null;
if (tmpValue) console.log('true');
else console.log('false');

// class //
class Human{
    name;
    age;
    address;
    constructor(name, age, address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

let humanObject = new Human('John', 30, '부산');
console.log(humanObject.name);

// 비구조화 할당 //
// const { name, age, address } = humanObject;
let { name, ...others } = humanObject;
console.log(name);
console.log(others);

name = 'Micle';
humanObject = { ...humanObject, name };
// { name, age, address, name }
console.log(humanObject);

const tmpArray = [1, 'A', true];
const [ number, ...otherArray] = tmpArray;
console.log(number);
console.log(otherArray);

// 함수 //
function function1(arg, arg2) {
    
}
function1(1, 2);

const function2 = (arg1, arg2) => {
        
}
function2(1 ,2);