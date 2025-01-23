<h1 align="center">
  <br>
  <img src="https://github.com/user-attachments/assets/42f7e699-960c-4130-93b4-e8f70d2e04b0" alt="SLS" width="300">
  <br>
  스마트 도서관리 시스템
  <br>
</h1>

## 📌 목차
1. [🖥️ 프로젝트 개요](#%EF%B8%8F-프로젝트-개요)
2. [📕 주요기능](#-주요기능)
3. [📖 요구사항 정의서 및 개발일정](#-요구사항-정의서-및-개발일정)
4. [🏗️ E-R Model & ERD](#%EF%B8%8F-erd)
5. [🔧 프로토타입](#-프로토타입)
6. [📽️ 시연영상](#%EF%B8%8F-시연영상)
7. [🗃️ 발표자료](#%EF%B8%8F-발표자료)

      <br><br>

## 🖥️ 프로젝트 개요
### :calendar: 개발기간
  - 2024.10.14 ~ 2024.10.24 (총 11일)

### 🧑‍🤝‍🧑 인원
  - 1명 (개인 프로젝트 진행)

### 🔖프로젝트 주제
  - 기획 배경: <br>
    - 최근 <b>스마트폰과 모바일 기기의 보급이 급격히 증가함</b>에 따라, <br>사람들의 정보 소비 방식이 변화하고 있음.
    - 특히, <b>도서관 이용률이 현저히 낮아지는 추세</b>를 보이고 있으며, <br>이는 전통적인 도서 대여 방식이 현대인의 라이프스타일에 적합하지 않다는 것을 의미함. 
    - <b>쉬운 사용법으로</b> <mark>도서관 이용에 대한 진입장벽을 낮추고</mark> , <br><b>효율적인 관리</b>를 통해 도서관 <mark>운영의 효율성을 높이기 위함</mark>
  - 기획 목적: <br>
    - 도서관 이용에 대한 진입장벽을 낮춤
    - 도서관 이용의 편리함을 극대화
    - 도서관 이용률을 높이고, 독서 문화를 활성화
  - 기대 효과: <br>
    - 사용자는 도서를 쉽게 대출하고 반납하여 편의성이 향상됨
    - 관리자에게는 효율적인 도서 관리와 대여 시스템을 제공하여 시간 과 인력을 절약
    
### ⚙️ 개발환경 및 도구
  - **언어**: Java 1.8
  - **주요 라이브러리**: Java Swing, AWT, Sql
  - **드라이버**: Ojdbc6 
  - **데이터베이스**: Oracle
  - **개발 툴**: Eclipse, SQLPlus, SqlDeveloper
  - **형상 관리**: Github

### 기술 구현
<ol>
  <li>
    GUI 제작
  </li>
  <ul>
    <li>
      JAVA swing, awt package를 통한 GUI 구현
    </li>
    <li>
      페이퍼 프로토타입, 윈도우 빌더 등 다양한 방법을 사용하여 깔끔한 화면 구성을 위해 노력
    </li>
  </ul>
  <li>
    CRUD위한 클래스 설계
  </li>
  <ul>
    <li>
      DAO를 통한 CRUD 작업 진행
    </li>
    <li>
      DTO를 통한 정보의 전달
    </li>
    <li>
      상속과 인터페이스 구현을 통한 유지보수 용이성 추구
    </li>
  </ul>
  <li>
    코드 작성
  </li>
  <ul>
    <li>
      콜렉션 프레임 워크(ArrayList) 사용
    </li>
    <li>
      oracle전용의 jdbc라이브러리 사용을 통한 데이터 관리(bulid 라이브러리 사용)
    </li>
  </ul>
</ol> 

[📌 목차로 이동](#-목차)
<br><br>

## 📕 주요기능
### 기능별 미리보기 영상입니다. <br>자세한 영상과 설명은 6번의  " 📽️ 시연영상 " 을 통하여 확인 가능합니다.
<details>
  <summary><b>1. 사용자</b> (👈 Click)</summary>
  <br>
  <markdown-accessiblity-table data-catalyst=""><table>
<thead>
<tr>
<th align="center">회원가입 기능</th>
<th align="center">로그인 기능</th>
<th align="center">비밀번호변경 기능</th>
</tr>
</thead>
<tbody>
<tr>
<td><img src="https://github.com/user-attachments/assets/2e4174dd-9120-4a6f-b9b1-8ab93c4fa950">
</td>
<td><img src="https://github.com/user-attachments/assets/6c9157ae-3fea-4ccb-8a72-d2d897050fe0"></td>
<td><img src="https://github.com/user-attachments/assets/09518fe6-734c-4fa6-a554-cf2d67f238c9"></td>
</tr>
</tbody>
</table></markdown-accessiblity-table>
<markdown-accessiblity-table data-catalyst=""><table>
<thead>
<tr>
<th align="center">검진등록 기능</th>
<th align="center">결과보기 기능</th>
</tr>
</thead>
<tbody>
<tr>
<td><img src="https://github.com/user-attachments/assets/fbcfccc2-2642-415d-9db1-674f22840b5c"></td>
<td><img src="https://github.com/user-attachments/assets/71a24811-56cb-4aea-a69b-cd87d5084958"></td>
</tr>
</tbody>
</table></markdown-accessiblity-table>
</details>

<details>
  <summary><b>2. 관리자</b> (👈 Click)</summary>
  <br>
  <markdown-accessiblity-table data-catalyst=""><table>
  <thead>
  <tr>
  <th align="center">검진등록 기능</th>
  <th align="center">결과보기 기능</th>
  </tr>
  </thead>
  <tbody>
  <tr>
  <td><img src="https://github.com/user-attachments/assets/fbcfccc2-2642-415d-9db1-674f22840b5c"></td>
  <td><img src="https://github.com/user-attachments/assets/71a24811-56cb-4aea-a69b-cd87d5084958"></td>
  </tr>
  </tbody>
  </table></markdown-accessiblity-table>
  | 로그인 | 도서 등록 | 
  |:---:|:---:|
  | <img src="https://github.com/user-attachments/assets/831184b3-acf1-4682-afb7-5cacabad3311" width="300" alt="로그인"> | <img src="https://github.com/user-attachments/assets/aae5f0bb-81d7-48fd-bc9f-19a88eedbbdb" width="300" alt="도서 등록">  |

  | 도서 수정 | 도서 삭제 | 
  |:---:|:---:|
  | <img src="https://github.com/user-attachments/assets/9409b94c-e20c-4315-80d0-4d616670de13" width="300" alt="도서 수정"> | <img src="https://github.com/user-attachments/assets/8367dade-e6f4-48f9-b30a-63a95f9fa66b" width="300" alt="도서 삭제">  |

</details><br>

[📌 목차로 이동](#-목차)
<br><br>

## 📖 요구사항 정의서 및 개발일정
<details>
  <summary><b>📑 요구사항 정의서</b> (👈 Click)</summary>
  <br>
    <img src="https://github.com/user-attachments/assets/a1060dda-2a09-4875-b3ea-8341af549748" alt="요구사항 정의서"><br>
</details>
<details>
  <summary><b>📑 개발 일정</b> (👈 Click)</summary>
  <br>
    <img src="https://github.com/user-attachments/assets/4f69fc22-081a-476c-b84b-16bea5ea644c" alt="개발 일정"><br>
</details><br>
[📌 목차로 이동](#-목차)
<br><br>

## 🏗️ E-R Model & ERD
![ERD](https://github.com/user-attachments/assets/aa83547b-a776-491c-8e66-a0f14df3b2dd)<br><br>
[📌 목차로 이동](#-목차)
<br><br>

## 🔧 프로토타입
###  페이퍼 프로토타입을 진행해 전체적인 GUI 인터페이스를 디자인 함
<details>
  <summary><b>1. 메인 GUI 화면</b> (👈 Click)</summary>
  <br>
  <ul>
    <li>
      페이퍼 프로토타입
    </li>
    <img src="https://github.com/user-attachments/assets/7bb558f4-4bdc-48b5-93ce-a354c95b04e9" alt="페이퍼 프로토타입"><br><br>
    <li>
      결과 화면
    </li>
    <img src="https://github.com/user-attachments/assets/e53e53d1-1444-4c28-8d18-d395ac0942e5" alt="페이퍼 프로토타입"><br>
  </ul>
</details><br>
<details>
  <summary><b>2. 사용자 GUI 화면</b> (👈 Click)</summary>
  <br>
  <ul>
    <li>
      페이퍼 프로토타입
    </li>
    <img src="https://github.com/user-attachments/assets/e8228ec5-8b15-440d-898e-f9d9e96112c3" alt="페이퍼 프로토타입"><br><br>
    <li>
      결과 화면
    </li>
    <img src="https://github.com/user-attachments/assets/cf3b487e-42b1-48f5-9b66-fbc89872d23d" alt="페이퍼 프로토타입"><br>
  </ul>
</details><br>
<details>
  <summary><b>3. 관리자 GUI 화면</b> (👈 Click)</summary>
  <br>
  <ul>
    <li>
      페이퍼 프로토타입
    </li>
    <img src="https://github.com/user-attachments/assets/9387222a-e637-45a2-81fd-f35297fe342d" alt="페이퍼 프로토타입"><br><br>
    <li>
      결과 화면
    </li>
    <img src="https://github.com/user-attachments/assets/b616c9df-7eb6-4cf8-a61e-0d8769f64e7c" alt="페이퍼 프로토타입"><br>
  </ul>
</details><br>

[📌 목차로 이동](#-목차)
<br><br>

## 📽️ 시연영상
[[📹 시연영상]](https://www.youtube.com/playlist?list=PLNdYfRO3wDinaMKtuWkmtTtOvFhH2CDyz)<br>

[📌 목차로 이동](#-목차)
<br><br>

## 🗃️ 발표자료
[[📂 발표자료]](https://drive.google.com/file/d/1pfXYrpNl6nnI-E_PgnhFF8bp2JPUD7gy/view?usp=sharing)<br>

[📌 목차로 이동](#-목차)
