# petmilyday-portfolio

petmilyday 프로젝트를 소개하는 백엔드 포트폴리오 사이트입니다.
Spring Boot + Thymeleaf로 구성되어 있으며, 별도 DB 없이 서버 코드 내 데이터로
페이지를 렌더링합니다.

## 실행 방법 (IntelliJ)

1. IntelliJ에서 `File > Open`으로 이 폴더(`petmilyday-portfolio`)를 엽니다.
   Maven 프로젝트로 자동 인식됩니다.
2. `PortfolioApplication.java`를 열고 실행(▶) 버튼을 누르면 됩니다.
3. 브라우저에서 `http://localhost:8090` 접속.

## 프로젝트 구조

```
src/main/java/com/petmilyday/portfolio
 ├─ PortfolioApplication.java       # 진입점
 ├─ controller/PortfolioController.java  # "/" 요청 처리
 ├─ data/PortfolioData.java         # 소개 콘텐츠(케이스 스터디, 기술스택) 관리
 └─ dto/                            # 화면에 뿌릴 데이터 모델

src/main/resources
 ├─ templates/index.html            # 메인 페이지
 ├─ templates/fragments/            # 헤더/푸터 공통 조각
 └─ static/css/style.css            # 전체 스타일
```

## 콘텐츠 수정하기

- 자기소개, 연락처: `templates/fragments/header.html`, `footer.html`
- 케이스 스터디(문제 해결 사례) 추가/수정: `data/PortfolioData.java`의
  `caseStudies()` 메서드에 `CaseStudyDTO.builder()` 블록을 추가하면
  화면에 카드가 자동으로 추가됩니다.
- 기술 스택 추가: 같은 파일의 `techStacks()` 메서드 수정.

## 다음에 해볼 만한 것

- 프로젝트가 여러 개면 `/projects/{id}` 형태의 상세 페이지 라우팅 추가
- 이미지(아키텍처 다이어그램, 스크린샷)를 `static/images`에 넣고 카드에 첨부
- 무료 배포: Render, Railway, 또는 AWS EC2 + 도메인 연결
