package com.petmilyday.portfolio.data;

import com.petmilyday.portfolio.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 포트폴리오 사이트에 쓰일 콘텐츠를 코드로 관리한다.
 * DB 없이 정적 텍스트만 다루므로 코드 내 상수로 관리한다.
 *
 * 새 프로젝트(ex. 널모아)를 추가하려면:
 *   1) projectSummaries()에 ProjectSummaryDTO 카드 추가 (available = true로)
 *   2) 이 클래스에 nulmoaDetail() 같은 메서드를 추가로 만들고
 *   3) ProjectController에 "/projects/nulmoa" 라우팅 메서드 추가
 */
@Component
public class PortfolioData {

    // ---------- 프로필 ----------
    public ProfileDTO profile() {
        return ProfileDTO.builder()
                .name("이름을 입력하세요")
                .tagline("한 줄 소개를 입력하세요")
                .bio("자기소개 문단을 입력하세요. 어떤 개발자인지, 어떤 것에 관심이 있는지 자유롭게 작성하면 됩니다.")
                .email("example@gmail.com")
                .github("https://github.com/endy7540")
                .phone("010-0000-0000")
                .build();
    }

    // ---------- 전체 기술 스택 (자기소개 페이지) ----------
    // petmilyday, Planslot 등 프로젝트에서 공통으로 활용한 스택을 기준으로 정리
    public List<TechStackDTO> overallTechStacks() {
        return List.of(
                TechStackDTO.builder().category("Language").name("Java").desc("MVC 아키텍처 기반의 백엔드 로직 설계 가능").build(),
                TechStackDTO.builder().category("Back-end").name("Spring / Spring Boot").desc("MVC 아키텍처 기반 백엔드 시스템 구축, 계층 간 DTO 전송 및 비즈니스 로직으로 구조적 설계 가능").build(),
                TechStackDTO.builder().category("Back-end").name("Spring Security / JWT").desc("카카오·구글 소셜 로그인 연동 및 JWT 토큰 기반 회원가입/로그인 인증·인가 로직 설계 및 구현").build(),
                TechStackDTO.builder().category("Database").name("SQL (MariaDB)").desc("SQLD 자격 수준의 지식을 바탕으로 복잡한 데이터 추출과 쿼리 최적화 수행 가능").build(),
                TechStackDTO.builder().category("AI").name("Spring AI").desc("Ollama, OpenAI, Claude 기반 다중 모델 협업 파이프라인을 구축하여 AI 기능 설계 및 구현").build(),
                TechStackDTO.builder().category("Data").name("Python").desc("수학적 논리력을 바탕으로 데이터 전처리에 활용 가능").build(),
                TechStackDTO.builder().category("Tools").name("Git / Notion").desc("이슈·브랜치 전략 기반 협업 및 프로젝트 문서화").build()
        );
    }

    // ---------- 홈 화면 Featured Project (큰 목업 쇼케이스) ----------
    public FeaturedProjectDTO featuredProject() {
        return FeaturedProjectDTO.builder()
                .badge("Featured · Web")
                .name("petmilyday")
                .tagline("반려동물의 보호자를 위한 병원 예약·리뷰·커뮤니티 통합 플랫폼")
                .urlLabel("localhost:8080")
                .screenshotUrl(null) // 실제 실행 화면 캡처 후 "/images/petmilyday-preview.png" 형태로 채워 넣으면 됩니다.
                .highlights(List.of(
                        "<strong>동물병원 예약</strong> — 병원 검색부터 예약, 진료기록 확인까지 원스톱 처리",
                        "<strong>AI 증상 자가진단</strong> — 간단한 증상 입력만으로 건강 상태 빠르게 확인",
                        "<strong>커뮤니티 / 모임</strong> — 게시판, 댓글, 좋아요와 오프라인 모임 신청·승인",
                        "<strong>중고거래</strong> — 안 쓰는 반려동물 용품을 이웃과 나누고 거래"
                ))
                .detailUrl("/projects/petmilyday")
                .repoUrl(null) // 공개 저장소 주소가 있으면 채워 넣으면 됩니다.
                .build();
    }

