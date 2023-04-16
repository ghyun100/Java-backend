// 변수 //
var number : number;
number = 10;
// number = 'string';
let string = 'string';
// string = 10;

// 함수 //
const funtion = (arg: number): string => {
    return 'string';
}

// 객체 //
// 1. class를 이용
class Object1 {
    prop1: string;
    prop2: number;

    constructor(prop1 : string, prop2: number) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    };
};
const object1: Object1 = { prop1: 'prop1', prop2: 2 };

// 2. type 키워드 사용
type Object2 = {
    prop1: string,
    prop2: number
}
const object2: Object2 = { prop1: 'prop1', prop2: 2 };

// 3. interface 활용
interface Object3 {
    prop1: string;
    prop2: number;
    func1?: (arg1: number) => string; // 뒤에 ? : 필수가 아닌애로 지정
}

const object3: Object3 = {prop1: 'prop1', prop2: 2 };
// const object3: Object3 | null = null;

interface Object4 {
    prop3: string;
    prop4: number;
}
const object4: Object3 & Object4 = {prop1: 'prop1', prop2: 2, prop3: 'string', prop4: 3}