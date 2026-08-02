package com.petmilyday.portfolio.data;

import com.petmilyday.portfolio.dto.CaseStudyDTO;
import com.petmilyday.portfolio.dto.TechStackDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * petmilyday 프로젝트 소개 페이지에 쓰일 콘텐츠를 코드로 관리한다.
 * DB 없이 정적 텍스트만 다루므로 우선 코드 내 상수로 관리하고,
 * 추후 항목이 많아지면 별도 저장소(DB/CMS)로 옮길 수 있다.
 */
@Component
public class PortfolioData {

    public List<TechStackDTO> techStacks() {
        return List.of(
                TechStackDTO.builder().category("Language").name("Java 17").desc("객체지향 설계 원칙을 준수한 도메인 모델링").build(),
                TechStackDTO.builder().category("Back-end").name("Spring Boot 3").desc("REST API 및 서버 사이드 렌더링(Thymeleaf) 병행").build(),
                TechStackDTO.builder().category("Back-end").name("Spring Security + JWT").desc("Stateless 인증, 쿠키 기반 토큰 관리").build(),
                TechStackDTO.builder().category("Back-end").name("Spring Data JPA").desc("엔티티 연관관계 설계 및 영속성 관리").build(),
                TechStackDTO.builder().category("Database").name("QueryDSL").desc("동적 검색 조건 조합, N+1 방지 fetch join").build(),
                TechStackDTO.builder().category("Infra").name("AWS S3").desc("프로필/반려동물 사진 등 이미지 업로드").build(),
                TechStackDTO.builder().category("Infra").name("OAuth2 (Kakao/Google)").desc("소셜 로그인 연동 및 자동 회원가입").build(),
                TechStackDTO.builder().category("Tools").name("GitHub").desc("이슈/브랜치 전략 기반 협업").build()
        );
    }

    public List<CaseStudyDTO> caseStudies() {
        return List.of(
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
        );
    }
}
