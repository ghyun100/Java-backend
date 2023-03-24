package chapter6.A_CollectionClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// Collection Framework ( 컬렉션 객체 )
// 배열형태의 데이터를 보다 편하게 사용할 수 있도록 해주는 클래스의 집합


public class CollectionClass {

	public static void main(String[] args) {
		
		// Set 클래스
		// 집합 - 중복을 허용하지 않고 순서가 없는 형태
		// 순서가 없기 때문에 index 사용 불가능
		
		// HashSet<E> : 중복을 허용하지 않고 순서가 없는 형태
		Set<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(2);
		integerSet.add(1);		
		integerSet.add(4);
		integerSet.add(2);
		System.out.println(integerSet);
		Iterator<Integer> iterator = integerSet.iterator();		
		
		// hasNext : 그다음 값이 있는가 없는가(true, false)
		// next : 앞에서부터 차례로 출력
		while(iterator.hasNext()) {
			System.out.println(iterator.next()
					);
		}
		
//		for (Integer item: integerSet) {
//			System.out.println(item);
//		}  // for each문으로도 하나씩 빼오는거 가능
		
		// TreeSet<E> : 중복을 허용하지 않고 순서가 없는 형태 + 정렬
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(4859);
		treeSet.add(123);
		treeSet.add(4859);
		
		treeSet.add(798);
		treeSet.add(798);
		treeSet.add(3564113);
		
		for (Integer item: treeSet) {
			System.out.println(item);
		}
		
		System.out.println("-----------------------------");
		
		
		// Lotto응용 (ApiClass참조)
		Set<Integer> lotto = new TreeSet<>();
		
		while (lotto.size() < 6) {
			Random random = new Random();
			int randomNumber = random.nextInt(45) + 1;
			lotto.add(randomNumber);
			
		}
		System.out.println(lotto.toString());
		
		
		// List
		// 데이터를 일렬로 나열한 구조
		// 순서가 존재하고 중복이 허용 (배열)
		
		// ArrayList<E> : 순서가 존재하고 중복이 허용된 배열
		List<String> list = new ArrayList<String>(); // 인터페이스라서 그냥List<String>이 아닌 
		                                             // ArratList<String>으로 써줌
		
		list.add("apple");
		list.add(0, "banana"); // -> 추가

		list.set(0, "BaNaNa"); // -> 변경
		
		String removeItem = list.remove(1); // -> 삭제
		System.out.println(removeItem); // 삭제된거 꺼내기
	
		System.out.println(list.toString());
		
		for(int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		
		// LinkedList<E> : 순서가 존재하고 중복이 허용된 '배열' + 
		//                 각 요소가 이전 요소와 다음 요소의 주소를 같이 가지고 있음
		//                 검색속도가 빠름
		
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		
		long startTime = System.currentTimeMillis();
		for (int integer = 0; integer < 100_000; integer++) {
			arrayList.add(0, integer);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Array List 작업 시간 : " + (endTime - startTime));
		
		
		startTime = System.currentTimeMillis();
		for (int integer = 0; integer < 100_000; integer++) {
			linkedList.add(0, integer);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Linked List 작업 시간 : " + (endTime - startTime));
		
	
		// Map
		// key와 value가 하나의 쌍으로 저장되는 구조
		// 순서가 존재하지 않음, 단 key를 사용해서 특정한 value를 가져올 수 있음
		
		// HashMap<E, E>
		Map<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("key", "value");
		hashMap.put("apple", "사과");
		
		System.out.println(hashMap.get("apple"));
		
		
	}

}
