Prompt Template 작성
[]배송지 정렬을 요청하는 구체적인 요청 Prompt 템플릿 작성

SortDeliveryAddressChatService 구현
[]기준 허브 주소와 정렬이 필요한 배송지 목록을 전달받아 ChatGPT를 통해 정렬된 결과를 반환하는 메서드 구현
[]ChatClient와 Prompt 템플릿을 사용하여 JSON 형태의 결과를 List 형태로 변환하여 반환
[]배송지와 배송지 순서가 지정된 ChatGPT 응답 매핑을 위한 객체 정의
[]SequencedDeliveryAddress.java

배송지 정렬 요청 객체 정의
[]도착지 허브 주소와 정렬이 필요한 배송지 목록을 필드로 가지는 record 객체 정의
[]SortDeliveryAddressRequest.java

배송지 목록 객체를 ChatGPT에 전달하기 위해 일관된 문자열로 변환하는 Formatter 구현
[]배송지 목록 객체의 일관된 문자열 변환 검증을 위한 Test 작성
[]DeliveryAddressFormatterTest.java

배송지 목록 정렬 Service 구현: SortDeliveryAddressFacade
[]DIP 원칙에 따라 고수준 모듈이 ChatGPT와 통신하는 저수준 모듈의 구체적인 구현체에 직접 의존하지 않도록 인터페이스를 이용하여 의존 관계를 설정
[]인터페이스를 통해 고수준 모듈에서 저수준 모듈의 구현체를 교체하거나 확장할 수 있도록 구성
[]고수준 모듈: SortDeliveryAddressFacade.java
[]저수준 모듈: SortDeliveryAddressChatService.java
[]인터페이스: SortDeliveryAddressService.java

SortDeliveryAddressController 구현
[]API Endpoint 정의: POST /api/chat/delivery-addresses/sort
[]@RequestBody를 이용하여 기준 허브 주소(hubAddress)와 배송지 목록(addresses)을 수신
[]수신 데이터를 SortDeliveryAddressChatService로 전달하여 ChatGPT를 통해 응답받고 반환

테스트 코드 작성
[]POST /api/chat/delivery-addresses/sort API의 동작을 검증하는 통합 테스트 작성 및 실행