    // ---------- 홈 화면 프로젝트 카드 목록 ----------
    public List<ProjectSummaryDTO> projectSummaries() {
        return List.of(
                ProjectSummaryDTO.builder()
                        .slug("petmilyday")
                        .name("petmilyday")
                        .tagline("반려동물 생활 통합 플랫폼")
                        .period("2026")
                        .role("Back-end Engineer")
                        .emoji("🐾")
                        .available(true)
                        .techBadges(List.of("Spring Boot", "JPA", "QueryDSL", "JWT/OAuth2"))
                        .build(),

                ProjectSummaryDTO.builder()
                        .slug("nulmoa")
                        .name("널모아")
                        .tagline("프로젝트 준비 중입니다")
                        .period("진행중")
                        .role("")
                        .emoji("🧩")
                        .available(false)
                        .techBadges(List.of())
                        .build()
        );
    }

    // ---------- petmilyday 상세 ----------
    public ProjectDetailDTO petmilydayDetail() {
        return ProjectDetailDTO.builder()
                .name("petmilyday")
                .tagline("반려동물 생활 플랫폼")
                .description("동물병원 예약, AI 증상 진단, 커뮤니티, 중고거래까지 반려동물과 함께하는 " +
                        "일상을 지원하는 통합 서비스입니다.")
                .period("2026")
                .teamSize("-")
                .role("Back-end Engineer")
                .features(List.of(
                        FeatureDTO.builder().icon("🏥").title("동물병원 예약").desc("병원 검색부터 예약, 진료기록 확인까지 원스톱으로 처리").build(),
                        FeatureDTO.builder().icon("🤖").title("AI 증상 자가진단").desc("간단한 증상 입력만으로 반려동물 건강 상태를 빠르게 확인").build(),
                        FeatureDTO.builder().icon("💬").title("커뮤니티 / 모임").desc("게시판, 댓글, 좋아요와 오프라인 모임 신청·승인 기능").build(),
                        FeatureDTO.builder().icon("🔄").title("중고거래").desc("안 쓰는 반려동물 용품을 이웃과 나누고 거래").build()
                ))
                .techStacks(List.of(
                        TechStackDTO.builder().category("Language").name("Java 17").desc("객체지향 설계 원칙을 준수한 도메인 모델링").build(),
                        TechStackDTO.builder().category("Back-end").name("Spring Boot 3").desc("REST API 및 서버 사이드 렌더링(Thymeleaf) 병행").build(),
                        TechStackDTO.builder().category("Back-end").name("Spring Security + JWT").desc("Stateless 인증, 쿠키 기반 토큰 관리").build(),
                        TechStackDTO.builder().category("Back-end").name("Spring Data JPA").desc("엔티티 연관관계 설계 및 영속성 관리").build(),
                        TechStackDTO.builder().category("Database").name("QueryDSL").desc("동적 검색 조건 조합, N+1 방지 fetch join").build(),
                        TechStackDTO.builder().category("Infra").name("AWS S3").desc("프로필/반려동물 사진 등 이미지 업로드").build(),
                        TechStackDTO.builder().category("Infra").name("OAuth2 (Kakao/Google)").desc("소셜 로그인 연동 및 자동 회원가입").build(),
                        TechStackDTO.builder().category("Tools").name("GitHub").desc("이슈/브랜치 전략 기반 협업").build()
                ))
                .caseStudies(List.of(
                        CaseStudyDTO.builder()
                                .badge("인증 / 보안")
                                .title("JWT + OAuth2 소셜 로그인 통합 인증 구조")
                                .summary("자체 로그인과 카카오·구글 소셜 로그인을 하나의 인증 체계로 통합")
                                .problem(List.of(
                                        "자체 회원가입/로그인(JWT 쿠키 기반)과 소셜 로그인을 하나의 인증 흐름으로 통합해야 했음",
                                        "이미 탈퇴(WITHDRAWN) 처리된 계정이 소셜 로그인으로 재접근할 수 있는 위험 존재"
                                ))
                                .approach(List.of(
                                        "세션을 쓰지 않는 완전한 Stateless 구조로 설계하여 인증 정보는 JWT로만 관리",
                                        "로그인 진입 경로가 달라도(자체/소셜) 계정 상태 검증 로직은 하나로 통일"
                                ))
                                .action(List.of(
                                        "Member 엔티티에 AccountStatus(ACTIVE/BANNED/WITHDRAWN) 도입, 로그인 시점에 공통 검증",
                                        "소셜 로그인 최초 진입 시 이메일 기준으로 기존 회원을 매핑하고, 신규 회원은 provider + 식별자로 자동 가입 처리",
                                        "인증 실패 시 로그인 페이지로 리다이렉트하는 AuthenticationEntryPoint 커스터마이징"
                                ))
                                .result(List.of(
                                        "인증 경로가 달라도 탈퇴 회원 접근을 일관되게 차단",
                                        "USER / HOSPITAL_ADMIN / ADMIN 권한 체계를 하나의 구조로 통일"
                                ))
                                .build(),

                        CaseStudyDTO.builder()
                                .badge("데이터 / 성능")
                                .title("QueryDSL 기반 동적 검색과 N+1 문제 해결")
                                .summary("조건이 계속 늘어나는 검색 기능을 유지보수 가능한 구조로 구현")
                                .problem(List.of(
                                        "관리자 회원 검색(키워드/권한/상태), 커뮤니티 게시글 검색(제목/내용/작성자)이 조건을 선택적으로 조합해야 함",
                                        "목록 조회 시 연관된 작성자 정보를 함께 조회하면서 N+1 쿼리 발생 우려"
                                ))
                                .approach(List.of(
                                        "정적 JPQL로는 조건 조합에 대응하기 어려워 QueryDSL의 BooleanBuilder로 동적 쿼리 조립",
                                        "목록 조회 쿼리에 fetch join을 적용해 연관 엔티티를 한 번에 로딩"
                                ))
                                .action(List.of(
                                        "MemberRepositoryImpl: 키워드/권한/상태를 각각 null-safe BooleanExpression으로 분리 후 조합",
                                        "CommunityPostSearchImpl: 검색 타입(t/c/w) 조합에 따라 조건을 동적 구성, leftJoin().fetchJoin() 적용",
                                        "페이징은 Pageable과 별도 fetchCount()로 분리해 카운트 쿼리 최적화"
                                ))
                                .result(List.of(
                                        "검색 조건이 늘어나도 쿼리 메서드 추가 없이 대응 가능한 구조 확보",
                                        "목록 조회 시 발생하던 N+1 쿼리 제거"
                                ))
                                .build(),

                        CaseStudyDTO.builder()
                                .badge("도메인 설계")
                                .title("모임(Meetup) 참여 승인 워크플로우 설계")
                                .summary("신청-승인 흐름과 정원 관리를 엔티티 책임으로 응집")
                                .problem(List.of(
                                        "단순 참여가 아닌 신청(PENDING) → 방장 수락/거절 흐름이 필요",
                                        "정원이 차면 자동 마감, 취소 시 자동 재모집 전환 등 상태 전이가 얽혀있어 버그 위험이 컸음"
                                ))
                                .approach(List.of(
                                        "정원 관련 판단 로직(추가/제거 시 마감 여부)을 MeetupPost 엔티티 내부 메서드로 캡슐화",
                                        "단순 반복적인 상태 변경은 벌크 연산으로 처리해 불필요한 영속성 컨텍스트 갱신 방지"
                                ))
                                .action(List.of(
                                        "MeetupParticipant에 PENDING/APPROVED 상태를 두고 신청 시 PENDING으로 생성",
                                        "forceApproveStatus, forceAddParticipant 등 @Modifying(clearAutomatically=true) 벌크 쿼리로 처리",
                                        "모임 삭제 시 cascade + orphanRemoval로 댓글/참여자 데이터 정합성 유지"
                                ))
                                .result(List.of(
                                        "방장 승인 기반 참여 관리 기능을 엔티티 책임 분리를 통해 구현",
                                        "정원 초과·재모집 전환 등 상태 전이 로직의 오류 발생 여지를 엔티티 내부로 응집"
                                ))
                                .build()
                ))
                .build();
    }
}
