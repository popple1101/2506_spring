package org.iclass.spring_7jpa.advanced_java;

import java.util.Optional;

public class OprionalJavaApplication {
    public static void main(String[] args) {
        Optional<String> noneEmpty = Optional.of("HI STREAM"); // null 이 아닌 값을 저장하는 컨테이너 Optional 생성
        Optional<String> nullable = Optional.ofNullable(null); // null을 가질 수 있는 컨테이너 Optional 생성
        Optional<String> empty = Optional.empty(); // 비어있는 컨테이너 Optional 생성

        // 메소드 테스트
        // 1) 값의 존재 확인
        // System.out.println("noneEmpty.isPresent() : " + noneEmpty.isPresent());
        // System.out.println("nullable.isEmpty() : " + nullable.isEmpty());

        // 2) 값 가져오기
        // System.out.println("noneEmpty.get() : " + noneEmpty.get());
        // System.out.println("empty.get() : " + empty.get()); // isPresent() 거짓일 때 오류 발생

        // System.out.println("nullable.get() : " + nullable.get());

        // 3) isEmpty()일 때 처리 메소드
        String result = nullable.orElse("기본값"); // orElse 메소드는 인자는 값 (T 타입)
        System.out.println("String result = nullable.orElse(\"기본값\") 리턴 : ");
        System.out.println(result);

        result = nullable.orElseGet(() -> "리턴값"); // orElseGet 메소드 인자가 Supplier 함수
        System.out.println("result = nullable.orElseGet(() -> \"리턴값\")");
        System.out.println(result);

        // result = nullable.orElseThrow(null); // 값이 없으면 예외 발생

        // 4) if(noneEmpty.isParsent()) noneEmpty.get().length 에 해당하는 실행을 ifParsent() 메소드 사용
        final int[] length = new int[1];
        // final int test; // 사용 못함
        noneEmpty.ifPresent(s-> {
            length[1] = s.length(); // 여기서는 final 변수만 사용 가능. 일반적이s final int 는 ❌. 배열사용
            // test = s.length(); // 사용 못함
            System.out.println(s.length());
        }); // 값이 존재할 때만 실행하는 Consumer 함수 인터페이스가 인자
        


    }
}
