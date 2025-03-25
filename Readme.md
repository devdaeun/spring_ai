Step1. ChatClient를 이용한 기본 Chat GPT 연동

Chat GPT 연동을 위한 환경 설정 구성
    [X] 민감한 정보 관리를 위한 .env 구성 및 발급 받은 Open AI Key 등록
    [X] .env에 설정한 Open AI Key를 application.yml의 spring.ai.openai.api-key 항목에 연결

ChatClient Configuration 설정 : ChatClientConfig
    [] ChatClient.Builder를 이용하여 ChatClient Bean 등록

ChatClient를 이용한 ChatGPT 연동 Service 구현: BasicChatService
    [] 사용자 질문(prompt)을 ChatClient를 통해 전달하여 ChatGPT의 응답을 반환하는 메서드 구현

ChatClient를 이용한 ChatGPT 연동 Controller 구현 : BasicChatController
    [] API endpoint 정의 : GET /api/chat/basic
    [] @RequestParam을 이용하여 사용자 질문(prompt)을 수신
    [] 수신한 prompt를 BasicChatService의 메서드에 전달하여 ChatGPT의 응답 반환

테스트 코드 작성
    [] GET /api/chat/basic API 동작을 검증하는 통합 테스트 작성 및 실행