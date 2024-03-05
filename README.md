# PCMOA
> PCMOA는 PC 관련(모니터, 본체, 마우스, 키보드 등) 물품을 판매하는 전자상거래 플랫폼입니다.
> 기능 개발은 지속해서 이루어지고 있습니다. 업데이트가 완료되는대로 리드미는 수정됩니다.

## 0️⃣ 개발 환경
- **프론트엔드** : Thymeleaf, CSS, Javascript, Jquery, Bootstrap
- **백엔드** : Java 17, SpringBoot 3.2.3, MariaDB, AWS(S3, EC2) ※ EC2는 과금으로 중단(24.03.05)
<br></br>

## 1️⃣ 개발 블로그 및 깃허브
- **블로그** : https://choidevvv.tistory.com/category/Personal%20Project/pcmoa
- **깃허브** : https://github.com/ChoiDevv/pcmoa/tree/dev ※ 브랜치는 dev에서 작업 중(24.03.05)
<br></br>

## 2️⃣ 개발 진행 상황
- **24.03.01** : CI/CD 파이프라인 구축 및 EC2 인스턴스 생성과 더불어 연동 완료
- **24.03.02** : 회원가입 페이지 및 기능 구현
- **24.03.04** : 로그인 페이지 및 기능 구현
- **24.03.05** : 관리자 페이지 사용자, 상품 페이지 구현(사용자 조회, 상품 등록 기능)
<br></br>

## 3️⃣ 개발 가이드라인
- **관리자** : admin@gmail.com 계정만 관리자 권한이 부여되도록 설정 ※ 차후에 수정 예정
- **데이터베이스** : MariaDB 3306번 포트를 사용하고 있으며 DB명은 pcmoa
<br></br>

## 4️⃣ URL
| 도메인                   | 설명           | Http 메소드 |
|:----------------------|:-------------|:--------:|
| /                     | 메인 페이지       |   GET    |
| /login                | 로그인 페이지      |   GET    |
| /login                | 로그인          |   POST   |
| /sign-up              | 회원가입 페이지     |   GET    |
| /sign-up              | 회원가입         |   POST   |
| /user/duplicate-check | 이메일 중복 검사    |   GET    |
| /admin/dashboard      | 관리자 페이지      |   GET    |
| /admin/user-list      | 관리자 유저관리 페이지 |   GET    |
| /admin/product-list   | 관리자 상품관리 페이지 |   GET    |
| /admin/product/save   | 관리자 상품 저장    |   POST   |
<br></br>

## 🕐 리드미 최신화 일자
2024년 3월 5일에 최신화하였습니다.